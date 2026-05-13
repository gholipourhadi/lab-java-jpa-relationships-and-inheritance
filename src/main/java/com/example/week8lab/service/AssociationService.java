package com.example.week8lab.service;

import com.example.week8lab.dto.AssociationDTO;
import com.example.week8lab.dto.DivisionDTO;
import com.example.week8lab.dto.MemberDTO;
import com.example.week8lab.model.Association;
import com.example.week8lab.model.Division;
import com.example.week8lab.model.Member;
import com.example.week8lab.repository.AssociationRepository;
import com.example.week8lab.repository.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociationService {

    @Autowired
    private AssociationRepository associationRepository;

    @Autowired
    private DivisionRepository divisionRepository;

    public List<Association> getAllAssociations() {
        return associationRepository.findAll();
    }

    public Association addAssociation(AssociationDTO associationDTO) {
        Association association = new Association();
        association.setName(associationDTO.getName());

        for (DivisionDTO divisionDTO : associationDTO.getDivisions()) {
            Division division = new Division();
            division.setName(divisionDTO.getName());
            division.setDistrict(divisionDTO.getDistrict());

            if (divisionDTO.getPresident() != null) {
                Member president = createMemberFromDTO(divisionDTO.getPresident());
                division.setPresident(president);
                division.getMembers().add(president);
            }

            for (MemberDTO memberDTO : divisionDTO.getMembers()) {
                Member member = createMemberFromDTO(memberDTO);
                division.getMembers().add(member);
            }

            association.getDivisions().add(division);
        }

        return associationRepository.save(association);
    }

    public List<Division> findDivisionsByDistrict(String district) {
        return divisionRepository.findByDistrict(district);
    }

    private Member createMemberFromDTO(MemberDTO memberDTO) {
        Member member = new Member();
        member.setName(memberDTO.getName());
        member.setStatus(memberDTO.getStatus());
        member.setRenewalDate(memberDTO.getRenewalDate());
        return member;
    }
}
