package com.date.datingapp.domain.entity.payment;

import com.date.datingapp.domain.entity.user.UserId;
import com.date.datingapp.shared.exception.CodedException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PaymentTest {

    @Test
    void shouldCreatePendingPayment() {
        UserId userId = UserId.generate();
        Payment payment = Payment.initiate(userId, new BigDecimal("9.99"));

        assertEquals(PaymentStatus.PENDING, payment.getStatus());
    }

    @Test
    void shouldMarkPaymentAsSuccessful() {
        UserId userId = UserId.generate();
        Payment payment = Payment.initiate(userId, new BigDecimal("9.99"));

        payment.markSuccess("BANK123");

        assertEquals(PaymentStatus.SUCCESS, payment.getStatus());
    }

    @Test
    void shouldNotAllowDoubleProcessing() {
        UserId userId = UserId.generate();
        Payment payment = Payment.initiate(userId, new BigDecimal("9.99"));
        payment.markFailure("BANK_FAIL_1");

        assertThrows(CodedException.class, () -> payment.markSuccess("BANK_SUCCESS_2"));
    }

    @Test
    void shouldRejectInvalidAmount() {
        UserId userId = UserId.generate();
        assertThrows(CodedException.class, () -> Payment.initiate(userId, BigDecimal.ZERO));
    }
}
