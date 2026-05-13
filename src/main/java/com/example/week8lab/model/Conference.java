package com.example.week8lab.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Conference extends Event {

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Speaker> speakers = new ArrayList<>();

    public Conference() {
    }

    public List<Speaker> getSpeakers() {
        return speakers;
    }
}
