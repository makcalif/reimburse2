package com.reimburse2.remiburse2.controllers;

import com.reimburse2.remiburse2.domain.Invoice;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InvoiceControllerIntegrationTest {

    @Autowired
    private RestTemplate restTemplate;

    @Mock
    InvoiceController invoiceController;


    @Test
    public void WhenCallContoroller_ThenGetStatusOK () throws  Exception{

        ResponseEntity<String> responseEntity = restTemplate.getForEntity("/invoice", String.class);
        //Assertions.assertThat(responseEntity.getStatusCode()

//        this.mockMvc.perform(MockMvcRequestBuilders.get("/invoice"))
//                .andExpect(status().isOk());


        //when
//        Invoice invoice = new Invoice();
//        BDDMockito.when(invoiceController.getInvoice()).thenReturn(invoice);
//        Assertions.assertThat(invoice).isNotNull();

    }
    /*
    @Test
    public void WhenGetInvoice_itIsNotNull () {

        //when
        Invoice invoice = new Invoice();
        BDDMockito.when(invoiceController.getInvoice()).thenReturn(invoice);
        Assertions.assertThat(invoice).isNotNull();

    }
    */

}