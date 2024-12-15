package com.anvisero.main.event.dto;

import com.anvisero.main.category.dto.CategoryOutputDto;
import com.anvisero.main.event.model.Location;
import com.anvisero.main.event.model.State;
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
public final class EventFullOutputDto {
    private String annotation;

    private CategoryOutputDto category;

    private Long confirmedRequests;

    @JsonFormat(pattern = Constant.DATE_TIME_PATTERN)
    private LocalDateTime createdOn;

    private String description;

    @JsonFormat(pattern = Constant.DATE_TIME_PATTERN)
    private LocalDateTime eventDate;

    private Long id;

    private UserOutputDto initiator;

    private Location location;

    private Boolean paid;

    private Integer participantLimit;

    @JsonFormat(pattern = Constant.DATE_TIME_PATTERN)
    private LocalDateTime publishedOn;

    private Boolean requestModeration;

    private State state;

    private String title;

    private Long views;
}
