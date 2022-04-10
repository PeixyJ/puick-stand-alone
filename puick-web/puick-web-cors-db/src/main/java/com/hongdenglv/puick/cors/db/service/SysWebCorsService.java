package com.hongdenglv.puick.cors.db.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hongdenglv.puick.common.dto.RequestPage;
import com.hongdenglv.puick.cors.db.dao.SysWebCors;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hongdenglv.puick.cors.db.dto.CorsContentDTO;

import java.util.List;

public interface SysWebCorsService extends IService<SysWebCors> {

    /**
     * 新增跨域内容
     *
     * @param dto
     * @return void
     * @author PeiXy_J
     * @since 14:31 2022-4-10
     */
    void addCorsContent(CorsContentDTO dto);

    /**
     * 删除跨域内容
     *
     * @param ids
     * @return void
     * @author PeiXy_J
     * @since 14:31 2022-4-10
     */
    void deleteCorsContent(List<Long> ids);

    /**
     * 获取跨域分页
     *
     * @param page
     * @param dto
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.hongdenglv.puick.cors.db.dao.SysWebCors>
     * @author PeiXy_J
     * @since 14:31 2022-4-10
     */
    public Page<SysWebCors> getCorsContent(Page<SysWebCors> corsPage, CorsContentDTO dto);


    /**
     * 重新加载跨域信息
     *
     * @author PeiXy_J
     * @since 15:49 2022-4-10
     */
    void reloadCors();


}
