package com.date.datingapp.domain.entity.match;

import com.date.datingapp.domain.entity.user.UserId;

import java.time.LocalDateTime;
import java.util.UUID;

public class Message {

    private final UUID id;
    private final UserId senderId;
    private final String content;
    private final LocalDateTime sentAt;

    private Message(UserId senderId, String content) {
        this.id = UUID.randomUUID();
        this.senderId = senderId;
        this.content = content;
        this.sentAt = LocalDateTime.now();
    }

    static Message create(UserId senderId, String content) {
        if (content == null || content.isBlank())
            throw MatchError.errMessageCannotBeEmpty();

        return new Message(senderId, content);
    }

    public UUID getId() {
        return id;
    }

    public UserId getSenderId() {
        return senderId;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }
}
