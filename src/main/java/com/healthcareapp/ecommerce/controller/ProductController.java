package com.healthcareapp.ecommerce.controller;

import com.healthcareapp.ecommerce.dto.ProductDTO;
import com.healthcareapp.ecommerce.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/productAdmin")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @DeleteMapping(value = "/product/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable("id") Long id) throws Exception {
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO product) {

        return ResponseEntity.ok().body(productService.createProduct(product));
    }

    @PutMapping(value = "/product/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable("id") long id,
                                             @RequestBody ProductDTO product) {
        return ResponseEntity.ok().body(productService.updateProduct(id, product));
    }
}
