package com.date.datingapp.adapter.controller.http.convertor;


import com.date.datingapp.adapter.controller.http.response.CreateMatchResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MatchResponseMapper {

    public CreateMatchResponse toResponse(UUID matchId) {
        if (matchId == null) {
            return null;
        }

        CreateMatchResponse.MatchData matchData = toCreateMatchResponse(matchId);
        CreateMatchResponse response = new CreateMatchResponse();
        response.setData(matchData);
        return response;
    }

    public CreateMatchResponse.MatchData toCreateMatchResponse(UUID matchId) {
        if (matchId == null) {
            return null;
        }

        CreateMatchResponse.MatchData matchData = new CreateMatchResponse.MatchData();
        matchData.setMatchId(matchId);
        return matchData;
    }
}
