package com.bright.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author weiqisen
 * @date 2021/6/21 17:00
 **/


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String splitor = ";";

    @Value("${swagger2.enable}")
    private boolean enable;


    @Bean
    public Docket createDocket() {
        String basePackages = "com.bright.controller";
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackages))
                .paths(PathSelectors.any())
                .build()
                .enable(enable);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("holy——war")
                .description("圣战")
                .licenseUrl("http://www.brightking.top")
                .version("1.0")
                .build();
    }

}
