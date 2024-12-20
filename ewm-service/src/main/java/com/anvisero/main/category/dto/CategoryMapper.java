package com.anvisero.main.category.dto;

import com.anvisero.main.category.model.Category;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {
    public Category categoryInputDtoToCategory(final CategoryInputDto categoryInputDto) {
        return Category.builder()
                .name(categoryInputDto.getName())
                .build();
    }

    public CategoryOutputDto categoryToCategoryOutputDto(final Category category) {
        return CategoryOutputDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public Category updateCategory(final CategoryInputDto categoryInputDto, final Long catId) {
        return Category.builder()
                .id(catId)
                .name(categoryInputDto.getName())
                .build();
    }
}
