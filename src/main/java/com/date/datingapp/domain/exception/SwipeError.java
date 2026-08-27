package com.date.datingapp.domain.exception;

import com.date.datingapp.shared.exception.CodedException;

public class SwipeError {

    public static final String USER_CANNOT_SWIPE_THEMSELF = "01998be-001";

    private SwipeError() {
    }

    public static CodedException errUserCannotSwipeThemself() {
        var msg = "Пользователь не может свайпнуть сам себя";
        return new CodedException(USER_CANNOT_SWIPE_THEMSELF, msg);
    }
}
