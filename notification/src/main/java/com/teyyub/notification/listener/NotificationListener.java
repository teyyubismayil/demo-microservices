package com.teyyub.notification.listener;

import com.teyyub.models.notification.NotificationRequest;
import com.teyyub.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationListener {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consume(NotificationRequest notificationRequest) {
        log.info("Consumed {}", notificationRequest);
        notificationService.sendNotification(notificationRequest);
    }
}
