package com.teyyub.clients.notification;

import com.teyyub.models.notification.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("notification")
public interface NotificationClient {

    @PostMapping("/api/v1/notifications")
    void sendNotification(@RequestBody NotificationRequest notificationRequest);
}
