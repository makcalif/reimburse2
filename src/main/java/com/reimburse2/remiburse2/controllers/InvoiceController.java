package com.reimburse2.remiburse2.controllers;

import com.reimburse2.remiburse2.domain.Invoice;
import com.reimburse2.remiburse2.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceController {

    InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoice")
    public Invoice getInvoice(@PathVariable("title") String title) {
        return new Invoice(title);
    }

    public Invoice create(Invoice invoice) {
        return invoiceService.createInvoice(invoice);

    }
}
