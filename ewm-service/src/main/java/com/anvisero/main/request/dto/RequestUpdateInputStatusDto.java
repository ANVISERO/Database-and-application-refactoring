package com.anvisero.main.request.dto;

import com.anvisero.main.request.model.RequestStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class RequestUpdateInputStatusDto {
    private List<Long> requestIds;

    private RequestStatus status;
}
