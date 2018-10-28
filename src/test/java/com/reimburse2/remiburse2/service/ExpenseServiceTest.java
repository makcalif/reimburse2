package com.reimburse2.remiburse2.service;

import com.reimburse2.remiburse2.domain.Expense;
import com.reimburse2.remiburse2.exception.ExpenseNotFoundException;
import com.reimburse2.remiburse2.repository.ExpenseRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ExpenseServiceTest {

    @Mock
    private ExpenseRepository expenseRepository;

    @Autowired
    private ExpenseService expenseService;

    @Before
    public void setup()  {
        expenseService = new ExpenseService(expenseRepository);
    }

    @Test
    public void getExpenseDetails () {

        BDDMockito.given(expenseRepository.findByName("first")).willReturn(new Expense("first"));

        Expense expense = expenseService.getExpenseDetail("first");

        Assertions.assertThat(expense.getName()).isEqualTo("first");

    }

    @Test (expected = ExpenseNotFoundException.class)
    public void getExpenseDetails_whenCarNotFound() {
        BDDMockito.given(expenseRepository.findByName("first")).willReturn(null);

        Expense expense = expenseService.getExpenseDetail("first");

    }

    @Test
    public void getAllExpenses() {

    }

}