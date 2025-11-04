package com.date.datingapp.domain.entity.payment;

import com.date.datingapp.shared.exception.CodedException;

public class PaymentError {

    public static final String PAYMENT_IS_ALREADY_BEEN_PROCEED = "02997bb6-001";

    public static final String USER_ID_CANNOT_BE_NULL = "02997bb6-002";

    public static final String AMOUNT_MUST_BE_POSITIVE = "02997bb6-003";

    public static final String REFERENCE_CANNOT_BE_EMPTY = "02997bb6-004";

    public static final String PROCESSED_AT_CANNOT_BE_NULL = "02997bb6-005";

    private PaymentError() {
    }

    public static CodedException errPaymentIsAlreadyBeenProceed() {
        var msg = "Платёж уже обработан";
        return new CodedException(PAYMENT_IS_ALREADY_BEEN_PROCEED, msg);
    }

    public static CodedException errUserIdCannotBeNull() {
        var msg = "userId не может быть null";
        return new CodedException(USER_ID_CANNOT_BE_NULL, msg);
    }

    public static CodedException errAmountMustBePositive() {
        var msg = "amount must be positive";
        return new CodedException(AMOUNT_MUST_BE_POSITIVE, msg);
    }

    public static CodedException errReferenceCannotBeEmpty() {
        var msg = "reference не может быть пустым";
        return new CodedException(REFERENCE_CANNOT_BE_EMPTY, msg);
    }

    public static CodedException errProcessedAtCannotBeNull() {
        var msg = "processedAt не может быть null";
        return new CodedException(PROCESSED_AT_CANNOT_BE_NULL, msg);
    }
}
