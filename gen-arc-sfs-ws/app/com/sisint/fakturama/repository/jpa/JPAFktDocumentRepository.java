package com.sisint.fakturama.repository.jpa;

import com.sisint.fakturama.models.FktDocument;
import com.sisint.fakturama.repository.FakturamaExecutionContext;
import com.sisint.fakturama.repository.FktDocumentRepository;
import net.jodah.failsafe.CircuitBreaker;
import net.jodah.failsafe.Failsafe;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Optional;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;


import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * A repository that provides a non-blocking API with a custom execution context
 * and circuit breaker.
 */
@Singleton
public class JPAFktDocumentRepository implements FktDocumentRepository {

    private final JPAApi jpaApi;
    private final FakturamaExecutionContext ec;
    private final CircuitBreaker circuitBreaker = new CircuitBreaker().withFailureThreshold(1).withSuccessThreshold(3);

    @Inject
    public JPAFktDocumentRepository(JPAApi api, FakturamaExecutionContext ec) {
        this.jpaApi = api;
        this.ec = ec;
    }

    @Override
    public CompletionStage<Optional<FktDocument>> getByNumber(String number) {
        return supplyAsync(() -> wrap(em -> Failsafe.with(circuitBreaker).get(() -> selectByNumber(em, number))), ec);
    }
/*
    @Override
    public CompletionStage<Stream<PostData>> list() {
        return supplyAsync(() -> wrap(em -> select(em)), ec);
    }

    @Override
    public CompletionStage<PostData> create(PostData postData) {
        return supplyAsync(() -> wrap(em -> insert(em, postData)), ec);
    }

    @Override
    public CompletionStage<Optional<PostData>> get(Long id) {
        return supplyAsync(() -> wrap(em -> Failsafe.with(circuitBreaker).get(() -> lookup(em, id))), ec);
    }

    @Override
    public CompletionStage<Optional<PostData>> update(Long id, PostData postData) {
        return supplyAsync(() -> wrap(em -> Failsafe.with(circuitBreaker).get(() -> modify(em, id, postData))), ec);
    }
*/
    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction("fakturama",true,function);
        //return jpaApi.withTransaction(function);
    }

    private Optional<FktDocument> selectByNumber(EntityManager em, String number) {
        TypedQuery<FktDocument> query = em.createQuery("SELECT d FROM FktDocument d WHERE d.NAME = :par01", FktDocument.class);
        query.setParameter("par01", number);
        return Optional.ofNullable(query.getSingleResult());
        /*
        FktDocument result = query.getSingleResult();
        System.out.println("selectByNumber result = "+result);
        return Optional.ofNullable(result);
        */
    }

/*
    private Optional<PostData> lookup(EntityManager em, Long id) throws SQLException {
        throw new SQLException("Call this to cause the circuit breaker to trip"); //Generando error de CircuitBreaker
        //return Optional.ofNullable(em.find(PostData.class, id));
    }

    private Stream<PostData> select(EntityManager em) {
        TypedQuery<PostData> query = em.createQuery("SELECT p FROM PostData p", PostData.class);
        return query.getResultList().stream();
    }

    private Optional<PostData> modify(EntityManager em, Long id, PostData postData) throws InterruptedException {
        final PostData data = em.find(PostData.class, id);
        if (data != null) {
            data.title = postData.title;
            data.body = postData.body;
        }
        Thread.sleep(10000L); //Generando error de CircuitBreaker
        return Optional.ofNullable(data);
    }

    private PostData insert(EntityManager em, PostData postData) {
        return em.merge(postData);
    }
*/
}
