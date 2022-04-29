package com.healthcareapp.ecommerce.service;

import com.healthcareapp.ecommerce.dao.ProductRepository;
import com.healthcareapp.ecommerce.dto.ProductDTO;
import com.healthcareapp.ecommerce.entity.Product;
import com.healthcareapp.ecommerce.entity.ProductCategory;
import com.healthcareapp.ecommerce.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;

    @Autowired
    private ProductRepository repo;

    @Transactional
    public void deleteProductById(Long id) throws Exception {
        if (Objects.isNull(id) || repo.findById(id).isEmpty()) {
            throw new Exception("Product not found");
        }
        repo.deleteById(id);
    }


    public ProductDTO createProduct(ProductDTO product) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(1L);
        Product productEntity = productMapper.map(product);
        productEntity.setActive(true);
        productEntity.setDateCreated(new Date());
        productEntity.setLastUpdated(new Date());
        productEntity.setCategory(productCategory);
        productEntity.setImageUrl("assets/images/products/generic.png");
        return productMapper.map(repo.save(productEntity));

    }

    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = repo.findById(id).get();

        product.setDescription(productDTO.getDescription());
        product.setName(productDTO.getName());
        product.setUnitPrice(productDTO.getUnitPrice());
        product.setUnitsInStock(productDTO.getUnitsInStock());

        var productEntity = repo.save(product);
        return productMapper.map(productEntity);
    }


}
