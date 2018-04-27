package com.sisint.generador.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.sisint.common.controllers.CommonAction;
import com.sisint.generador.handler.GeneradorHandler;
import com.sisint.generador.resources.GeneradorResource;
import play.Logger;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;

import javax.inject.Inject;
import java.io.IOException;
import java.util.concurrent.CompletionStage;

@With(CommonAction.class)
public class GeneradorArchivoController extends Controller {
    private final Logger.ALogger logger = play.Logger.of("application.GeneradorArchivoController");


    private HttpExecutionContext ec;
    private GeneradorHandler handler;

    @Inject
    public GeneradorArchivoController(HttpExecutionContext ec, GeneradorHandler handler) {
        this.ec = ec;
        this.handler = handler;
    }

    public CompletionStage<Result> generarArchivo() throws IOException {
        JsonNode json = request().body().asJson();
        final GeneradorResource resource = Json.fromJson(json, GeneradorResource.class);

        if (logger.isDebugEnabled()) {
            logger.debug("generarTxt() resource = " + resource);
        }

        //final PostResource resource = Json.fromJson(json, PostResource.class);
        return handler.generarArchivo(resource).thenApplyAsync(savedResource -> {
            return created(Json.toJson(savedResource));
        }, ec.current());
    }
}
