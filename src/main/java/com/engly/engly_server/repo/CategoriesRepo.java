package com.engly.engly_server.repo;

import com.engly.engly_server.models.entity.Categories;
import com.engly.engly_server.models.enums.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriesRepo extends JpaRepository<Categories, String> {
    Optional<Categories> findByName(CategoryType name);
}
