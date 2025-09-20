package com.todosystem.dto;

import com.todosystem.model.TaskStatus;
import java.time.OffsetDateTime;
import java.util.UUID;

public record TaskResponse(
        UUID id, String title, String description, TaskStatus status,
        OffsetDateTime dueAt, OffsetDateTime createdAt, OffsetDateTime updatedAt
) {}
