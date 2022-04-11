package com.hongdenglv.puick.notification.bark;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Notice请求
 *
 * @author PeiXy_J
 * @date 2022-4-10 21:13
 */
@Data
@Builder
@NoArgsConstructor
public class BarkRequest {


    /**
     * 标题
     */
    @JsonProperty("title")
    private String title;

    /**
     * 内容
     */
    @JsonProperty("body")
    private String body;

    /**
     * 目标用户Token
     */
    @JsonProperty("device_key")
    private String deviceKey;

    /**
     * 等级
     */
    @JsonProperty("level")
    private String level;

    /**
     * 角标
     */
    @JsonProperty("badge")
    private Integer badge;

    /**
     * 自动复制
     * 必须是1
     */
    @JsonProperty("automaticallyCopy")
    private String automaticallyCopy;

    /**
     * 手动复制
     */
    @JsonProperty("copy")
    private String copy;

    /**
     * 声音
     */
    @JsonProperty("sound")
    private String sound;

    /**
     * 图标
     * 图标 URL地址
     */
    @JsonProperty("icon")
    private String icon;

    /**
     * 分组
     */
    @JsonProperty("group")
    private String group;

    /**
     * 点击通知跳转
     */
    @JsonProperty("url")
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDeviceKey() {
        return deviceKey;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getBadge() {
        return badge;
    }

    public void setBadge(Integer badge) {
        this.badge = badge;
    }

    public String getAutomaticallyCopy() {
        return automaticallyCopy;
    }

    public void setAutomaticallyCopy(String automaticallyCopy) {
        this.automaticallyCopy = automaticallyCopy;
    }

    public String getCopy() {
        return copy;
    }

    public void setCopy(String copy) {
        this.copy = copy;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public void setSound(BellEnum bellEnum) {
        this.sound = bellEnum.getBellName();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BarkRequest(String title, String body, String deviceKey, String level, Integer badge, String automaticallyCopy, String copy, String sound, String icon, String group, String url) {
        this.title = title;
        this.body = body;
        this.deviceKey = deviceKey;
        this.level = level;
        this.badge = badge;
        this.automaticallyCopy = automaticallyCopy;
        this.copy = copy;
        this.sound = sound;
        this.icon = icon;
        this.group = group;
        this.url = url;
    }

    public BarkRequest(String body, String level, Integer badge, String automaticallyCopy, String copy, String sound, String icon, String group, String url) {
        this.body = body;
        this.level = level;
        this.badge = badge;
        this.automaticallyCopy = automaticallyCopy;
        this.copy = copy;
        this.sound = sound;
        this.icon = icon;
        this.group = group;
        this.url = url;
    }
}
