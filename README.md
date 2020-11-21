# super-express-surcharge

[microservices-sample](https://github.com/n-ono/microservices-sample) の特急料金を計算するサービス

## ドメインモデル

![特急料金](https://user-images.githubusercontent.com/58995947/99875358-4e628b00-2c32-11eb-8976-7abcdf3585c0.png)

## 各種コマンド

下記コマンドは全てプロジェクトのルートディレクトリで実行する

### ビルド

```
$ ./gradlew clean build
```

### Docker イメージ生成

```
$ docker build -t <image-name>:<tag> -f docs/docker/Dockerfile . 
```

`<image-name>` と `<tag>` は任意の値を指定する
