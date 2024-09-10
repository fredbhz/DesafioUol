package com.example;

import com.example.model.Payment;
import com.example.model.SellerPayments;
import com.example.service.PaymentService;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class PaymentServiceTest {

    @Test
    public void testProcessPayments() {
        PaymentService service = new PaymentService();

        SellerPayments sellerPayments = new SellerPayments("vendedor123",
                Arrays.asList(new Payment("cob123", 120.0)));

        SellerPayments result = service.processPayments(sellerPayments);

        assertEquals("vendedor123", result.getSellerId());
    }
}
