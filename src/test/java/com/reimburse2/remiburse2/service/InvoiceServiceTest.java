package com.reimburse2.remiburse2.service;

import com.reimburse2.remiburse2.domain.Invoice;
import com.reimburse2.remiburse2.repository.InvoiceRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;

@RunWith(MockitoJUnitRunner.class)

public class InvoiceServiceTest {

    public static final String CHICAGO_TRIP = "Chicago Trip";

    @Mock
    InvoiceRepository invoiceRepository;

    InvoiceService invoiceService;

    @Before
    public void setup() {
        this.invoiceService = new InvoiceService(invoiceRepository);
    }

    @Test
    public void ShouldGetInvoice() throws Exception{
        Invoice invoice = new Invoice();
        invoice.setTitle(CHICAGO_TRIP);
        BDDMockito.given(invoiceRepository.findById(anyLong())).willReturn(Optional.of(invoice));
        Optional<Invoice> invoiceOptional = invoiceService.getInvoice(anyLong());

        assertThat(invoiceOptional).isNotNull();
        assertThat(invoiceOptional.isPresent()).isTrue();

        Invoice invoice1 = invoiceOptional.get();
        assertThat(invoice1.getTitle()).isEqualTo(CHICAGO_TRIP);
    }
}
