package com.todosystem.controller;

import com.todosystem.dto.TaskRequest;
import com.todosystem.dto.TaskResponse;
import com.todosystem.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) { this.service = service; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponse create(@RequestBody @Valid TaskRequest req) {
        return service.create(req);
    }

    @GetMapping
    public List<TaskResponse> all() {
        return service.all();
    }
}
