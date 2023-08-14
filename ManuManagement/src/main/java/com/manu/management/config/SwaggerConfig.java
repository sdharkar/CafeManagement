//package com.manu.management.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//	
//	@Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//            .select()
//            .apis(RequestHandlerSelectors.basePackage("com.manu.management"))
//            .paths(PathSelectors.any())
//            .build()
//            .apiInfo(getInfo());
//    }
//
//	private ApiInfo getInfo() {
//	    return new ApiInfoBuilder()
//	        .title("Cafe Management WebApp: JFS+Angular")
//	        .description("This project is developed for cafe managment")
//	        .version("1.0")
//	        .build();
//	}
//
//
//}
//
