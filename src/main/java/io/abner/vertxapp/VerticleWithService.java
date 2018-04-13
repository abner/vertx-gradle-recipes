package io.abner.vertxapp;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.serviceproxy.ServiceBinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerticleWithService extends AbstractVerticle {


    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        // Create the client object
        MyService service = new MyServiceImpl(vertx);
        // Register the handler
        new ServiceBinder(vertx).setAddress(MyService.ADDRESS).register(MyService.class, service);
        startFuture.complete();

        LOGGER.info("Verticle with Service Deployed");
    }
}
