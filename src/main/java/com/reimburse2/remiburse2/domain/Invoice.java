package com.reimburse2.remiburse2.domain;

public class Invoice {

    private Long id;
    private Boolean approved = false;
    String title;

    public Invoice(String title) {
        this.title = title;
        this.id = 1L;
    }

    public Long getId() {
        return id;
    }

    public boolean submit() {
        return approved == true;
    }

    public void approve() {
        this.approved = true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
