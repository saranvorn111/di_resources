package co.istad.di_resource.service;

import co.istad.di_resource.dto.CategoryResponse;
import co.istad.di_resource.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> findAllCategory();

    Category createCategory(Category category);

    Category findById(Integer id);

    Optional<CategoryResponse> findCategoryByName(String name);

    void updateCategory(CategoryResponse categoryResponse, Integer id);

    void deleteCategory(Integer id);
}
