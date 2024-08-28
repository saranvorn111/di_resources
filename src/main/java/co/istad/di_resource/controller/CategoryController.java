package co.istad.di_resource.controller;

import co.istad.di_resource.dto.CategoryResponse;
import co.istad.di_resource.model.Category;
import co.istad.di_resource.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> findAllCategory() {
        return categoryService.findAllCategory();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @GetMapping("/{id}")
    public Category findCategoryById(@PathVariable Integer id) {
        return categoryService.findById(id);
    }

    @GetMapping("/name/{name}")
    public Optional<CategoryResponse> findCategoryByName(@PathVariable String name) {
        return categoryService.findCategoryByName(name);
    }

    @PutMapping("/{id}")
    public void updateCategory(@RequestBody CategoryResponse categoryResponse, @PathVariable Integer id) {
        categoryService.updateCategory(categoryResponse, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }
}
