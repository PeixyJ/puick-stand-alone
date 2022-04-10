package com.hongdenglv.puick.cors.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hongdenglv.puick.cors.db.config.WebCorsConfiguration;
import com.hongdenglv.puick.cors.db.dto.CorsContentDTO;
import com.hongdenglv.puick.cors.db.property.CorsProperty;
import com.hongdenglv.puick.cors.db.service.SysCurrentUser;
import com.hongdenglv.puick.cors.db.service.SysWebCorsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hongdenglv.puick.cors.db.mapper.SysWebCorsMapper;
import com.hongdenglv.puick.cors.db.dao.SysWebCors;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class SysWebCorsServiceImpl extends ServiceImpl<SysWebCorsMapper, SysWebCors> implements SysWebCorsService {

    private ApplicationContext applicationContext;

    WebCorsConfiguration webCorsConfiguration;

    CorsProperty corsProperty;

    SysCurrentUser sysCurrentUser;

    @Override
    public void addCorsContent(CorsContentDTO dto) {
        LambdaQueryWrapper<SysWebCors> query = new LambdaQueryWrapper<>();
        query.eq(SysWebCors::getAllowedType, dto.getAllowedType());
        query.eq(SysWebCors::getAllowedType, dto.getAllowedContent());
        if (count(query) == 0) {
            SysWebCors sysWebCors = new SysWebCors();
            BeanUtils.copyProperties(dto, sysWebCors);
            sysWebCors.setCreationTime(new Date());
            sysWebCors.setCreator(sysCurrentUser.getUserId());
            save(sysWebCors);
        }
    }

    @Override
    public void deleteCorsContent(List<Long> ids) {
        removeBatchByIds(ids);
    }

    @Override
    public Page<SysWebCors> getCorsContent(Page<SysWebCors> corsPage, CorsContentDTO dto) {
        LambdaQueryWrapper<SysWebCors> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(dto.getAllowedType() != null, SysWebCors::getAllowedType, dto.getAllowedType());
        queryWrapper.eq(dto.getAllowedContent() != null, SysWebCors::getAllowedContent, dto.getAllowedContent());
        return page(corsPage, queryWrapper);
    }

    @Override
    public void reloadCors() {
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
        CorsFilter corsFilter = (CorsFilter) defaultListableBeanFactory.getBean("corsFilter");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration(corsProperty.getCorsPath(), webCorsConfiguration.buildCorsConfiguration());
        corsFilter.setConfigSource(source);
        log.info("puick-cors-db reload Cors success");
    }
}
