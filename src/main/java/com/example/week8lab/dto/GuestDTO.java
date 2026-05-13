package com.example.week8lab.dto;

import com.example.week8lab.model.GuestStatus;

public class GuestDTO {

    private String name;
    private GuestStatus status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GuestStatus getStatus() {
        return status;
    }

    public void setStatus(GuestStatus status) {
        this.status = status;
    }
}
