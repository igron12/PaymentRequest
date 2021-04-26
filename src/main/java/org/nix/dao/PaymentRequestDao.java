package org.nix.dao;

import org.nix.models.PaymentRequest;

import java.io.Serializable;
import java.util.List;

public interface PaymentRequestDao extends Serializable {

    // C
    void createPaymentRequest(PaymentRequest paymentRequest);

    // R
    PaymentRequest getPaymentRequest(long id);
    List<PaymentRequest> getListOfPaymentRequests();
    List<PaymentRequest> getListOfPaymentRequests(int status);
    PaymentRequest getLastPaymentRequest();

    // U
    void updatePaymentRequest(int id, PaymentRequest request, int status);
    void updatePaymentRequest(int id, int status);

    // D
    void deletePaymentRequest(int id);

}
