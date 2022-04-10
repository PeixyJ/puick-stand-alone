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
      # 默认 /** 拦截地址 
      cors-path: /**
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
      # allowed-all: true
      # true 全部放行
      allowed-all: false
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/puick
    username: root
    password:
    driverClassName: com.mysql.cj.jdbc.Driver
```

即可完成跨域配置.

## 接口

⚠️ 接口必须进行权限管理做好内容拦截

1. /api/system/cors POST 新增跨域
2. /api/system/cors DELETE 删除跨域
3. /api/system/cors/reload POST 重新加载跨域信息
4. /api/system/cors/page POST 查询跨域内容

接口详细信息: [详细内容](easy-api.md)

## 检查应用是否启用

可用在启动程序控制台中查看日志

`quick cors allowed all!` 是全部放行跨域信息

`quick cors allowed to be selected!` 是有选择性放行跨域信息