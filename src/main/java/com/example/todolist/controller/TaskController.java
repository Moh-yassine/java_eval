package com.example.todolist.controller;

import com.example.todolist.model.Task;
import com.example.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/tasks")
    public String getAllTasks(Model model) {
        List<Task> tasks = taskRepository.findAll();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/tasks/{id}")
    public String getTaskById(@PathVariable Long id, Model model) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            model.addAttribute("task", task.get());
            return "task-detail";
        } else {
            return "error";
        }
    }
}
