package com.reimburse2.remiburse2.service;

import com.reimburse2.remiburse2.domain.Expense;
import com.reimburse2.remiburse2.exception.ExpenseNotFoundException;
import com.reimburse2.remiburse2.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense getExpenseDetail(String name) { //throws ExpenseNotFoundException{
        Expense expense = expenseRepository.findByName(name);
        if(expense == null)
            throw new ExpenseNotFoundException();

        return expense;
    }

    public List<Expense> getAllExpenses() {
        List<Expense> expenses = new ArrayList<>();
        expenseRepository.findAll().forEach(expenses::add);
        return  expenses;
    }

    public Expense save(Expense expense){
        return expenseRepository.save(expense);
    }
}
