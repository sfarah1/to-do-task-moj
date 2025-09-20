package com.todosystem.model;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "tasks")
public class Task {
    @Id @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "text")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus status = TaskStatus.TODO;

    @Column(name = "due_at")
    private OffsetDateTime dueAt;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt = OffsetDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt = OffsetDateTime.now();

    @PreUpdate
    public void touch() { this.updatedAt = OffsetDateTime.now(); }

    // getters and setters (generate via IntelliJ)
}
