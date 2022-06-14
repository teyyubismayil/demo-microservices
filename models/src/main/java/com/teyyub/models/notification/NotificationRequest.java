package com.teyyub.models.notification;

public record NotificationRequest(
        String message,
        long customerId
) {
}
