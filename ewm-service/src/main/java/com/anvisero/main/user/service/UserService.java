package com.anvisero.main.user.service;

import com.anvisero.main.user.dto.UserInputDto;
import com.anvisero.main.user.dto.UserOutputDto;

import java.util.List;

public interface UserService {
    UserOutputDto saveUser(final UserInputDto userInputDto);

    List<UserOutputDto> getUsers(final List<Long> ids, final Integer from, final Integer size);

    void deleteUser(final Long userId);
}
