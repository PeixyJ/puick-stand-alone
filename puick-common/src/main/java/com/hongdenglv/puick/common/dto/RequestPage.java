package com.hongdenglv.puick.common.dto;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.org.apache.xalan.internal.xsltc.dom.SingletonIterator;
import lombok.Data;

import java.util.List;

/**
 * 请求分页
 *
 * @author PeiXy_J
 * @date 2022-4-10 14:19
 */
@Data
public class RequestPage<T> {

    /**
     * 当前页
     */
    private Integer pageNum = 1;

    /**
     * 每页数量
     */
    private Integer maxSize = 10;

    /**
     * 查询条件
     */
    private T query;

    /**
     * 排序条件
     */
    private List<OrderItem> orderItems;

    /**
     * 获取分页对象
     * 需要请求对象和返回对象相同时使用
     * <p>
     * 外网不建议使用,会让攻击者知道表结构
     */
    public Page<T> toPage() {
        Page<T> page = new Page<>(pageNum, maxSize);
        page.setOrders(orderItems);
        return page;
    }

}