package com.jwt.authentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getInfo())
				.select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
		
	}

	private ApiInfo getInfo() {
	    return new ApiInfoBuilder()
	        .title("Cafe Management WebApp: JFS+Angular")
	        .description("This project is developed for cafe managment")
	        .version("1.0")
	        .termsOfServiceUrl("")
	        .contact(new Contact("cafemanagement@example.com", "", ""))
	        .license("Apache 2.0")
	        .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0.html")
	        .build();
	}


}