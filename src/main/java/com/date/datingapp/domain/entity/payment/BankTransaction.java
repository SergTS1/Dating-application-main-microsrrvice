package com.date.datingapp.domain.entity.payment;

import java.time.LocalDateTime;

public record BankTransaction(String reference, LocalDateTime processedAt) {

    public BankTransaction {
        if (reference == null || reference.isBlank())
            throw PaymentError.errReferenceCannotBeEmpty();
        if (processedAt == null)
            throw PaymentError.errProcessedAtCannotBeNull();
    }
}
