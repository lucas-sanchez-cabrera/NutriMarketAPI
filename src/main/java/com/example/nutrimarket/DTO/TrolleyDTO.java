package com.example.nutrimarket.DTO;

import com.example.nutrimarket.model.Product;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
public class TrolleyDTO {
    private int userId;
    private List<Product> productsList;
    private double finalPrice;
}
