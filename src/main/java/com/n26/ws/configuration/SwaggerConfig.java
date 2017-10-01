package com.n26.ws.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket analyticsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.n26.ws.controllers"))
                .paths(regex(".*"))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return  new ApiInfo(
                "Spring Boot REST API",
                "Spring Boot REST API N26 Case Study",
                "0.0.1",
                "Terms of service",
                new Contact("Abhishekkumar Rai", "http://www.n26s.com", "abhisheksavitarai@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
    }
}
