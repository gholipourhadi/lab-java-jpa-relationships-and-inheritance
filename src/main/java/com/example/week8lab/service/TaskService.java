package com.example.week8lab.service;

import com.example.week8lab.dto.TaskDTO;
import com.example.week8lab.model.BillableTask;
import com.example.week8lab.model.InternalTask;
import com.example.week8lab.model.Task;
import com.example.week8lab.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task addTask(TaskDTO taskDTO) {
        Task task;

        if ("billable".equalsIgnoreCase(taskDTO.getType())) {
            BillableTask billableTask = new BillableTask();
            billableTask.setHourlyRate(taskDTO.getHourlyRate());
            task = billableTask;
        } else {
            task = new InternalTask();
        }

        task.setTitle(taskDTO.getTitle());
        task.setDueDate(taskDTO.getDueDate());
        task.setCompleted(taskDTO.isCompleted());

        return taskRepository.save(task);
    }
}
