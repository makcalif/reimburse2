package com.reimburse2.remiburse2.controllers;

import com.reimburse2.remiburse2.domain.Expense;
import com.reimburse2.remiburse2.exception.ExpenseNotFoundException;
import com.reimburse2.remiburse2.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExpenseController {

    private ExpenseService expenseService;

//    @Autowired
//    public ExpenseController(ExpenseService expenseService) {
//        this.expenseService = expenseService;
//    }

    @GetMapping("/expenses/{name}")
    public Expense getExpense(@PathVariable String name) {
        return expenseService.getExpenseDetail(name);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void ExpenseNotFoundHandler(ExpenseNotFoundException ex) {

    }
}
