package io.abner.vertxapp;

import io.vertx.core.Future;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

import io.vertx.serviceproxy.ProxyHelper;
import io.vertx.serviceproxy.ServiceBinder;
import io.vertx.serviceproxy.ServiceProxyBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainVerticle extends AbstractVerticle {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainVerticle.class);
    private MyService myService;

    public static void main(String[] args) {
        Vertx.vertx().deployVerticle(MainVerticle.class.getSimpleName(), ok -> {
            if (ok.succeeded()) {
                LOGGER.info("Verticle inicializado com sucesso!");
            }
        });
    }

    private void setupServiceProxy() {
        myService = new ServiceProxyBuilder(vertx).setAddress(MyService.ADDRESS).build(MyService.class);
    }

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        LOGGER.info("Starting MainVerticle...");

        vertx.deployVerticle(VerticleWithService.class.getName(), ok -> {
            this.setupServiceProxy();

            Router router = Router.router(vertx);
            router.route().handler(BodyHandler.create());
            router.get("/ready").handler(this::getReady);
            router.get("/version").handler(this::getVersion);
            router.post("/call-service").handler(this::callService);
            vertx.createHttpServer().requestHandler(router::accept).listen(8080);


            startFuture.complete();
            LOGGER.info("MainVerticle started!");
        });
    }

    public void getReady(RoutingContext context) {
        context.response().end("The server is OK");
    }

    public void getVersion(RoutingContext context) {
        context.response().end("{ \"version\": \"0.1.0\"}");
    }

    public void callService(RoutingContext context) {
        myService.save(context.getBodyAsJson(), res -> {
            if (res.succeeded()) {
                context.response().end("OK");
            } else {
                context.response().setStatusCode(500).end(res.cause().getLocalizedMessage());
            }
        });

    }
}