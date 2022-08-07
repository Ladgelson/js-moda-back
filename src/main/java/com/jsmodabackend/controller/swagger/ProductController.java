package com.jsmodabackend.controller.swagger;

import com.jsmodabackend.dto.ProductDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Operation(description = "Find all Products paginated")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Products found", content = @Content),
            @ApiResponse(responseCode = "204", description = "No content", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping("/")
    ResponseEntity<Page<ProductDTO>> findAll(Pageable pageable);

    @Operation(description = "Save a valid product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product saved successfully", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PostMapping("/")
    ResponseEntity<Void> save(@RequestBody ProductDTO productDTO);

    @Operation(description = "Update a product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product updated successfully", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PutMapping("/{id}")
    ResponseEntity<ProductDTO> update(@RequestBody ProductDTO productDTO, @PathVariable Integer id);

    @Operation(description = "Update a product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product updated successfully", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Integer id);
}
