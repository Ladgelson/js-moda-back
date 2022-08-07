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

@Tag(name = "Order", description = "Resources to manage data about Orders")
@RequestMapping("/api/v1/orders/}")
public interface OrderController {
    @Operation(description = "Find an existent Order by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order found", content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProductDTO.class)
                    )}),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping("/{id}")
    ResponseEntity<ProductDTO> findById(@PathVariable Integer id);

    @Operation(description = "Find all Orders paginated")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Orders found", content = @Content),
            @ApiResponse(responseCode = "204", description = "No content", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping("/")
    ResponseEntity<Page<ProductDTO>> findAll(Pageable pageable);

    @Operation(description = "Save a valid order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Order saved successfully", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PostMapping("/")
    ResponseEntity<Void> create(@RequestBody ProductDTO productDTO);

    @Operation(description = "Add a item to a order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product updated successfully", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping("/{id}/")
    ResponseEntity<ProductDTO> addItem(@RequestBody ProductDTO productDTO, @PathVariable Integer id);

    @Operation(description = "Remove a item of a order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product updated successfully", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping("/{id}/")
    ResponseEntity<ProductDTO> removeItem(@RequestBody ProductDTO productDTO, @PathVariable Integer id);

    @Operation(description = "Add items to a order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product updated successfully", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping("/{id}/")
    ResponseEntity<ProductDTO> addItems(@RequestBody ProductDTO productDTO, @PathVariable Integer id);

    @Operation(description = "Add items to a order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product updated successfully", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping("/{id}/")
    ResponseEntity<ProductDTO> finishOrder(@RequestBody ProductDTO productDTO, @PathVariable Integer id);
}
