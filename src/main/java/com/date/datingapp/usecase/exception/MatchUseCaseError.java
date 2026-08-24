package com.date.datingapp.usecase.exception;

import com.date.datingapp.shared.exception.CodedException;

import java.util.UUID;

public class MatchUseCaseError {

    public static final String MATCH_NOT_FOUND = "0199ca11-001";
    public static final String REQUIRED_PARAMS = "0199ca11-003";


    private MatchUseCaseError() {
    }

    public static CodedException matchNotFound(UUID uuid) {
        var message = String.format("Match with uuid %s not found", uuid.toString());
        return new CodedException(MATCH_NOT_FOUND, message);
    }

    public static CodedException paramsAreRequired() {
        var msg = "Params are required";
        return new CodedException(REQUIRED_PARAMS, msg);
    }
}
