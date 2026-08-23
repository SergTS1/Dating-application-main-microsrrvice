package com.date.datingapp.domain.entity.match;

import com.date.datingapp.domain.enums.MatchStatus;
import com.date.datingapp.domain.exception.MatchError;
import com.date.datingapp.domain.valueobject.MatchId;
import com.date.datingapp.domain.valueobject.UserId;

import java.time.Instant;

public class Match {

    private final MatchId id;
    private final UserId userA;
    private final UserId userB;
    private final Instant createdAt;
    private MatchStatus status;

    private Match(UserId userA, UserId userB) {
        if (userA.equals(userB)) {
            throw MatchError.errUserCannotLikeHimself();
        }
        this.id = MatchId.generate();
        this.userA = userA;
        this.userB = userB;
        this.createdAt = Instant.now();
        this.status = MatchStatus.ACTIVE;
    }

    public static Match create(UserId userA, UserId userB) {
        return new Match(userA, userB);
    }

    private boolean isParticipant(UserId userId) {
        return userA.equals(userId) || userB.equals(userId);
    }

    public void unMatch() {
        if (status != MatchStatus.ACTIVE) {
            throw MatchError.errMatchIsAlreadyClosed();
        }
        status = MatchStatus.UNMATCHED;
    }
}
