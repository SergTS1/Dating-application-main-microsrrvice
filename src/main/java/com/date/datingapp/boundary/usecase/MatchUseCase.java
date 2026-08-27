package com.date.datingapp.boundary.usecase;

import com.date.datingapp.boundary.model.CreateMatchParam;
import com.date.datingapp.domain.valueobject.match.MatchId;

public interface MatchUseCase {

    MatchId create(CreateMatchParam params);

    void unMatch(MatchId matchId);
}
