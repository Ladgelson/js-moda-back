package com.jsmodabackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private String name;

    private Double sellingPrice;

    private Double buyingPrice;

    private int stock;

    private CategoryDTO category;
}
