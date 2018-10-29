package com.reimburse2.remiburse2.controllers;

import com.reimburse2.remiburse2.domain.Invoice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceController {

    @GetMapping("/invoice")
    public Invoice getInvoice() {
        return new Invoice();
    }
}
