package com.example.week8lab.repository;

import com.example.week8lab.model.InternalTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternalTaskRepository extends JpaRepository<InternalTask, Integer> {
}
