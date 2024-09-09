package tobyspring.hellospring;

import java.io.IOException;
import java.math.BigDecimal;

public class SimpleExRatePaymentService extends PaymentService {

    @Override
    BigDecimal getExRate(String currency) throws IOException {
        if ("USD".equals(currency)) {
            return BigDecimal.valueOf(1000);
        }

        throw new IllegalArgumentException("Unknown currency: " + currency);
    }
}
