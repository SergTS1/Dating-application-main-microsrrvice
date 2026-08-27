package com.date.datingapp.usecase.exception;

import com.date.datingapp.shared.exception.CodedException;

public class SwipeUseCaseError {

    public static final String REQUIRED_PARAMS = "0199bc11-001";

    private SwipeUseCaseError() {
    }

    public static CodedException paramsAreRequired() {
        var msg = "Params are required";
        return new CodedException(REQUIRED_PARAMS, msg);
    }

}
