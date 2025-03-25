package com.example.nutrimarket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.USE_DEFAULTS)
@Table(name = "productos")
public class Product {
    @Id
    @Column(name = "product_id", unique = true, updatable = false)
    private int productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_category")
    private String productCategory;
    @Column(name = "product_description")
    private String productDescription;
    @Column(name = "product_Stock")
    private int productStock;
    @Column(name = "product_price")
    private double productPrice;
    @Column(name = "product_photo_url")
    private String productPhotoUrl;
}
