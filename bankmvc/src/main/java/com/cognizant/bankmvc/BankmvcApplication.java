package com.cognizant.bankmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author S Nithish Kumar
 *
 */
@SpringBootApplication
@EnableSwagger2
@EnableFeignClients
public class BankmvcApplication {

	/**
	 * @param args
	 * Main Method
	 */
	public static void main(String[] args) {
		SpringApplication.run(BankmvcApplication.class, args);
	}
	

 

}
