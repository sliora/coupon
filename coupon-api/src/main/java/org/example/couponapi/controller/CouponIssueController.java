package org.example.couponapi.controller;

import lombok.RequiredArgsConstructor;
import org.example.couponapi.controller.dto.CouponIssueRequestDto;
import org.example.couponapi.controller.dto.CouponIssueResponseDto;
import org.example.couponapi.service.CouponIssueRequestService;
import org.example.couponcore.model.Coupon;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CouponIssueController {
    private final CouponIssueRequestService couponIssueRequestService;

    @PostMapping("/v1/issue")
    public CouponIssueResponseDto issueV1(@RequestBody CouponIssueRequestDto body) {
        couponIssueRequestService.issueRequestV1(body);
        return new CouponIssueResponseDto(true, null);
    }
}
