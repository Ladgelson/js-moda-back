package com.jsmodabackend.controller.impl;

import com.jsmodabackend.controller.swagger.ProductController;
import com.jsmodabackend.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;

@RestController
public class ProductControllerImpl implements ProductController {
    @Override
    public ResponseEntity<ProductDTO> findById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<Page<ProductDTO>> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<ProductDTO> save(ProductDTO productDTO) {
        return null;
    }

    @Override
    public ResponseEntity<ProductDTO> update(ProductDTO productDTO) {
        return null;
    }

    @Override
    public ResponseEntity<ProductDTO> delete(Integer id) {
        return null;
    }
}
