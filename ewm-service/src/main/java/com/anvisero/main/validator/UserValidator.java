package com.anvisero.main.validator;

import com.anvisero.main.exception.exceptions.NotFoundException;
import com.anvisero.main.user.repository.UserRepository;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserValidator {
    public void checkUserExist(final UserRepository userRepository, final Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new NotFoundException(String.format("User with id %d does not exist", userId));
        }
    }
}
