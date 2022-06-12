package com.teyyub.fraud.controller;

import com.teyyub.fraud.model.FraudCheckResponse;
import com.teyyub.fraud.service.FraudCheckService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/fraud-check")
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @GetMapping("/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") long customerId) {
        log.info("Fraud check: {}", customerId);
        return new FraudCheckResponse(
                fraudCheckService.isFraudulentCustomer(customerId)
        );
    }
}
