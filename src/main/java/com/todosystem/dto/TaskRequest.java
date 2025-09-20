package com.todosystem.dto;

import com.todosystem.model.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.OffsetDateTime;

public record TaskRequest(
        @NotBlank String title,
        String description,
        @NotNull TaskStatus status,
        OffsetDateTime dueAt
) {}
