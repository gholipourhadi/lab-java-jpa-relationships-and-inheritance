package com.example.week8lab.dto;

import com.example.week8lab.model.MemberStatus;

import java.time.LocalDate;

public class MemberDTO {

    private String name;
    private MemberStatus status;
    private LocalDate renewalDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MemberStatus getStatus() {
        return status;
    }

    public void setStatus(MemberStatus status) {
        this.status = status;
    }

    public LocalDate getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(LocalDate renewalDate) {
        this.renewalDate = renewalDate;
    }
}
