package com.date.datingapp.adapter.controller.http.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Schema(description = "Response containing user details")
public class GetUserResponse {

    @Schema(description = "User data")
    @JsonProperty("data")
    public UserData data;

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    @Schema(description = "User data")
    public static class UserData {

        @Schema(description = "User creation timestamp", example = "2023-10-05T14:48:00")
        @JsonProperty("createdAt")
        LocalDateTime createdAt;

        @Schema(description = "User ID", example = "1")
        @JsonProperty("id")
        Long id;

        @Schema(description = "User attributes")
        @JsonProperty("attributes")
        Attributes attributes;
    }

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    @Schema(description = "User attributes")
    public static class Attributes {

        @Schema(description = "User ID", example = "1")
        @JsonProperty("id")
        Long id;

        @Schema(description = "User UUID", example = "550e8400-e29b-41d4-a716-446655440000")
        @JsonProperty("uuid")
        UUID uuid;

        @Schema(description = "User's name", example = "John Doe")
        @JsonProperty("name")
        String name;

        @Schema(description = "User email")
        @JsonProperty("email")
        String email;

        @Schema(description = "User phone number", example = "1234567890")
        @JsonProperty("phone_number")
        Long phoneNumber;

        @Schema(description = "User creation timestamp", example = "2023-10-05T14:48:00")
        @JsonProperty("created_at")
        LocalDateTime createdAt;
    }
}
