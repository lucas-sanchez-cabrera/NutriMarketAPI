package com.example.nutrimarket.repository;

import com.example.nutrimarket.model.TrolleyContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrolleyContentRepository extends JpaRepository<TrolleyContent, Integer> {
    @SuppressWarnings({"null"})
    TrolleyContent findByCarritoId(int id);

    List<Integer> findProductIdByCarritoId(int trolleyId);

    boolean deleteByProductIdAndCarritoId(int idProduct, int idTrolley);

    @SuppressWarnings({"null", "unchaked"})
    TrolleyContent save(TrolleyContent trolleyContent);
}
