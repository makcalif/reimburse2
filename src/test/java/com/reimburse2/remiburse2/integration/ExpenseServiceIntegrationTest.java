package com.reimburse2.remiburse2.integration;

import com.reimburse2.remiburse2.domain.Expense;
import com.reimburse2.remiburse2.repository.ExpenseRepository;
import com.reimburse2.remiburse2.service.ExpenseService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ExpenseServiceIntegrationTest {

    @Autowired
    ExpenseRepository expenseRepository;

    ExpenseService expenseService;

    @Before
    public void setup () {
        expenseService = new ExpenseService(expenseRepository);
    }


    @Test
    public void getAllExpenses() {
        Expense newExpense = new Expense("in-db 1");
        Expense expense = expenseService.save(newExpense);
        newExpense = new Expense("in-db 2");
        expense = expenseService.save(newExpense);

        expenseService.getAllExpenses().forEach(System.out::println);
    }
}
