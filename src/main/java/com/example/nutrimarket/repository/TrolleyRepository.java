package com.example.nutrimarket.repository;

import com.example.nutrimarket.model.Trolley;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrolleyRepository extends JpaRepository<Trolley, Integer> {
    Trolley findByTrolleyId(int id);

    Trolley findByUserId(int id);

    void deleteById(int id);

    @SuppressWarnings({"null", "unchaked"})
    Trolley save(Trolley trolley);

    //@Query("SELECT SUM(p.productCant * c.finalPrice) FROM TrolleyContent c JOIN Trolley p ON c.carritoId = p.trolleyId WHERE c.carritoId = ?1")
    //double calculateTotalPriceOfTrolley(int trolleyId);
}
