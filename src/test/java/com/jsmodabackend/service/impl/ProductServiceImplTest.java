package com.jsmodabackend.service.impl;

import com.jsmodabackend.dto.ProductDTO;
import com.jsmodabackend.model.Product;
import com.jsmodabackend.repository.ProductRepository;
import com.jsmodabackend.service.interfaces.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    @Spy
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    private Product productMock;

    @BeforeEach
    void setUp() {
        productMock = new Product();
        productMock.setBuyingPrice(60.0);
        productMock.setName("Camisa Gola Polo Renner");
        productMock.setStock(10);
        productMock.setSellingPrice(100.0);

        Mockito.when(productRepository.findById(5))
                .thenReturn(Optional.of(productMock));

        Mockito.when(productRepository.save(productMock))
                .thenReturn(productMock);

        Mockito.doNothing().when(productRepository).deleteById(5);

        Mockito.when(productRepository.findAll((Pageable) any()))
                .thenReturn(new PageImpl<>(List.of(productMock)));

    }

    @Test
    @DisplayName("Should returns a valid product")
    void findById() {
        ProductDTO actual = productService.findById(5);
        assertNotNull(actual);
        assertEquals(productMock.getBuyingPrice(), actual.getBuyingPrice());
        assertEquals(productMock.getName(), actual.getName());
        assertEquals(productMock.getStock(), actual.getStock());
        assertEquals(productMock.getSellingPrice(), actual.getSellingPrice());
    }

    @Test
    @DisplayName("Should find a list of products")
    void findAll() {
        Page<ProductDTO> products = productService.findAll(null);
        assertEquals(2, products.getTotalElements());
    }

    @Test
    void save() {
        productService.save(new ProductDTO());
    }

    @Test
    void update() {
    }

    @Test
    @DisplayName("Should delete a product")
    void delete() {
        productService.delete(5);
        Mockito.verify(productRepository).deleteById(5);
    }
}
