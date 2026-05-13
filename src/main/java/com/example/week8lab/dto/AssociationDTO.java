package com.example.week8lab.dto;

import java.util.ArrayList;
import java.util.List;

public class AssociationDTO {

    private String name;
    private List<DivisionDTO> divisions = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DivisionDTO> getDivisions() {
        return divisions;
    }

    public void setDivisions(List<DivisionDTO> divisions) {
        this.divisions = divisions;
    }
}
