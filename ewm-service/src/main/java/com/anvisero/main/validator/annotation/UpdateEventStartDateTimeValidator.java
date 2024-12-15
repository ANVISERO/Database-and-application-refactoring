package com.anvisero.main.validator.annotation;

import com.anvisero.main.event.dto.UpdateEventDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;

public class UpdateEventStartDateTimeValidator implements ConstraintValidator<EventStartBefore, UpdateEventDto> {
    EventStartBefore check;

    @Override
    public void initialize(final EventStartBefore check) {
        this.check = check;
    }

    @Override
    public boolean isValid(final UpdateEventDto updateEventDto, final ConstraintValidatorContext ctx) {
        if (updateEventDto.getEventDate() != null) {
            return (updateEventDto.getEventDate().isAfter(LocalDateTime.now().plusHours(check.min())));
        } else {
            return true;
        }
    }
}
