package com.example.queue;

import com.example.model.PaymentStatus;

public class SqsSender {

    public void sendMessage(PaymentStatus status, Object message) {
        String queueUrl = getQueueUrlByStatus(status);

        // Lógica para enviar a mensagem para o SQS com base na URL da fila
        System.out.println("Enviando mensagem para fila: " + queueUrl);
        // Aqui você poderia usar o AWS SDK para enviar a mensagem real para a SQS
    }

    private String getQueueUrlByStatus(PaymentStatus status) {
        switch (status) {
            case PARTIAL:
                return "https://sqs.region.amazonaws.com/partialQueue";
            case FULL:
                return "https://sqs.region.amazonaws.com/fullQueue";
            case EXCESS:
                return "https://sqs.region.amazonaws.com/excessQueue";
            default:
                throw new IllegalArgumentException("Status de pagamento desconhecido");
        }
    }
}
