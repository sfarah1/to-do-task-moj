package com.todosystem.service;

import com.todosystem.dto.TaskRequest;
import com.todosystem.dto.TaskResponse;
import com.todosystem.model.Task;
import com.todosystem.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repo;

    public TaskService(TaskRepository repo) { this.repo = repo; }

    @Transactional
    public TaskResponse create(TaskRequest r) {
        Task t = new Task();
        t.setTitle(r.title());
        t.setDescription(r.description());
        t.setStatus(r.status());
        t.setDueAt(r.dueAt());
        return toDto(repo.save(t));
    }

    @Transactional(readOnly = true)
    public List<TaskResponse> all() {
        return repo.findAll().stream().map(this::toDto).toList();
    }

    private TaskResponse toDto(Task t) {
        return new TaskResponse(
                t.getId(), t.getTitle(), t.getDescription(), t.getStatus(),
                t.getDueAt(), t.getCreatedAt(), t.getUpdatedAt()
        );
    }
}
