package com.anvisero.main.request.service;

import com.anvisero.main.request.dto.RequestOutputDto;
import com.anvisero.main.request.dto.RequestOutputUpdateStatusDto;
import com.anvisero.main.request.dto.RequestUpdateInputStatusDto;

import java.util.List;

public interface RequestService {
    RequestOutputDto createRequest(final Long userId, final Long eventId);

    List<RequestOutputDto> findUserRequests(final Long userId);

    RequestOutputDto cancelRequest(final Long userId, final Long requestId);

    List<RequestOutputDto> userParticipatesInEvent(final Long userId, final Long eventId);

    RequestOutputUpdateStatusDto changeRequestStatus(final Long userId, final Long eventId,
                                                     final RequestUpdateInputStatusDto updateState);
}