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

    private Match(MatchId id, UserId userA, UserId userB, Instant createdAt) {
        if (userA.equals(userB)) {
            throw MatchError.errUserCannotLikeHimself();
        }
        this.id = id;
        this.userA = userA;
        this.userB = userB;
        this.createdAt = createdAt;
        this.status = MatchStatus.ACTIVE;
    }

    public static Match create(UserId userA, UserId userB) {
        return new Match(MatchId.generate(), userA, userB, Instant.now());
    }

    private boolean isParticipant(UserId userId) {
        return userA.equals(userId) || userB.equals(userId);
    }

    public void unMatch(UserId currentUserId) {
        if (!isParticipant(currentUserId)) {
            throw MatchError.errUserIsNotParticipant();
        }
        if (status != MatchStatus.ACTIVE) {
            throw MatchError.errMatchIsAlreadyClosed();
        }
        status = MatchStatus.UNMATCHED;
    }

    public MatchId getId() {
        return id;
    }

    public UserId getUserA() {
        return userA;
    }

    public UserId getUserB() {
        return userB;
    }
}
