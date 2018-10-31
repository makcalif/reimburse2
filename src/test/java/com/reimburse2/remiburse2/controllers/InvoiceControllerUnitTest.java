package com.reimburse2.remiburse2.controllers;

import com.reimburse2.remiburse2.domain.Invoice;
import com.reimburse2.remiburse2.service.InvoiceService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class InvoiceControllerUnitTest {

    public static final String INV_TITLE_AIRLINE_CLIENT_LUNCH = "airline client lunch";
    @Mock
    InvoiceService invoiceService;

    @Mock
    InvoiceController invoiceController;

    @Before
    public void setup() {
        invoiceController = new InvoiceController(invoiceService);
    }

    @Test
    public void should_create_invoice_and_return_saved_invoice() {
        Invoice invoice = new Invoice(INV_TITLE_AIRLINE_CLIENT_LUNCH);
        Invoice savedInvoice = invoiceController.create(invoice);
        assertThat(savedInvoice).isNotNull();

        verify(invoiceService, BDDMockito.times(1)).createInvoice(invoice);
    }

    @Test
    public void should_create_invoice_values_should_match() {
        Invoice invoice = new Invoice(INV_TITLE_AIRLINE_CLIENT_LUNCH);

        BDDMockito.when(invoiceService.createInvoice(invoice)).thenReturn(invoice);

        Invoice savedInvoice = invoiceController.create(invoice);
        assertThat(savedInvoice).isNotNull();

        verify(invoiceService, BDDMockito.times(1)).createInvoice(invoice);
        ArgumentCaptor<Invoice> invoiceArgumentCaptor = ArgumentCaptor.forClass(Invoice.class);
        verify(invoiceService).createInvoice(invoiceArgumentCaptor.capture());


        assertThat(INV_TITLE_AIRLINE_CLIENT_LUNCH).isEqualTo(invoiceArgumentCaptor.getValue().getTitle());

    }
}
