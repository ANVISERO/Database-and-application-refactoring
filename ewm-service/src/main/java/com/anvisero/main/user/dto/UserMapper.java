package com.anvisero.main.user.dto;

import com.anvisero.main.user.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {
    public User userInputDtoToUser(final UserInputDto userInputDto) {
        return User.builder()
                .name(userInputDto.getName())
                .email(userInputDto.getEmail())
                .build();
    }

    public UserOutputDto userToOutputUserDto(final User user) {
        return UserOutputDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .id(user.getId())
                .build();
    }
}
