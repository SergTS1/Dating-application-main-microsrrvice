package com.date.datingapp.domain.entity.payment;

import com.date.datingapp.domain.entity.user.UserId;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Payment {

    private final UUID id;
    private final UserId userId;
    private final BigDecimal amount;
    private PaymentStatus status;
    private BankTransaction transaction;

    private Payment(UserId userId, BigDecimal amount) {
        if (userId == null) {
            throw PaymentError.errUserIdCannotBeNull();
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw PaymentError.errAmountMustBePositive();
        }
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.amount = amount;
        this.status = PaymentStatus.PENDING;
    }

    public static Payment initiate(UserId userId, BigDecimal amount) {
        return new Payment(userId, amount);
    }

    public void markSuccess(String bankRef) {
        if (status != PaymentStatus.PENDING)
            throw PaymentError.errPaymentIsAlreadyBeenProceed();

        this.status = PaymentStatus.SUCCESS;
        this.transaction = new BankTransaction(bankRef, LocalDateTime.now());
    }

    public void markFailure(String bankRef) {
        if (status != PaymentStatus.PENDING)
            throw PaymentError.errPaymentIsAlreadyBeenProceed();

        this.status = PaymentStatus.FAILED;
        this.transaction = new BankTransaction(bankRef, LocalDateTime.now());
    }

    public PaymentStatus getStatus() {
        return status;
    }
}
