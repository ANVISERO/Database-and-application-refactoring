package com.anvisero.main.user.service;

import com.anvisero.main.exception.exceptions.UserEmailConflictException;
import com.anvisero.main.user.dto.UserInputDto;
import com.anvisero.main.user.dto.UserMapper;
import com.anvisero.main.user.dto.UserOutputDto;
import com.anvisero.main.user.repository.UserCriteria;
import com.anvisero.main.user.repository.UserRepository;
import com.anvisero.main.user.repository.UserSpecification;
import com.anvisero.main.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserOutputDto saveUser(final UserInputDto userInputDto) {
        if (userRepository.existsByEmail(userInputDto.getEmail())) {
            throw new UserEmailConflictException("Email already exist");
        }
        return UserMapper.userToOutputUserDto(userRepository.save(UserMapper.userInputDtoToUser(userInputDto)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserOutputDto> getUsers(final List<Long> ids, final Integer from, final Integer size) {
        Pageable pageable = PageRequest.of(from / size, size);
        UserCriteria criteria = UserCriteria.builder().ids(ids).build();
        UserSpecification userSpecification = new UserSpecification(criteria);
        return userRepository.findAll(userSpecification, pageable).stream()
                .map(UserMapper::userToOutputUserDto)
                .collect(Collectors.toList());

    }

    @Override
    @Transactional
    public void deleteUser(final Long userId) {
        UserValidator.checkUserExist(userRepository, userId);
        userRepository.deleteById(userId);
    }
}
