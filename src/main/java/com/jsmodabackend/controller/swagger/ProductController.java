package com.jsmodabackend.controller.swagger;

import com.jsmodabackend.dto.ProductDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Pageable;

@Tag(name = "Product", description = "Resources to manage data about Products")
@RequestMapping("/api/v1/products")
public interface ProductController {
    @Operation(description = "Find an existent Product by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product found", content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProductDTO.class)
                    )}),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping("/{id}")
    ResponseEntity<ProductDTO> findById(@PathVariable Integer id);

    ResponseEntity<Page<ProductDTO>> findAll(Pageable pageable);
    ResponseEntity<ProductDTO> save(ProductDTO productDTO);
    ResponseEntity<ProductDTO> update(ProductDTO productDTO);
    ResponseEntity<ProductDTO> delete(Integer id);
}
