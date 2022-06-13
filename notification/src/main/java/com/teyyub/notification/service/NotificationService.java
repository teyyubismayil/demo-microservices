package com.teyyub.notification.service;

import com.teyyub.models.notification.NotificationRequest;
import com.teyyub.notification.model.Notification;
import com.teyyub.notification.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void sendNotification(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .message(notificationRequest.message())
                        .toCustomerId(notificationRequest.customerId())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}
