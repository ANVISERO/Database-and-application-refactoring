package com.anvisero.main.event.dto;

import com.anvisero.main.category.dto.CategoryOutputDto;
import com.anvisero.main.user.dto.UserOutputDto;
import com.anvisero.stats.dto.model.Constant;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class EventShortOutputDto {
    private String annotation;

    private CategoryOutputDto category;

    private Long confirmedRequests;

    private Long id;

    @JsonFormat(pattern = Constant.DATE_TIME_PATTERN)
    private LocalDateTime eventDate;

    private UserOutputDto initiator;

    private Boolean paid;

    private String title;

    private Long views;
}
