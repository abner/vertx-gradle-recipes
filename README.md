# vertx-gradle-recipes
Useful Gradle Recipes to be used with Vertx Applications

## Usage:

```gradle
// load the repositories definitions file
apply from: 'https://github.com/abner/vertx-gradle-recipes/raw/master/repositories.gradle'

// here you can choose another vertx version to use
ext.vertxVersion = '3.7.1'

// verticle which will be started within your application
ext.mainVerticleName = 'io.abner.vertxapp.MainVerticle'

// load vertx dependencies and tasks
apply from: 'https://github.com/abner/vertx-gradle-recipes/raw/master/vertx.gradle'

```

## AVAILABLE RECIPES:

* Vert.x [https://github.com/abner/vertx-gradle-recipes/raw/master/vertx.gradle](https://github.com/abner/vertx-gradle-recipes/raw/master/vertx.gradle)

  - ShadowJar packaging
  - Run with Livereload
  - Metrics with prometheus endpoint ready
  - Service Proxy Generator if anotatted Service and package-info were in place

* Vert.x Sync[https://github.com/abner/vertx-gradle-recipes/raw/master/vertx-sync.gradle](https://github.com/abner/vertx-gradle-recipes/raw/master/vertx-sync.gradle)

  - Vertx-Sync Ready
  - Instrument @Suspendable with Quasar AOT Instrumentation

* Testing [https://github.com/abner/vertx-gradle-recipes/raw/master/testing.gradle](https://github.com/abner/vertx-gradle-recipes/raw/master/testing.gradle)

   - Tests dependencies
   
   - Tests traditioonal convention: Suffix `Test` for Unitary, and `ITTest` for integration
   
   - Integration task builds the shadowJar, starts the server and wait for service before starts running the IT Tests

```bash
./gradlew itTest
```


# NOTES

> We could not upgrade to gradle 4.7 or superior because of these issues: https://github.com/vert-x3/vertx-codegen/issues/181, https://github.com/vorburger/minecraft-storeys-maker/issues/53

No Service Proxy is generated

