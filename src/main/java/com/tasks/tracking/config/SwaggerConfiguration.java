package com.tasks.tracking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Sets;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/v1/tracking/**"))
                .apis(RequestHandlerSelectors.basePackage("com.tasks.tracking"))
                .build()
                .apiInfo(SwaggerStaticApiInfo())
                .consumes(Sets.newHashSet("application/json"))
                .produces(Sets.newHashSet("application/json"));
    }

    private ApiInfo SwaggerStaticApiInfo() {
        return new ApiInfoBuilder()
                .description("Tracking API to track status information for UPS, USPS, FEDEX")
                .title("Tracking")
                .version("1.0")
                .build();
    }
}
