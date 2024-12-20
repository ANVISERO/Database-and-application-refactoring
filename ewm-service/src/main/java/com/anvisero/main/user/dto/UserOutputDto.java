package com.anvisero.main.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class UserOutputDto {
    private Long id;

    private String name;

    private String email;
}
