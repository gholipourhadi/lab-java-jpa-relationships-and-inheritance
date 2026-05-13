package com.example.week8lab.repository;

import com.example.week8lab.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DivisionRepository extends JpaRepository<Division, Integer> {

    List<Division> findByDistrict(String district);
}
