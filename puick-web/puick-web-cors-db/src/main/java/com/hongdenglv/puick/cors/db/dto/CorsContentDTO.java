package com.hongdenglv.puick.cors.db.dto;

import lombok.Data;

/**
 * 跨域内容DTO
 *
 * @author PeiXy_J
 * @date 2022-4-10 14:06
 */
@Data
public class CorsContentDTO {
    /**
     * 跨域内容属性
     */
    private Integer allowedType;

    /**
     * 允许内容
     */
    private String allowedContent;

}
