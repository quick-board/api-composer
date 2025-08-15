package com.quickboard.apicomposer.common.feign;

import com.quickboard.apicomposer.profile.dto.ProfileBulkRequest;
import com.quickboard.apicomposer.profile.dto.ProfileOriginResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "resource-profile")
public interface ProfileClient {

    @GetMapping("/rsc/v1/profiles/{id}")
    ProfileOriginResponse getProfile(@PathVariable("id") Long profileId);

    @GetMapping("/rsc/v1/profiles/me")
    ProfileOriginResponse getMyProfile(@RequestHeader("x-account-id") Long accountId);

    @PostMapping("/rsc/v1/profiles/bulk")
    List<ProfileOriginResponse> getProfilesByIds(@RequestBody ProfileBulkRequest profileBulkRequest);
}
