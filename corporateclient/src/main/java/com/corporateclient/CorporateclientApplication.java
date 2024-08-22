package com.corporateclient;

import com.corporateclient.dto.CorporateClientContactInfoDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {CorporateClientContactInfoDto.class})
public class CorporateclientApplication {

	public static void main(String[] args) {

		SpringApplication.run(CorporateclientApplication.class, args);
		System.out.println("corporate clients");
	}

}
