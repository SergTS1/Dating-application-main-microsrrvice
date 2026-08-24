package com.date.datingapp.adapter.controller.http.response;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
@Schema(description = "Response after creating a new match between two users")
public class CreateMatchResponse {

    @Schema(description = "Match data")
    public MatchData data;

    @Data
    @Schema(description = "Match data wrapper")
    public static class MatchData {

        @Schema(description = "Match id")
        public UUID matchId;

        @Schema(description = "UserId of the first user")
        public String user1Id;
    }
}
