package com.example.nutrimarket.DTO;

import lombok.Data;

@Data
public class ClientDTO {
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userAddress;
    private String userRol;
    private String userPhotoUrl;
}
