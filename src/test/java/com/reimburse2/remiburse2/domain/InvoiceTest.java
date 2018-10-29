package com.reimburse2.remiburse2.domain;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InvoiceTest {

    @Test
    public void new_invoice_id_should_not_be_null() {
        Invoice invoice = new Invoice();
        assertThat(invoice).isNotNull();
        assertThat(invoice.getId()).isNotNull();
    }

    @Test
    public void unapproved_invoice_should_throw_InvoiceUnapprovedException () {
        Invoice invoice = new Invoice();
        //assertThat(invoice.submit()).
        //BDDMockito.given(invoice.approve());
        when(invoice.submit()).thenReturn(true);


    }

}