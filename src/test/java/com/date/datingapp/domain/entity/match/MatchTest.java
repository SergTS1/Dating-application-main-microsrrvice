package com.date.datingapp.domain.entity.match;

import com.date.datingapp.domain.entity.user.UserId;
import com.date.datingapp.shared.exception.CodedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {

    @Test
    void shouldCreateMatchBetweenTwoDifferentUsers() {
        UserId user1 = UserId.generate();
        UserId user2 = UserId.generate();

        Match match = Match.create(user1, user2);

        assertTrue(match.isActive());
        assertEquals(0, match.getMessages().size());
    }

    @Test
    void shouldFailToCreateMatchWithSelf() {
        UserId user = UserId.generate();
        assertThrows(CodedException.class, () -> Match.create(user, user));
    }

    @Test
    void shouldSendMessageFromUser1() {
        UserId user1 = UserId.generate();
        UserId user2 = UserId.generate();
        Match match = Match.create(user1, user2);

        match.sendMessage(user1, "Привет!");

        assertEquals(1, match.getMessages().size());
        assertEquals("Привет!", match.getMessages().get(0).getContent());
    }

    @Test
    void shouldFailToSendMessageFromUnrelatedUser() {
        UserId user1 = UserId.generate();
        UserId user2 = UserId.generate();
        UserId stranger = UserId.generate();

        Match match = Match.create(user1, user2);

        assertThrows(CodedException.class, () -> match.sendMessage(stranger, "Хай!"));
    }

    @Test
    void shouldFailToSendEmptyMessage() {
        UserId user1 = UserId.generate();
        UserId user2 = UserId.generate();

        Match match = Match.create(user1, user2);

        assertThrows(CodedException.class, () -> match.sendMessage(user1, "  "));
    }

    @Test
    void shouldDeactivateMatchWhenUnmatched() {
        UserId user1 = UserId.generate();
        UserId user2 = UserId.generate();

        Match match = Match.create(user1, user2);
        match.unMatch();

        assertFalse(match.isActive());
    }

    @Test
    void shouldFailToSendMessageAfterUnmatch() {
        UserId user1 = UserId.generate();
        UserId user2 = UserId.generate();

        Match match = Match.create(user1, user2);
        match.unMatch();

        assertThrows(CodedException.class, () -> match.sendMessage(user1, "Ещё увидимся!"));
    }

}
