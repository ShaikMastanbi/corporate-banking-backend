package com.corporateclient;

import com.corporateclient.dto.CorporateClientContactInfoDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableConfigurationProperties(value = {CorporateClientContactInfoDto.class})
@EnableFeignClients
public class CorporateclientApplication {

	public static void main(String[] args) {

		SpringApplication.run(CorporateclientApplication.class, args);
		System.out.println("corporate clients");
	}
	@Bean
	public RestTemplate ClientRestTemplate(){

		return new RestTemplate();
	}

}
