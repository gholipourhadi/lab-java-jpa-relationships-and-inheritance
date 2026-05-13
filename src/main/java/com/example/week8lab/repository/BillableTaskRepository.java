package com.example.week8lab.repository;

import com.example.week8lab.model.BillableTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillableTaskRepository extends JpaRepository<BillableTask, Integer> {
}
