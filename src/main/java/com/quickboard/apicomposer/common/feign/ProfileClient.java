package com.quickboard.apicomposer.common.feign;

import com.quickboard.apicomposer.profile.dto.ProfileBulkRequest;
import com.quickboard.apicomposer.profile.dto.ProfileComposableResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "resource-profile")
public interface ProfileClient {

    @GetMapping("/rsc/v1/profiles/{id}")
    ProfileComposableResponse getProfile(@PathVariable("id") Long profileId);

    @GetMapping("/rsc/v1/profiles/me")
    ProfileComposableResponse getMyProfile(@RequestHeader("x-account-id") Long accountId);

    @PostMapping("/rsc/v1/profiles/bulk")
    List<ProfileComposableResponse> getProfilesByIds(@RequestBody ProfileBulkRequest profileBulkRequest);
}
