package io.abner.vertxapp;

import io.vertx.core.Future;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainVerticle extends AbstractVerticle {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainVerticle.class);
    
    public static void main(String[] args) {
        Vertx.vertx().deployVerticle(MainVerticle.class.getSimpleName(), ok -> {
            if (ok.succeeded()) {
                LOGGER.info("Verticle inicializado com sucesso!");
            }
        });
    }


    @Override
	public void start(Future<Void> startFuture) throws Exception {
		Router router = Router.router(vertx);
        router.get("/ready").handler(this::getReady);
        router.get("/version").handler(this::getVersion);
        vertx.createHttpServer().requestHandler(router::accept).listen(8080);
        startFuture.complete();
    }

    public void getReady(RoutingContext context) {
		context.response().end("The server is OK");
	}

	public void getVersion(RoutingContext context) {
		context.response().end("{ \"version\": \"0.1.0\"}");
	}
}