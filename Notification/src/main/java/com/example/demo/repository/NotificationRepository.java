package com.example.demo.repository;

import com.example.demo.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    // Custom method to find all notifications for a specific user
    List<Notification> findAllByUser_UserId(Long userId);

    // Custom method to find unread notifications for a specific user
    List<Notification> findAllByUser_UserIdAndIsRead(Long userId, boolean isRead);
}
