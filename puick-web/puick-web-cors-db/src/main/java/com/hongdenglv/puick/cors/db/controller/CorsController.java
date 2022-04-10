package com.hongdenglv.puick.cors.db.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hongdenglv.puick.common.dto.RequestPage;
import com.hongdenglv.puick.common.vo.Result;
import com.hongdenglv.puick.cors.db.dao.SysWebCors;
import com.hongdenglv.puick.cors.db.dto.CorsContentDTO;
import com.hongdenglv.puick.cors.db.service.SysWebCorsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 跨域控制层
 *
 * @author PeiXy_J
 * @date 2022-4-10 15:52
 */
@RestController
@RequestMapping("/api/system/cors")
@AllArgsConstructor
public class CorsController {

    SysWebCorsService sysWebCorsService;

    /**
     * 新增跨域规则
     *
     * @param corsContentDTO
     * @return com.hongdenglv.puick.common.vo.Result<?>
     * @author PeiXy_J
     * @since 16:10 2022-4-10
     */
    @PostMapping
    public Result<?> addCorsContent(@RequestBody CorsContentDTO corsContentDTO) {
        sysWebCorsService.addCorsContent(corsContentDTO);
        return Result.ok();
    }

    /**
     * 删除跨域规则
     *
     * @param ids
     * @return com.hongdenglv.puick.common.vo.Result<?>
     * @author PeiXy_J
     * @since 16:10 2022-4-10
     */
    @DeleteMapping
    public Result<?> delCorsContent(@RequestBody List<Long> ids) {
        sysWebCorsService.deleteCorsContent(ids);
        return Result.ok();
    }

    /**
     * 查询跨域规则
     *
     * @param requestPage
     * @return com.hongdenglv.puick.common.vo.Result<com.baomidou.mybatisplus.extension.plugins.pagination.Page < com.hongdenglv.puick.cors.db.dao.SysWebCors>>
     * @author PeiXy_J
     * @since 16:10 2022-4-10
     */
    @PostMapping("/page")
    public Result<Page<SysWebCors>> getCorsContent(@RequestBody RequestPage<CorsContentDTO> requestPage) {
        Page<SysWebCors> webCorsPage = new Page<>(requestPage.getPageNum(), requestPage.getMaxSize());
        webCorsPage.setOrders(requestPage.getOrderItems());
        return Result.ok(sysWebCorsService.getCorsContent(webCorsPage, requestPage.getQuery() != null ? requestPage.getQuery() : new CorsContentDTO()));
    }


    /**
     * 重新加载跨域规则
     *
     * @return com.hongdenglv.puick.common.vo.Result<?>
     * @author PeiXy_J
     * @since 16:11 2022-4-10
     */
    @PostMapping("/reload")
    public Result<?> reloadCorsConfig() {
        sysWebCorsService.reloadCors();
        return Result.ok();
    }

}
