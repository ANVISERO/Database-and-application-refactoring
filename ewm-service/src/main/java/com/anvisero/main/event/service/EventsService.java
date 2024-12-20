package com.anvisero.main.event.service;

import com.anvisero.main.event.dto.EventFullOutputDto;
import com.anvisero.main.event.dto.EventInputDto;
import com.anvisero.main.event.dto.EventShortOutputDto;
import com.anvisero.main.event.dto.UpdateEventDto;

import java.time.LocalDateTime;
import java.util.List;

public interface EventsService {
    EventFullOutputDto addEvent(final Long userId, final EventInputDto eventInputDto);

    List<EventShortOutputDto> getUserEvents(final Long userId, final Integer from, final Integer size);

    EventFullOutputDto getUserEventById(final Long userId, final Long eventId);

    EventFullOutputDto updateEvent(final Long userId, final Long eventId, final UpdateEventDto updateEventDto);

    List<EventFullOutputDto> adminSearchEvents(final List<Long> users, final List<String> states,
                                               final List<Long> categories, LocalDateTime rangeStart,
                                               final LocalDateTime rangeEnd, final Integer from,
                                               final Integer size);

    EventFullOutputDto adminUpdateEvent(final Long eventId, final UpdateEventDto updateEventDto);

    List<EventShortOutputDto> publicSearchEvents(final String text, final List<Long> categories,
                                                 final Boolean paid, LocalDateTime rangeStart,
                                                 final LocalDateTime rangeEnd, final Boolean onlyAvailable,
                                                 final String sort, final Integer from,
                                                 final Integer size, final String ip);

    EventFullOutputDto getEventById(final Long id, final String ip);
}