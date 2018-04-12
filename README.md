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
