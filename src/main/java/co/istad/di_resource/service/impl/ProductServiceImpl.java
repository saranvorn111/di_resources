package co.istad.di_resource.service.impl;

import co.istad.di_resource.model.Product;
import co.istad.di_resource.repository.ProductRepository;
import co.istad.di_resource.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product addProduct(Product request) {
        Product product = new Product();
        product.setId(request.getId());
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setQty(request.getQty());
        product.setStatus(request.getStatus());
        product.setLocalDateTime(LocalDateTime.now());
        product.setUuid(UUID.randomUUID().toString());
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void updateProduct(Product request, Integer id) {
        Product product = findProductById(id);
        if (product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setQty(request.getQty());
        product.setStatus(request.getStatus());

        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        Product product = findProductById(id);
        if (product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
        productRepository.delete(product);

    }

    @Override
    public Product findProductById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    }

    @Override
    public Optional<Product> findProductByUuid(String uuid) {
        return productRepository.findByUuid(uuid);
    }

}
