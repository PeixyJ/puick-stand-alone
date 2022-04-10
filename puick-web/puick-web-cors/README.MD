# puick cors 跨域模块

跨域同源策略（Sameoriginpolicy）是一种约定，它是浏览器最核心也最基本的安全功能，如果缺少了同源策略，则浏览器的正常功能可能都会受到影响。

[详细描述](https://zhuanlan.zhihu.com/p/425855609)

## 配置文件

```yaml

puick:
  web:
    cors:
      # 是否放行全部默认false
      allowed-all: false
      # 允许放行的源地址
      allowed-origin-list:
        - https://blog.csdn.net
        - https://www.sojson.com
        - https://www.baidu.com
      # 默认放行的消息头
      allowed-header-list:
        - puick
      # 默认放行的请求METHOD
      allowed-method-list:
        - POST

```

## 使用方式

引入Pom

```xml

<dependency>
    <groupId>com.hongdenglv</groupId>
    <artifactId>puick-web-cors</artifactId>
    <version>${puick-web-cors.version}</version>
</dependency>
```

配置application.yml

```yaml
puick:
  web:
    cors:
      allowed-all: true
```
即可完成跨域配置.

## 检查应用是否启用

可用在启动程序控制台中查看日志 

`quick cors allowed all!` 是全部放行跨域信息

`quick cors allowed to be selected!` 是有选择性放行跨域信息