package com.spring.sample.schedule.alarm.keeper.service;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class NotificationServiceTest {

    @Test
    void scheduleNotificationTest() throws InterruptedException {
        NotificationService service = new NotificationService();

        log.debug("start");
        service.scheduleNotification("1", 5);
        service.scheduleNotification("2", 5);
        service.scheduleNotification("3", 10);
        service.scheduleNotification("4", 10);

        Thread.sleep(15 * 1000);
    }

    @Test
    void cancelScheduleNotificationTest() throws InterruptedException {
        NotificationService service = new NotificationService();

        log.debug("start");
        service.scheduleNotification("1", 5);
        service.scheduleNotification("2", 5);
        service.scheduleNotification("3", 10);
        service.scheduleNotification("4", 10);

        service.cancelNotification("3");
        service.cancelNotification("4");

        Thread.sleep(15 * 1000);
    }

    @Test
    void timeTest() {
        LocalTime now = LocalTime.now();
        LocalTime alarmTime = now.plus(5, ChronoUnit.SECONDS);
        long delaySeconds = Duration.between(now, alarmTime).toSeconds();

        log.debug("delaySeconds: {}", delaySeconds);
    }
}
