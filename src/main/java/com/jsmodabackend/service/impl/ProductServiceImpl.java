package com.jsmodabackend.service.impl;

import com.jsmodabackend.dto.ProductDTO;
import com.jsmodabackend.service.interfaces.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public ProductDTO findById(Integer id) {
        return null;
    }

    @Override
    public Page<ProductDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void save(ProductDTO productDTO) {

    }

    @Override
    public ProductDTO update(ProductDTO productDTO, Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
