package com.example.nutrimarket.service;

import com.example.nutrimarket.model.PaymentRequest;
import com.example.nutrimarket.model.PaymentResponse;
import com.example.nutrimarket.model.Ticket;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class PaymentService {

    /**
     * Simula el proceso de pago.
     *
     * @param request   Datos de la solicitud.
     *
     * @return  Respuesta del pago.
     */
    public PaymentResponse processPayment(PaymentRequest request) {
        if (!isValid(request)) {
            return new PaymentResponse(false, "Detalles del pago no válidos.\n", null);
        }

        boolean paymentSuccess = makePayment();

        if (paymentSuccess) {
            Ticket ticket = generateTicket(request);
            return new PaymentResponse(true, "Pago realizado.", ticket);
        } else {
            return new PaymentResponse(false, "Pago fallido.", null);
        }
    }

    /**
     * Valida los datos de la solicitud.
     *
     * @param request   Datos de la solicitud.
     *
     * @return  Estado de la validación.
     */
    private boolean isValid(PaymentRequest request) {
        return request.getCardNumber().length() == 16 && request.getCvv().length() == 3;
    }

    /**
     * Decide de manera aleatoria si el pago se realiza o no.
     *
     * @return Un número aleatorio.
     */
    private boolean makePayment() {
        return Math.random() > 0.2;
    }

    /**
     * Genera un ticket con los datos que le proporcionemos.
     *
     * @param request   Datos de la solicitud.
     *
     * @return  Ticket con los datos de la compra.
     */
    private Ticket generateTicket(PaymentRequest request) {
        String ticketId = UUID.randomUUID().toString();
        String details = "Payment for amount: " + request.getAmount();
        return new Ticket(ticketId, details, request.getAmount());
    }
}

