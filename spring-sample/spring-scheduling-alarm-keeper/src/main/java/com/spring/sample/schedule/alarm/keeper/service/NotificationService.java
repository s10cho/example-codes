package com.spring.sample.schedule.alarm.keeper.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import com.spring.sample.schedule.alarm.keeper.domain.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificationService {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    private final Map<String, ScheduledFuture<?>> scheduledTasks = new ConcurrentHashMap<>();

    private final List<Notification> notifications = new CopyOnWriteArrayList<>();

    public String scheduleNotification(String id, long delaySeconds) {
        Runnable task = () -> {
            notifications.removeIf(n -> n.getId().equals(id));
            scheduledTasks.remove(id);
            log.debug("execute task id: {}", id);
        };
        ScheduledFuture<?> scheduledTask = scheduler.schedule(task, delaySeconds, TimeUnit.SECONDS);
        scheduledTasks.put(id, scheduledTask);
        notifications.add(new Notification(id));
        return id;
    }

    public boolean cancelNotification(String id) {
        ScheduledFuture<?> scheduledTask = scheduledTasks.remove(id);
        if (scheduledTask != null) {
            scheduledTask.cancel(true);
            notifications.removeIf(n -> n.getId().equals(id));
            log.debug("cancel task id: {}", id);
            return true;
        }
        return false;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }
}
