package org.nix.controllers;

import org.nix.RequestStatus;
import org.nix.models.PaymentRequest;
import org.nix.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // POST
    @PostMapping()
    public @ResponseBody PaymentRequest request(@Valid PaymentRequest request) {
        paymentService.createRequest(request);
        return paymentService.getLast();
    }

    // GET

    @GetMapping("/all")
    public @ResponseBody List<PaymentRequest> showAll() {
        return paymentService.getAllPaymentRequests();
    }

    @GetMapping("/all/{status}")
    public @ResponseBody List<PaymentRequest> showByStatus(@PathVariable("status") int status) {
        return paymentService.getAllPaymentRequests(status);
    }

    @GetMapping("/{id}")
    public PaymentRequest getById(@PathVariable("id") int id) {
        return paymentService.getById(id);
    }


//     PATCH

    @PatchMapping("/{id}/setStatus")
    public PaymentRequest update(@PathVariable("id") int id,
                                 int status) {
        paymentService.updateRequest(id, status);
        return paymentService.getById(id);
    }

    @PatchMapping("/{id}")
    public PaymentRequest update(@PathVariable("id") int id,
                                 PaymentRequest request, int status) {
        paymentService.updateRequest(id, request, status);
        return paymentService.getById(id);
    }

    // DELETE

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        paymentService.deleteRequest(id);
    }

}
