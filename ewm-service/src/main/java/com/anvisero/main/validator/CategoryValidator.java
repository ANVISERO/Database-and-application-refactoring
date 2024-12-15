package com.anvisero.main.validator;

import com.anvisero.main.category.repository.CategoryRepository;
import com.anvisero.main.exception.exceptions.CategoryUniqueNameException;
import com.anvisero.main.exception.exceptions.NotFoundException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryValidator {
    public void checkCategoryExist(final CategoryRepository categoryRepository, final Long catId) {
        if (!categoryRepository.existsById(catId)) {
            throw new NotFoundException(String.format("Category with id = %d does not exist", catId));
        }
    }

    public void checkAnotherCategoryUseName(final CategoryRepository categoryRepository,
                                            final Long catId, final String name) {
        if (categoryRepository.existsByNameAndIdNot(name, catId)) {
            throw new CategoryUniqueNameException("Name already exist");
        }
    }

    public void checkNameAlreadyExist(final CategoryRepository categoryRepository, final String name) {
        if (categoryRepository.existsByName(name)) {
            throw new CategoryUniqueNameException("Name already exist");
        }
    }
}
