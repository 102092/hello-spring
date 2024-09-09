package tobyspring.hellospring;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

abstract public class PaymentService {

    public Payment prepare(Long orderId, String currency, BigDecimal foreignCurrencyAmount) throws IOException {
        BigDecimal krw = getExRate(currency);
        BigDecimal convertedAmount = foreignCurrencyAmount.multiply(krw);
        LocalDateTime validUntil = LocalDateTime.now().plusMinutes(30);

        return new Payment(orderId, currency, foreignCurrencyAmount, krw, convertedAmount, validUntil);
    }

    // 관심사 분리
    abstract BigDecimal getExRate(String currency) throws IOException;
}