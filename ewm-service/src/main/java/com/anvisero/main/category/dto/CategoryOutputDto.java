package com.anvisero.main.category.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class CategoryOutputDto {
    private Long id;

    private String name;
}
