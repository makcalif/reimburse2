package com.reimburse2.remiburse2.service;

import com.reimburse2.remiburse2.domain.Invoice;
import com.reimburse2.remiburse2.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvoiceService {

    private InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Optional<Invoice> getInvoice(long l) {
        return this.invoiceRepository.findById(l);
    }

    public Invoice createInvoice(Invoice invoice) {
        return invoice;
    }
}
