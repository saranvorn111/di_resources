package co.istad.di_resource.service;
import co.istad.di_resource.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product addProduct(Product request);

    List<Product> findAllProducts();

    void updateProduct(Product request, Integer id);
    void deleteProduct(Integer id);

//    void updateProduct(EditProductDto request, String uuid);
//    List<ProductDto> findProductsByName(String name);
    Product findProductById(Integer id);

    Optional<Product> findProductByUuid(String uuid);
}
