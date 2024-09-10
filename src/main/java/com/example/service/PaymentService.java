package com.example.service;

import com.example.model.PaymentStatus;
import com.example.model.SellerPayments;

public class PaymentService {

    // Simula a validação do vendedor
    public boolean validateSeller(String sellerId) {
        // Simular que o vendedor está na base de dados
        return "vendedor123".equals(sellerId);
    }

    // Simula a validação do código de cobrança
    public boolean validateChargeCode(String chargeCode) {
        // Simular que o código de cobrança está na base de dados
        return "cob123".equals(chargeCode);
    }

    // Verifica o valor do pagamento
    public PaymentStatus determinePaymentStatus(double paymentAmount, double originalAmount) {
        if (paymentAmount < originalAmount) {
            return PaymentStatus.PARTIAL;
        } else if (paymentAmount == originalAmount) {
            return PaymentStatus.FULL;
        } else {
            return PaymentStatus.EXCESS;
        }
    }

    // Processa o objeto
    public SellerPayments processPayments(SellerPayments sellerPayments) {
        if (!validateSeller(sellerPayments.getSellerId())) {
            throw new IllegalArgumentException("Vendedor não encontrado");
        }

        sellerPayments.getPayments().forEach(payment -> {
            if (!validateChargeCode(payment.getChargeCode())) {
                throw new IllegalArgumentException("Código de cobrança não encontrado");
            }

            // Vamos supor que o valor original é 100.0 para cada pagamento
            PaymentStatus status = determinePaymentStatus(payment.getAmount(), 100.0);

            // Aqui você enviaria o objeto para a fila SQS correta com base no status
            sendToSqs(status, payment);
        });

        return sellerPayments;
    }

    private void sendToSqs(PaymentStatus status, Object message) {
        // Lógica para enviar para a fila SQS com base no status
        System.out.println("Enviando para fila: " + status);
    }
}
