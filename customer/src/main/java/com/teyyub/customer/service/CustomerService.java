package com.teyyub.customer.service;

import com.teyyub.customer.model.Customer;
import com.teyyub.customer.model.CustomerRegistrationRequest;
import com.teyyub.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public void registerCustomer(CustomerRegistrationRequest registrationRequest) {
        var customer = Customer.builder()
                .firstName(registrationRequest.firstName())
                .lastName(registrationRequest.lastName())
                .email(registrationRequest.email())
                .build();
        repository.save(customer);
    }
}
