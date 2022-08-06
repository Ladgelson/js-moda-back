package com.jsmodabackend.config;

import com.jsmodabackend.enums.Sex;
import com.jsmodabackend.model.Category;
import com.jsmodabackend.model.Product;
import com.jsmodabackend.repository.CategoryRepository;
import com.jsmodabackend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import java.time.Instant;

@Configuration
@RequiredArgsConstructor
public class Seeding implements CommandLineRunner {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        productRepository.deleteAll();
        Product camisaGolaPolo = Product.builder()
                .name("Gola Polo")
                .buyingPrice(25.00)
                .sellingPrice(40.0)
                .stock(0)
                .build();
        Category camisaMasculina = new Category("Camisa Masculina", Sex.MALE, null);
        categoryRepository.save(camisaMasculina);
        camisaGolaPolo.setCategory(camisaMasculina);
        productRepository.save(camisaGolaPolo);
    }
}
