package org.nix.service.impl;

import org.nix.RequestStatus;
import org.nix.models.PaymentRequest;
import org.nix.dao.impl.PaymentRequestDaoImpl;
import org.nix.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private final PaymentRequestDaoImpl dao;

    @Override
    public void createRequest(@Valid PaymentRequest request) {
        dao.createPaymentRequest(request);
    }

    @Override
    public List<PaymentRequest> getAllPaymentRequests() {
        return dao.getListOfPaymentRequests();
    }

    @Override
    public List<PaymentRequest> getAllPaymentRequests(int status) {
        return dao.getListOfPaymentRequests(status);
    }

    @Override
    public PaymentRequest getById(int id) {
        return dao.getPaymentRequest(id);
    }

    @Override
    public PaymentRequest getLast() {
        return dao.getLastPaymentRequest();
    }

    @Override
    public void updateRequest(int id, PaymentRequest request, int status) {
        dao.updatePaymentRequest(id, request, status);
    }

    @Override
    public void updateRequest(int id, int status) {
        dao.updatePaymentRequest(id, status);
    }

    @Override
    public void deleteRequest(int id) {
        dao.deletePaymentRequest(id);
    }


    @Autowired
    public PaymentServiceImpl(PaymentRequestDaoImpl dao) {
        this.dao = dao;
    }
}
