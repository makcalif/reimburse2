package com.reimburse2.remiburse2.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
//If you want to focus only on the web layer and not start a complete ApplicationContext, consider using @WebMvcTest instead.
@AutoConfigureMockMvc
public class InvoiceAutoConfigureMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void invoiceControllerShouldReturnStatusOK() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/invoice"))
                .andExpect(status().isOk());
    }
}
