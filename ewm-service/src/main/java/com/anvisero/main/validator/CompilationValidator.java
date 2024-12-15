package com.anvisero.main.validator;

import com.anvisero.main.compilation.repository.CompilationRepository;
import com.anvisero.main.exception.exceptions.NotFoundException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CompilationValidator {
    public void checkCompilationExist(final CompilationRepository compilationRepository, final Long compId) {
        if (!compilationRepository.existsById(compId)) {
            throw new NotFoundException(String.format("Compilation with id = %d does not exist", compId));
        }
    }
}
