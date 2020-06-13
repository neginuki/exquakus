#MicroProfile

## Config

参照 https://microprofile.io/project/eclipse/microprofile-config

## CORS

別プロジェクトで画面を用意して、画面から読み込むようにするために必要

参照 https://quarkus.io/guides/http-reference

application.properties
----
quarkus.http.cors=true 


## application.yaml

参照 https://quarkus.io/guides/config#yaml

#### yaml 拡張を追加する

`> gradlew addExtension --extensions="config-yaml"`

implementation 'io.quarkus:quarkus-config-yaml'
を build.gradle に追加するだけで良いっぽいが、お作法で入れた

#### yaml に書き直す

application.properties を application.yaml に編集

Eclipse の market place から yaml エディタ入れて編集した（自動整形効かない？）


## uber-run

`gradlew quarkusBuild --uber-jar`

で *-runner.jar が作成されるので

`java -jar build\exquakus-1.0.0-SNAPSHOT-runner.jar`

で起動できるようになる

## profile

yaml 上はこんな感じ

```
"%staging":
  remote:
    name: ステージング環境用リモート設定
    s3:
      url: http://10.199.256.101:8888
      accesskey: ajkfiebudjfdk343809b
      secretkey: akl33iddskeyklaei3
    api:
      timeout: 500
      log: remote_staging.log
```

実行時ではなく、作成時に指定する必要がある？

`gradlew quarkusBuild --uber-jar -Dquarkus.profile=staging`

`java -jar build\exquakus-1.0.0-SNAPSHOT-runner.jar`

こんな感じにしたら staging が読み込まれた

e.g. http://localhost:8080/configs/remote

### profile の現在値の確認

`ProfileManager.getActiveProfile()` でとるらしい。


e.g. http://localhost:8080/profile


gradlew quarkusDev で立ち上げると `dev`

`gradlew quarkusBuild --uber-jar -Dquarkus.profile=staging`
`java -jar build\exquakus-1.0.0-SNAPSHOT-runner.jar`

で立ち上げると `staging`

`set QUARKUS_PROFILE=product`
してから `java -jar build\exquakus-1.0.0-SNAPSHOT-runner.jar` だと `product`
