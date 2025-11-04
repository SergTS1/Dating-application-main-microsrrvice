package com.date.datingapp.domain.entity.match;

import com.date.datingapp.domain.entity.user.UserId;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Match {

    private final UUID id;
    private final UserId userA;
    private final UserId userB;
    private final LocalDateTime createdAt;
    private boolean active;
    private final List<Message> messages = new ArrayList<>();

    private Match(UserId userA, UserId userB) {
        this.id = UUID.randomUUID();
        this.userA = userA;
        this.userB = userB;
        this.createdAt = LocalDateTime.now();
        this.active = true;
    }

    public static Match create(UserId userA, UserId userB) {
        if (userA.equals(userB)) {
            throw MatchError.errUserCannotLikeHimself();
        }
        return new Match(userA, userB);
    }

    public void sendMessage(UserId senderId, String content) {
        if (!active) throw MatchError.errUnableToSentMessage();
        if (!isParticipant(senderId))
            throw MatchError.errSenderIsNotParticipating();

        messages.add(Message.create(senderId, content));
    }

    public void close() {
        if (!active) throw MatchError.errMatchIsAlreadyClosed();
        this.active = false;
    }

    private boolean isParticipant(UserId userId) {
        return userA.equals(userId) || userB.equals(userId);
    }

    public boolean isActive() {
        return active;
    }

    public void unMatch() {
        this.active = false;
    }

    public List<Message> getMessages() {
        return Collections.unmodifiableList(messages);
    }
    public UUID getId() {
        return id;
    }
}
