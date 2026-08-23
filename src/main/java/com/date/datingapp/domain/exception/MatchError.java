package com.date.datingapp.domain.exception;

import com.date.datingapp.shared.exception.CodedException;

public class MatchError {

    public static final String USER_CANNOT_LIKE_HIMSELF = "01997cbe-001";
    public static final String UNABLE_TO_SEND_MESSAGE_MATCH_ENDED = "01997cbe-002";
    public static final String SENDER_IS_NOT_PARTICIPATING_IN_THIS_MATCH = "01997cbe-003";
    public static final String MATCH_IS_ALREADY_CLOSED = "01997cbe-004";

    public static final String MESSAGE_CANNOT_BE_EMPTY = "01997cbe-005";

    private MatchError() {
    }

    public static CodedException errUserCannotLikeHimself() {
        var msg = "Пользователь не может лайкнуть сам себя";
        return new CodedException(USER_CANNOT_LIKE_HIMSELF, msg);
    }

    public static CodedException errUnableToSentMessage() {
        var msg = "Невозможно отправить сообщение — матч завершён";
        return new CodedException(UNABLE_TO_SEND_MESSAGE_MATCH_ENDED, msg);
    }

    public static CodedException errSenderIsNotParticipating() {
        var msg = "Отправитель не участвует в этом матче";
        return new CodedException(SENDER_IS_NOT_PARTICIPATING_IN_THIS_MATCH, msg);
    }

    public static CodedException errMatchIsAlreadyClosed() {
        var msg = "Матч уже закрыт";
        return new CodedException(MATCH_IS_ALREADY_CLOSED, msg);
    }

    public static CodedException errMessageCannotBeEmpty() {
        var msg = "Сообщение не может быть пустым";
        return new CodedException(MESSAGE_CANNOT_BE_EMPTY, msg);
    }
}
