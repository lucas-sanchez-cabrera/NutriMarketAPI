package com.example.nutrimarket.service;

import com.example.nutrimarket.DTO.TrolleyDTO;
import com.example.nutrimarket.model.Trolley;
import com.example.nutrimarket.repository.TrolleyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class TrolleyService {
    @Autowired
    TrolleyRepository trolleyRepository;

    /**
     * Muestra todos los carritos existentes.
     *
     * @return  Lista de carritos.
     */
    public List<Trolley> getAllTrolley() {
        return trolleyRepository.findAll();
    }

    /**
     * Muestra un carrito dado su 'id'.
     *
     * @param id    Id del carrito.
     *
     * @return  Carrito concreto.
     */
    public Trolley getTrolleyById(int id) {
        return trolleyRepository.findByTrolleyId(id);
    }

    public Trolley getTrolleyByUserId(int id) {
        return trolleyRepository.findByUserId(id);
    }

    /*
    public double getTotalPrice(int id) {
        return trolleyRepository.calculateTotalPriceOfTrolley(id);
    }
    */

    /**
     * Eliminación de un carrito dado su 'id'.
     *
     * @param id    Id del carrito.
     */
    public void deleteTrolleyById(int id) {
        trolleyRepository.deleteById(id);
    }

    /**
     * Crea un nuevo carrito.
     *
     * @param trolleyDTO Objeto que contiene los datos del nuevo carrito.
     *
     * @return  Carrito creado.
     */
    public Trolley createTrolley(TrolleyDTO trolleyDTO) {
        Trolley trolley = new Trolley();

        if (trolleyDTO != null) {
            trolley.setUserId(trolleyDTO.getUserId());
        }

        return trolleyRepository.save(trolley);
    }

    /**
     * Modificación de los campos de un carrito.
     *
     * @param id            Id del carrito.
     * @param trolleyDTO    Obajeto que contiene los datos modificados.
     *
     * @return  Carrito modificado.
     */
    public Trolley updateTrolley(int id, TrolleyDTO trolleyDTO) {
        Trolley trolley = trolleyRepository.findByTrolleyId(id);

        if (trolleyDTO != null) {
            trolley.setUserId(trolleyDTO.getUserId());
        }

        return trolleyRepository.save(trolley);
    }
}
