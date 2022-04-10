package com.hongdenglv.puick.cors.db.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 系统 - Web跨域
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_web_cors")
public class SysWebCors {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 允许的类型 0: origin 1: header 2: method
     */
    @TableField(value = "allowed_type")
    private Integer allowedType;

    /**
     * 允许的内容
     */
    @TableField(value = "allowed_content")
    private String allowedContent;

    /**
     * 创建人ID
     */
    @TableField(value = "creator")
    private Long creator;

    /**
     * 创建时间
     */
    @TableField(value = "creation_time")
    private Date creationTime;

    public static final String COL_ID = "id";

    public static final String COL_ALLOWED_TYPE = "allowed_type";

    public static final String COL_ALLOWED_CONTENT = "allowed_content";

    public static final String COL_CREATOR = "creator";

    public static final String COL_CREATION_TIME = "creation_time";
}