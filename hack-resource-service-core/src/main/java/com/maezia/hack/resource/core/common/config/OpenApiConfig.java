package com.maezia.hack.resource.core.common.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : ChenRan
 * @date ： 2023/8/1 20:07
 * Description ：OpenApiConfig
 * project ：tgsop-tgsop-service-parent
 * dep : TT-32
 * company: MA
 */
@Configuration
public class OpenApiConfig {

    @Value("${springdoc.server.url:#{null}}")
    private String serverUrl;

    @Bean
    public OpenAPI springOpenAPI() {
        OpenAPI openAPI = new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("hack resource service core")
                        .description("hack resource service core")
                        .version("0.0.1"));
        if (serverUrl != null) {
            openAPI.addServersItem(new Server().url(serverUrl));
        }
        return openAPI;
    }
}
