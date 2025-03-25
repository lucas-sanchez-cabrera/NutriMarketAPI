package com.example.nutrimarket.repository;

import com.example.nutrimarket.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    @SuppressWarnings("null")
    List<Client> findAll();

    Client findByUserId(int id);

    List<Client> findByUserRol(String rol);

    Client findByUserEmailAndUserPassword(String email, String password);

    void deleteByUserPassword(String pasword);

    int deleteByUserId(int id);

    @SuppressWarnings({"null", "unchaked"})
    Client save(Client client);
}
