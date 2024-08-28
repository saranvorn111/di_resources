package co.istad.di_resource.controller;

import co.istad.di_resource.model.Product;
import co.istad.di_resource.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Product addProduct(@RequestBody Product products) {
       return productService.addProduct(products);
    }

    @PutMapping("/{id}")
    public void updateProduct(@RequestBody Product request, @PathVariable Integer id) {
        productService.updateProduct(request, id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/all")
    public List<Product> findAllProducts() {
        return productService.findAllProducts();
    }

//    @PutMapping("/{uuid}")
//    public void updateProduct(@RequestBody EditProductDto request, @PathVariable String uuid) {
//        productService.updateProduct(request, uuid);
//    }

//    @GetMapping
//    public List<ProductDto> getProducts(@RequestParam(required = false, defaultValue = "") String name,
//                                       @RequestParam(required = false, defaultValue = "") Boolean status) {
//        return productService.findProducts(name, status);
//    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Integer id) {
        return productService.findProductById(id);
    }

    @GetMapping("/uuid/{uuid}")
    public Optional<Product> findProductByUuid(@PathVariable String uuid) {
        return productService.findProductByUuid(uuid);
    }
}
