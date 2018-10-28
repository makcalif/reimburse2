package com.reimburse2.remiburse2.domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Expense {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Expense() {
    }

    public Expense(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
