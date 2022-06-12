package com.teyyub.fraud.controller;

import com.teyyub.fraud.model.FraudCheckResponse;
import com.teyyub.fraud.service.FraudCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/fraud-check")
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @PostMapping("/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") long customerId) {
        return new FraudCheckResponse(
                fraudCheckService.isFraudulentCustomer(customerId)
        );
    }
}
