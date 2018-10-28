package com.reimburse2.remiburse2.repository;

import com.reimburse2.remiburse2.domain.Expense;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {

    public Expense findByName(String name);

    @Override
    Iterable<Expense> findAll();

    @Query("select exp from Expense exp where exp.name = :name")
    public Expense findByCustom (@Param ("name") String name);

}
