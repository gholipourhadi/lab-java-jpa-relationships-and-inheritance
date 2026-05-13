package com.example.week8lab.repository;

import com.example.week8lab.model.Guest;
import com.example.week8lab.model.GuestStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Integer> {

    List<Guest> findByStatus(GuestStatus status);
}
