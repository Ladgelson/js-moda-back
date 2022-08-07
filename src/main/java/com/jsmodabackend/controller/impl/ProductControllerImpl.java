package com.jsmodabackend.controller.impl;

import com.jsmodabackend.controller.swagger.ProductController;
import com.jsmodabackend.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductControllerImpl implements ProductController {
    @Override
    public ResponseEntity<ProductDTO> findById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<Page<ProductDTO>> findAll(org.springframework.data.domain.Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<Void> save(ProductDTO productDTO) {
        return null;
    }

    @Override
    public ResponseEntity<ProductDTO> update(ProductDTO productDTO, Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        return null;
    }
}
