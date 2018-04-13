
package io.abner.vertxapp;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyServiceImpl implements MyService {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private Vertx vertx;
    public MyServiceImpl(Vertx vertx) {
        this.vertx = vertx;
    }


    @Override
    public void save(JsonObject document, Handler<AsyncResult<Void>> resultHandler) {
        LOGGER.info("SAVED document: " + document.encode());
        resultHandler.handle(Future.succeededFuture());
    }
}