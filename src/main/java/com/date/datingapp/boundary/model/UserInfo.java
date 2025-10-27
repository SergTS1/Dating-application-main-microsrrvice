package com.date.datingapp.boundary.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
public class UserInfo {

    private Long id;
    private UUID uuid;
    private String name;
    private String email;
    private Long phoneNumber;
    private LocalDateTime createdAt;
}
