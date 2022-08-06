package com.jsmodabackend.controller.swagger;

import com.jsmodabackend.dto.CategoryDTO;
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

@Tag(name = "Category", description = "Resources to manage data about Categories")
@RequestMapping("/api/v1/categories")
public interface CategoryController {
    @Operation(description = "Find an existent Category by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category found", content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDTO.class)
                    )}),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping("/{id}")
    ResponseEntity<CategoryDTO> findById(@PathVariable Integer id);

    ResponseEntity<Page<CategoryDTO>> findAll(Pageable pageable);
    ResponseEntity<CategoryDTO> save(CategoryDTO productDTO);
    ResponseEntity<CategoryDTO> update(CategoryDTO productDTO);
    ResponseEntity<CategoryDTO> delete(Integer id);
}
