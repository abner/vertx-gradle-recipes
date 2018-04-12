# vertx-gradle-recipes
Useful Gradle Recipes to be used with Vertx Applications

## Usage:

```gradle
// carrega arquivo que define os repositórios
apply from: 'https://github.com/abner/vertx-gradle-recipes/raw/master/repositories.gradle'

// define versão do Vert.x
ext.vertxVersion = '3.5.1'

// definição do Vertx que será iniciado junto à aplicação
ext.mainVerticleName = 'io.abner.vertxapp.MainVerticle'

// carrega arquivo com definicões de tasks de empacotamento e execução da aplicação
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
   
   - Tests tradiotional convention: Suffix `Test` for Unitary, and `ITTest` for integration
   
   - Integration task builds the shadowJar, starts the server and wait for service before starts running the IT Tests

```bash
./gradlew itTest
```