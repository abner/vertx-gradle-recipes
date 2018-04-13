package io.abner.vertxapp;

import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

@ProxyGen
@VertxGen
public interface MyService {

    public static final String ADDRESS = "MYSERVICE-CHANNEL";
    /**
     * Create a MyService implementation.
     * @param vertx vertx
     * @return MyService
     */
    static MyService create(final Vertx vertx) {
        return new MyServiceImpl(vertx);
    }

    //static MyService createProxy(Vertx vertx, String address) {
    //    return MyServiceVertxEBProxy(vertx, address);
    //}

    void save(JsonObject document, Handler<AsyncResult<Void>> resultHandler);
}