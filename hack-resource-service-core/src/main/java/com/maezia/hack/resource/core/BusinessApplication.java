package com.maezia.hack.resource.core;

import com.maezia.ezia.common.exceptionhandler.service.EnableServiceGlobalExceptionHandler;
import com.maezia.ezia.common.requestlog.EnableRequestLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author : ChenRan
 * @date ： 2023/8/1 18:24
 * Description ：BusinessApplication
 * project ：hack-resource-service-parent
 * dep : TT-32
 * company: MA
 */
@EnableRequestLog
@EnableWebMvc
@EnableFeignClients
@EnableServiceGlobalExceptionHandler
@ConfigurationPropertiesScan
@ComponentScan({"com.maezia.hack.resource.core","com.maezia.hack.resource.common.config"})
@SpringBootApplication
public class BusinessApplication {
    /**
     * 主方法
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class, args);
    }
}
