package com.sisint.fakturama.repository;

import akka.actor.ActorSystem;
import play.libs.concurrent.CustomExecutionContext;

import javax.inject.Inject;

/**
 * Custom execution context wired to "fakturama.repository" thread pool
 */
public class FakturamaExecutionContext extends CustomExecutionContext {

    @Inject
    public FakturamaExecutionContext(ActorSystem actorSystem) {
        super(actorSystem, "fakturama.repository");
    }
}
