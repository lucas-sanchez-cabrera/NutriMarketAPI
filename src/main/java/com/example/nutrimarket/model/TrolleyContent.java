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
@Table(name = "contenido_carrito")
public class TrolleyContent {
    @Id
    @Column(name = "id", unique = true, updatable = false)
    private int id;
    @Column(name = "carrito_id")
    private int carritoId;
    @Column(name = "product_id")
    private int productId;
    @Column(name = "product_cant")
    private int productCant;
}
