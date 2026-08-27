package com.date.datingapp.adapter.controller.http.response;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
@Schema(description = "Response after creating a new swipe")
public class CreateSwipeResponse {

    @Schema(description = "Swipe data")
    public SwipeData data;

    @Data
    @Schema(description = "Swipe data wrapper")
    public static class SwipeData {

        @Schema(description = "Swipe id")
        public UUID swipeId;
    }
}
