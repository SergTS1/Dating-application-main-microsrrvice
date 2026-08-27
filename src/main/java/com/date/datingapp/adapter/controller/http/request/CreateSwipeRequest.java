package com.date.datingapp.adapter.controller.http.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@Data
@Schema(description = "Request to create a new swipe")
public class CreateSwipeRequest {

    @Schema(description = "Swipe data")
    SwipeData data;

    @Data
    @FieldDefaults(level = lombok.AccessLevel.PRIVATE)
    @Schema(description = "Swipe data wrapper")
    public static class SwipeData {

        @Schema(description = "Swipe attributes")
        SwipeAttributes attributes;
    }

    @Data
    @FieldDefaults(level = lombok.AccessLevel.PRIVATE)
    @Schema(description = "Swipe attributes")
    public static class SwipeAttributes {

        @Schema(description = "UUID of the swiper", example = "123e4567-e89b-12d3-a456-426614174000")
        String from;

        @Schema(description = "UUID of the swiped user", example = "123e4567-e89b-12d3-a456-426614174001")
        String to;
    }
}
