package com.reimburse2.remiburse2.controllers;

import com.reimburse2.remiburse2.domain.Expense;
import com.reimburse2.remiburse2.exception.ExpenseNotFoundException;
import com.reimburse2.remiburse2.service.ExpenseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ExpenseController.class)
public class ExpenseControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ExpenseService expenseService;

    @Test
    public void test_getAll() throws Exception{

        BDDMockito.given(expenseService.getExpenseDetail(ArgumentMatchers.anyString())).willReturn(new Expense("first"));
        // mokito any works too
        //BDDMockito.given(expenseService.getExpenseDetail(Mockito.anyString())).willReturn(new Expense("first"));

        mockMvc.perform(MockMvcRequestBuilders.get("/expenses/first"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("first"));

    }

    @Test
    public void getExpense_notFound() throws Exception {
        BDDMockito.given(expenseService.getExpenseDetail(ArgumentMatchers.anyString())).willThrow(new ExpenseNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("/expenses/first"))
                .andExpect(status().isNotFound());

    }

}
