package co.istad.di_resource.service.impl;

import co.istad.di_resource.dto.CategoryResponse;
import co.istad.di_resource.model.Category;
import co.istad.di_resource.repository.CategoryRepository;
import co.istad.di_resource.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(Category category) {

        if(categoryRepository.existsByName(category.getName())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Category name already exist");
        }
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
    }

    @Override
    public Optional<CategoryResponse> findCategoryByName(String name) {
        return categoryRepository.findByName(name)
                .stream().map(category -> new CategoryResponse(category.getName(), category.getDescription())).findFirst();
    }

    @Override
    public void updateCategory(CategoryResponse categoryResponse, Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        category.setName(categoryResponse.name());
        category.setDescription(categoryResponse.description());
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        categoryRepository.delete(category);
    }

}
