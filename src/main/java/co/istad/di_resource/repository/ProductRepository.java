package co.istad.di_resource.repository;

import co.istad.di_resource.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    Optional<Product> findByUuid(String uuid);
}
