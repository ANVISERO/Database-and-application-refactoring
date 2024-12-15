package com.anvisero.main.category.repository;


import com.anvisero.main.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Boolean existsByName(final String name);

    Boolean existsByNameAndIdNot(final String name, final Long catId);
}
