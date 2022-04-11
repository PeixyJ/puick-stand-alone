# puick-notification-bark

使用IOS软件 BARK 进行消息通知.

软件项目在此 [bark-server](https://github.com/Finb/bark-server)

## 配置文件

```yaml
puick:
  notification:
    bark:
      # 不填默认spring.application.name
      barkTitle: Bark
      # 服务器地址
      apiAddress: https://api.day.app/push/
      # 图标url
      iconUrl: https://puick.io/favicon.ico
      # 目标设备
      token: <token>
      # 跳转页面
      jumpUrl: https://puick.io/
```

## 使用方法

### Pom

```xml

<dependency>
    <groupId>com.hongdenglv</groupId>
    <artifactId>puick-notification-bark</artifactId>
    <version>${puick-notification-bar.version}</version>
</dependency>
```

### 配置

配置application.yml

```yaml
puick:
  notification:
    bark:
      # 不填默认spring.application.name
      barkTitle: Bark
      # 服务器地址
      apiAddress: https://api.day.app/push/
      # 图标url
      iconUrl: https://puick.io/favicon.ico
      # 目标设备
      token: <token>
      # 跳转页面
      jumpUrl: https://puick.io/
```

### 使用

```java
import com.hongdenglv.puick.notification.bark.BarkRequest;
import com.hongdenglv.puick.notification.bark.util.BarkUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class demo {

    @Autowired
    BarkUtils barkUtils;

    public void sendQuickNotice() {
        if (barkUtils.quickNotice("Hello")) {
            System.out.println("发送成功");
        } else {
            System.out.println("发送失败");
        }
    }


    public void sendNotice() {
        BarkRequest request = new BarkRequest();
        request.setBody("Hello");
        if (barkUtils.notice(request)) {
            System.out.println("发送成功");
        } else {
            System.out.println("发送失败");
        }
    }

}





```