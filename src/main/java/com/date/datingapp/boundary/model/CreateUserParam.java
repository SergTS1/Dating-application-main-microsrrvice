package com.date.datingapp.boundary.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateUserParam {

    private String uuid;
    private String name;
    private String email;
    private Long phoneNumber;
    private LocalDateTime createdAt;

}
