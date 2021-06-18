package com.rulesservice;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * @author Saaketh
 *
 */
@EnableFeignClients
@EnableSwagger2
@SpringBootApplication
public class RulesServiceApplication {
	//To run rules microservice
	/**
	 * @param args
	 * main method
	 */
	public static void main(String[] args) {
		SpringApplication.run(RulesServiceApplication.class, args);
	}
	
	
	/**
	 * @return Docket
	 */
	@Bean
	//Swagger fetching the mapping from rules Controller
	public Docket swaggerConfiguration() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.rulesservice.controller")).build().apiInfo(apiInfo());

	}
//Extra information in swagger
	/**
	 * @return ApiInfo
	 */
	private ApiInfo apiInfo() {
		return new ApiInfo("RulesService", "MFPE project service", "API", "Terms of service",
				new Contact("Peoples Bank", "", "abcbanking@gmail.com"), "License of API", "", Collections.emptyList());
	}
}
