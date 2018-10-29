package com.reimburse2.remiburse2.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest (InvoiceController.class)

public class InvoiceWebMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void invoiceControllerShouldReturnStatusOK() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/invoice"))
                .andExpect(status().isOk());
    }

    @Test
    public void invoiceContollerShouldLoadGetAnInvoice() throws Exception {
        Object o = this.mockMvc.perform(MockMvcRequestBuilders.get("/invoice"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("dummy")));
        //System.out.println(o);
    }

    @Test
    public void invoiceContollerShouldLoadAllInvoices() throws Exception {
        Object o = this.mockMvc.perform(MockMvcRequestBuilders.get("/invoices"));
        System.out.println(o);
    }
}
