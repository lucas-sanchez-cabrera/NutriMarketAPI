package com.example.nutrimarket.DTO;

import lombok.Data;

@Data
public class ProductDTO {
    private String productName;
    private String productCategory;
    private String productDescription;
    private int productStock;
    private double productPrice;
    private String productPhotoUrl;
}
