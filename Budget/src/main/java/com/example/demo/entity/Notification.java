package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long notificationId;

    @NotBlank(message = "Type cannot be blank")
    @Size(max = 50, message = "Type cannot exceed 50 characters")
    private String type;// Type of notification (e.g., Budget Alert, Overdue Payment)
    @NotBlank(message = "Message cannot be blank")
    @Size(max = 255, message = "Message cannot exceed 255 characters")
    private String message;  // Notification message content
    @NotNull(message = "Date cannot be null")
    private LocalDateTime date = LocalDateTime.now();  // Date and time of the notification

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)  // Foreign key referencing User entity
    private User user;

    private boolean isRead;  // Boolean flag indicating if the notification has been read

    
    public Notification() {}

    public Notification(long notificationId, String type, String message, LocalDateTime date, User user, boolean isRead) {
        this.notificationId = notificationId;
        this.type = type;
        this.message = message;
        this.date = date;
        this.user = user;
        this.isRead = isRead;
    }

    public long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(long notificationId) {
        this.notificationId = notificationId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean isRead) {
        this.isRead = isRead;
    }

    @Override
    public String toString() {
        return "Notification [notificationId=" + notificationId + ", type=" + type + ", message=" + message + ", date=" 
                + date + ", user=" + user + ", isRead=" + isRead + "]";
    }
}

