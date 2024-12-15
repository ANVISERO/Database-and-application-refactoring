package com.anvisero.main.validator.annotation;

import com.anvisero.main.event.dto.EventInputDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;

public class CreateEventStartValidator implements ConstraintValidator<EventStartBefore, EventInputDto> {
    EventStartBefore check;

    @Override
    public void initialize(final EventStartBefore check) {
        this.check = check;
    }

    @Override
    public boolean isValid(final EventInputDto eventInputDto, final ConstraintValidatorContext ctx) {
        return (eventInputDto.getEventDate() != null &&
                LocalDateTime.now().plusHours(check.min()).isBefore(eventInputDto.getEventDate()));
    }
}
