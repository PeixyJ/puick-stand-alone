# puick-service-receive 接收数据模块

在工作中有时候会接入第三方接口.在他们回调接口时我们不确定对方给的数据结构是怎么样的。就可以使用这个模块来进行接口数据的模拟。

## 快速使用

启动`jar`包后( java -jar puick-service-receive-1.0.0-SNAPSHOT-spring-boot.jar (jar包后添加 xxx可打印详细信息如 cookie 和 header 

访问 `http://host:8080/snap` 的 GET 方法和 POST 方法即可在控制台看到访问请求信息。(第三方调用时 直接在第三方回调地址上填上你的地址即可)

## 下载jar包

[puick-service-receive-1.0.0-SNAPSHOT-spring-boot.jar](file/puick-service-receive-1.0.0-SNAPSHOT-spring-boot.jar)

## 安装与使用

使用方式有两种

1. 打包后使用 (方便随时开启
2. 直接在IDE中使用 (方便随时修改代码

### 打包方式

打包

```shell
mvn install
```

这时 target 目录下将会有一个`puick-service-receive-1.0.0-SNAPSHOT-spring-boot.jar`文件

启动

```shell
java -jar puick-service-receive-1.0.0-SNAPSHOT-spring-boot.jar 
```

### IDE 方式

进入
`com.hongdenglv.puick.service.receive.ApplicationRun`
直接执行即可
