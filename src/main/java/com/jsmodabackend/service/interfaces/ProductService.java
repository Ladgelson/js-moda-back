package com.jsmodabackend.service.interfaces;

import com.jsmodabackend.dto.CategoryDTO;
import com.jsmodabackend.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    ProductDTO findById(Integer id);
    Page<ProductDTO> findAll(Pageable pageable);
    void save(ProductDTO productDTO);
    ProductDTO update(ProductDTO productDTO, Integer id);
    void delete(Integer id);
}
