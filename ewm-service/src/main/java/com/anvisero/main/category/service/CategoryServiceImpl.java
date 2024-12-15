package com.anvisero.main.category.service;

import com.anvisero.main.category.dto.CategoryInputDto;
import com.anvisero.main.category.dto.CategoryMapper;
import com.anvisero.main.category.dto.CategoryOutputDto;
import com.anvisero.main.category.model.Category;
import com.anvisero.main.category.repository.CategoryRepository;
import com.anvisero.main.event.repository.EventRepository;
import com.anvisero.main.exception.exceptions.CategoryDeleteException;
import com.anvisero.main.exception.exceptions.NotFoundException;
import com.anvisero.main.validator.CategoryValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final EventRepository eventRepository;
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public CategoryOutputDto createCategory(final CategoryInputDto categoryInputDto) {
        CategoryValidator.checkNameAlreadyExist(categoryRepository, categoryInputDto.getName());
        return CategoryMapper.categoryToCategoryOutputDto(
                categoryRepository.save(CategoryMapper.categoryInputDtoToCategory(categoryInputDto)));
    }

    @Override
    @Transactional
    public void deleteCategory(final Long catId) {
        CategoryValidator.checkCategoryExist(categoryRepository, catId);
        if (eventRepository.existsByCategoryId(catId)) {
            throw new CategoryDeleteException(String.format("Category with id = %d does not exist", catId));
        }
        categoryRepository.deleteById(catId);
    }

    @Override
    @Transactional
    public CategoryOutputDto updateCategory(final Long catId, final CategoryInputDto categoryInputDto) {
        CategoryValidator.checkCategoryExist(categoryRepository, catId);
        CategoryValidator.checkAnotherCategoryUseName(categoryRepository, catId, categoryInputDto.getName());
        return CategoryMapper.categoryToCategoryOutputDto(
                CategoryMapper.updateCategory(categoryInputDto, catId));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryOutputDto> getAllCategories(final Integer from, final Integer size) {
        Pageable pageable = PageRequest.of(from / size, size);
        return categoryRepository.findAll(pageable).stream()
                .map(CategoryMapper::categoryToCategoryOutputDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryOutputDto getCategoryById(final Long catId) {
        Category category = categoryRepository.findById(catId)
                .orElseThrow(() -> new NotFoundException(String.format("Category with id = %d does not exist", catId)));
        return CategoryMapper.categoryToCategoryOutputDto(category);
    }
}