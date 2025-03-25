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
@Table(name = "usuarios")
public class Client {
    @Id
    @Column(name = "user_id", unique = true, updatable = false)
    private int userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "user_address")
    private String userAddress;
    @Column(name = "user_rol")
    private String userRol;
    @Column(name = "user_photo_url")
    private String userPhotoUrl;
}
