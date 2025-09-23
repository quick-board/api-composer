package com.quickboard.apicomposer.common.feign.client;

import com.quickboard.apicomposer.account.dto.AccountCreate;
import com.quickboard.apicomposer.common.feign.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "auth", configuration = FeignConfig.class)
public interface AccountClient {
    @PostMapping("/api/v1/accounts")
    Long postAccount(@RequestBody AccountCreate accountCreate);
}
