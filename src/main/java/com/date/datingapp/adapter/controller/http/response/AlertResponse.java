package com.date.datingapp.adapter.controller.http.response;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Schema(description = "Alert response structure")
public class AlertResponse {

    @Schema(description = "HTTP status code", example = "404")
    private String httpCode;
    @Schema(description = "Request path that caused the alert", example = "/api/v1/users/1")
    private String path;
    @Schema(description = "Application-specific error code", example = "USER_NOT_FOUND")
    private String errorCode;
    @Schema(description = "Detailed error message", example = "User with ID 1 not found")
    private String msg;
    @Schema(description = "Timestamp of the alert in milliseconds since epoch", example = "1700000000000")
    private long timestamp;
}
