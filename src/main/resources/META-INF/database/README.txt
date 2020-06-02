何でDB管理しようか悩み中

一旦手動で本体を作る

create database sakedb;

workbench から File > Run SQL Script で replace-schema.sql を選択
・default schema に sakedb
・default character set に utf8mb4 で run
（この設定は他SQLでも同じ）

続いてデータを投入する。
同様に initialize 以下のファイルを上から順に実行していく。
