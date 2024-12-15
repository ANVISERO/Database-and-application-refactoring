package com.anvisero.main.request.dto;

import com.anvisero.main.request.model.RequestStatus;
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
public final class RequestOutputDto {
    @JsonFormat(pattern = Constant.DATE_TIME_PATTERN)
    private LocalDateTime created;

    private Long event;

    private Long id;

    private Long requester;

    private RequestStatus status;
}
