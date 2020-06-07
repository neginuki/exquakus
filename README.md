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


