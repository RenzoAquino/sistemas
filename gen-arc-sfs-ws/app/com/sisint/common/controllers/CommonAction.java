package com.sisint.common.controllers;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import com.sisint.common.exceptions.BusinessException;
import com.sisint.common.resources.ws.FailResponse;
import com.sisint.common.resources.ws.RestResponse;
import com.sisint.generador.resources.GeneradorResource;
import net.jodah.failsafe.FailsafeException;
import play.Logger;
import play.libs.Json;
import play.libs.concurrent.Futures;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;
import play.mvc.StatusHeader;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.NoResultException;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

import static com.codahale.metrics.MetricRegistry.name;
import static java.util.concurrent.CompletableFuture.completedFuture;
import static play.mvc.Http.Status.*;

public class CommonAction extends play.mvc.Action.Simple {
    private final Logger.ALogger logger = play.Logger.of("application.CommonAction");

    private final Meter requestsMeter;
    private final Timer responsesTimer;
    private final HttpExecutionContext ec;
    private final Futures futures;

    @Singleton
    @Inject
    public CommonAction(MetricRegistry metrics, HttpExecutionContext ec, Futures futures) {
        this.ec = ec;
        this.futures = futures;
        this.requestsMeter = metrics.meter("requestsMeter");
        this.responsesTimer = metrics.timer(name(CommonAction.class, "responsesTimer"));
    }

    public CompletionStage<Result> call(Http.Context ctx) {
        if (logger.isTraceEnabled()) {
            logger.trace("call: ctx = " + ctx);
        }

        requestsMeter.mark();
        if (ctx.request().accepts("application/json")) {
            final Timer.Context time = responsesTimer.time();
            return futures.timeout(doCall(ctx), 1L, TimeUnit.SECONDS).exceptionally(e ->
                    Results.status(GATEWAY_TIMEOUT, views.html.timeout.render())
            ).whenComplete((r, e) -> time.close());
        } else {
            return completedFuture(
                    status(NOT_ACCEPTABLE, "We only accept application/json")
            );
        }
    }

    private CompletionStage<Result> doCall(Http.Context ctx) {
        return delegate.call(ctx).handleAsync((result, e) -> {
            if (e != null) {
                if (e instanceof CompletionException) {
                    Throwable completionException = e.getCause();
                    if (completionException instanceof FailsafeException) {
                        logger.error("Circuit breaker is open!", completionException);
                        return Results.status(SERVICE_UNAVAILABLE, "Service has timed out");
                    } if (completionException instanceof NoResultException) {
                        logger.error("Sin datos exception", completionException);
                        return created(Json.toJson(new RestResponse(new FailResponse("01", "No se encontraron resultados para la busqueda"))));
                    }else {
                        logger.error("Direct exception " + e.getMessage(), e);
                        //return internalServerError();
                         return created(Json.toJson(new RestResponse(new FailResponse("01", e.getMessage()))));
                    }
                }  else {
                    logger.error("Unknown exception " + e.getMessage(), e);
                    //return internalServerError();
                    return created(Json.toJson(new RestResponse(new FailResponse("01", e.getMessage()))));
                }
            } else {
                return result;
            }
        }, ec.current());
    }
}
