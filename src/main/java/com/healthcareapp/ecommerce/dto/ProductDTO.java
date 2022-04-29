package com.healthcareapp.ecommerce.dto;

import com.healthcareapp.ecommerce.entity.ProductCategory;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductDTO {

    private String name;
    private String description;
    private BigDecimal unitPrice;
    private Integer unitsInStock;
    private Long id;
    private String sku;
    private String imageUrl;
    private ProductCategory category;
    private boolean active;
    private Date dateCreated;
    private Date lastUpdated;
}
