package com.quickboard.apicomposer.account.controller;

import com.quickboard.apicomposer.account.dto.SignUpCreate;
import com.quickboard.apicomposer.common.feign.client.AccountClient;
import com.quickboard.apicomposer.common.feign.client.ProfileClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/composition/v1")
@Slf4j
public class AccountController {

    private final AccountClient accountClient;
    private final ProfileClient profileClient;

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public Long signUp(@RequestBody SignUpCreate signUpCreate){
        Long accountId = accountClient.postAccount(signUpCreate.accountCreate());
        profileClient.postProfileInner(accountId, signUpCreate.profileCreate());

        return accountId;
    }
}
