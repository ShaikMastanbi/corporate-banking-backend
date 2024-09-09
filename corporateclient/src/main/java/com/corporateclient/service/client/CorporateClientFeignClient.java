package com.corporateclient.service.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "CORPORATECLIENT", url = "http://localhost:9044")
public interface CorporateClientFeignClient {
}
