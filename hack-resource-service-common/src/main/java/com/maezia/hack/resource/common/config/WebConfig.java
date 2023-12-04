package com.maezia.hack.resource.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author : ChenRan
 * @date ： 2023/12/3 22:10
 * Description ：WebConfig 跨域配置
 * project ：hack-resource-service-parent
 * dep : TT-32
 * company: MA
 */

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 允许跨域访问的路径 信任所有
        registry.addMapping("/**");
    }
}
