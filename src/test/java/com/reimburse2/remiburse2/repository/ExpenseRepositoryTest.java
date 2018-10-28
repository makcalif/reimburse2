package com.reimburse2.remiburse2.repository;

import com.reimburse2.remiburse2.domain.Expense;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ExpenseRepositoryTest {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    public void getExpense_getExpenseDetails() {

        Expense newExpense = new Expense("in-db");
        Expense expense = expenseRepository.save(newExpense);
        Iterable<Expense>  expenses = expenseRepository.findAll();
        expenses.forEach(e -> System.out.println("exp is:" + e));
       // Assertions.assertThat(expense.getName()).isEqualTo("first");
    }

    @Test
    public void saveEntityManager_getRepository() {
        Expense expense = testEntityManager.persistFlushFind(new Expense("mkname"));

        //Expense e = expenseRepository.findByName("mkname");
        //Expense e = expenseRepository.findByUnknows("mkname");
        Expense e = expenseRepository.findByCustom("mkname");
        Assertions.assertThat(e.getName()).isEqualTo("mkname");
    }

    @Test
    public void saveEntityManager_getRepositoryById() {
        Expense expense = testEntityManager.persistFlushFind(new Expense("mkname"));

        Optional<Expense> e = expenseRepository.findById(1L);

        e.ifPresent( System.out::println);

    }
}