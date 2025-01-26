package com.example.demo.service;

import com.example.demo.entity.Notification;

import java.util.List;

public interface NotificationService {

    List<Notification> getNotificationsByUserId(Long userId);

    List<Notification> getUnreadNotificationsByUserId(Long userId);

    Notification saveNotification(Notification notification);
}


