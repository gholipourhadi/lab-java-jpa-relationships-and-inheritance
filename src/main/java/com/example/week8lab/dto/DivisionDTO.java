package com.example.week8lab.dto;

import java.util.ArrayList;
import java.util.List;

public class DivisionDTO {

    private String name;
    private String district;
    private MemberDTO president;
    private List<MemberDTO> members = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public MemberDTO getPresident() {
        return president;
    }

    public void setPresident(MemberDTO president) {
        this.president = president;
    }

    public List<MemberDTO> getMembers() {
        return members;
    }

    public void setMembers(List<MemberDTO> members) {
        this.members = members;
    }
}
