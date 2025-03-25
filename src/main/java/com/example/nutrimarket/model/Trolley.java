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

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.USE_DEFAULTS)
@Table(name = "carrito_personal")
public class Trolley {
    @Id
    @Column(name = "carrito_id")
    private int trolleyId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "precio_total")
    private double finalPrice;
}
