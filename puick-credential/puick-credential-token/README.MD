# puick-credential-token

给Web项目加上一个简单的 Token 作为拦截器，以防止恶意访问。

## 配置文件

```properties
#凭证名称
puick.credential.token.credential=默认puick
#凭证为空则自动生成
puick.credential.token.token=默认自动生成
#凭证为空时是否自动生成
puick.credential.token.generateTokenFile=false
#凭证文件生成路径
puick.credential.token.generateTokenPath=默认启动目录下 token 文件
#盐值
puick.credential.token.salt=加密时进行加盐操作
#是否在程序启动时告知凭证和Token
puick.credential.token.informCredentialToken=false
```

## 使用方法

### Pom

```xml

<dependency>
    <groupId>com.hongdenglv</groupId>
    <artifactId>puick-credential-token</artifactId>
    <version>${puick-credential-token.version}</version>
</dependency>
```

### 启动

启动项目查看控制台打印的凭证信息

### 使用

在HTTP请求中消息头添加 对应凭证即可

例如:

curl

```shell
curl --location --request POST 'http://127.0.0.1:8080' \
--header 'puick: 37321263-9184-4c86-85cd-4959a095d61e' \
--data-raw ''
```

okHttp

```java
public class Application {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("http://127.0.0.1:8080")
                .method("POST", body)
                .addHeader("puick", "37321263-9184-4c86-85cd-4959a095d61e")
                .build();
        Response response = client.newCall(request).execute();
    }
}
```