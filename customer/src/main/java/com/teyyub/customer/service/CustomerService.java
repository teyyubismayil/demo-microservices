package com.teyyub.customer.service;

import com.teyyub.clients.fraud.FraudClient;
import com.teyyub.clients.notification.NotificationClient;
import com.teyyub.customer.model.Customer;
import com.teyyub.customer.model.CustomerRegistrationRequest;
import com.teyyub.customer.repository.CustomerRepository;
import com.teyyub.models.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final FraudClient fraudClient;
    private final CustomerRepository repository;
    private final NotificationClient notificationClient;

    @Transactional
    public void registerCustomer(CustomerRegistrationRequest registrationRequest) {
        var customer = Customer.builder()
                .firstName(registrationRequest.firstName())
                .lastName(registrationRequest.lastName())
                .email(registrationRequest.email())
                .build();
        repository.saveAndFlush(customer);
        if (fraudClient.isFraudster(customer.getId()).isFraudster()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You are a fraudster");
        }
        notificationClient.sendNotification(
                new NotificationRequest(
                        String.format("Thanks for registration, %s!", customer.getFirstName()),
                        customer.getId()
                )
        );
    }
}
