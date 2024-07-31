package com.kintaig.kintai.domain;

import java.time.LocalDateTime;

public class AttendanceDTO {

    private Long userId;
    private AttendanceType type;
    private LocalDateTime timestamp;

    public AttendanceDTO(Long userId, AttendanceType type, LocalDateTime timestamp) {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public AttendanceType getType() {
        return type;
    }

    public void setType(AttendanceType type) {
        this.type = type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    // Constructor, getters, and setters

}