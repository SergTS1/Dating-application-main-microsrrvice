package com.date.datingapp.adapter.controller.http.request;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Schema(description = "Request to create a new match between two users")
public class CreateMatchRequest {

    @Schema(description = "Match data")
    MatchData data;

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    @Schema(description = "Match data wrapper")
    public static class MatchData {

        @Schema(description = "Match attributes")
        MatchAttributes attributes;
    }

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    @Schema(description = "Match attributes")
    public static class MatchAttributes {

        @Schema(description = "UUID of the first user", example = "123e4567-e89b-12d3-a456-426614174000")
        String user1Uuid;

        @Schema(description = "UUID of the second user", example = "123e4567-e89b-12d3-a456-426614174001")
        String user2Uuid;
    }
}
