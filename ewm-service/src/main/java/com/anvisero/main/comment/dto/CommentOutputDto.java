package com.anvisero.main.comment.dto;

import com.anvisero.main.comment.model.CommentStatus;
import com.anvisero.main.user.dto.UserOutputDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public final class CommentOutputDto {
    private Long id;

    @NotBlank
    private String text;

    @NotNull
    private LocalDateTime created;

    @NotNull
    private UserOutputDto author;

    @PositiveOrZero
    private Long eventId;

    private CommentStatus status;
}