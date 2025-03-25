package com.example.nutrimarket.service;

import com.example.nutrimarket.DTO.TrolleyContentDTO;
import com.example.nutrimarket.model.TrolleyContent;
import com.example.nutrimarket.repository.TrolleyContentRepository;
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
public class TrolleyContentService {
    @Autowired
    TrolleyContentRepository trolleyContentRepository;

    /**
     * Muestra el contenido de un carrito dado su 'ID'.
     *
     * @param id    ID del carrito.
     *
     * @return  Lista del contenido del carrito.
     */
    public TrolleyContent getTrolleyById(int id) {
        return trolleyContentRepository.findByCarritoId(id);
    }

    /**
     * Muestra todos los productos que contiene un carrito
     *
     * @param trolleyId ID del carrito
     *
     * @return Lista de los ID's de los productos
     */
    public List<Integer> getAllProductsOfTrolley(int trolleyId) {
        return trolleyContentRepository.findProductIdByCarritoId(trolleyId);
    }

    /**
     * Agregar un nuevo producto al carrito.
     *
     * @param trolleyContentDTO Objeto que contiene la información sobre el producto,carrito, cliente y la cantidad.
     *                          .
     * @return  Contenido agregado al carrito.
     */
    public TrolleyContent addProduct(TrolleyContentDTO trolleyContentDTO) {
        TrolleyContent trolleyContent = new TrolleyContent();

        if (trolleyContentDTO != null) {
            trolleyContent.setCarritoId(trolleyContentDTO.getCarritoId());
            trolleyContent.setProductId(trolleyContentDTO.getProductId());
            trolleyContent.setProductCant(trolleyContentDTO.getProductCant());
        }

        return trolleyContentRepository.save(trolleyContent);
    }

    /**
     * Elimina un producto contrceto de un carrito concreto.
     *
     * @param idProduct ID del prodycto.
     * @param idTrolley ID del carrito.
     */
    public String deleteProduct(int idProduct, int idTrolley) {
        if (trolleyContentRepository.deleteByProductIdAndCarritoId(idProduct, idTrolley)) {
            return "Se elimino el producto del carrito.";
        }
        return "No se puede eliminar el producto";
    }

    /**
     * Modifica la cantidad de un producto en concreto.
     *
     * @param id    ID del carrito.
     * @param cant  Cantidad deseada del producto.
     *
     * @return  Cantidad del contenido modificado.
     */
    public TrolleyContent updateQuantityProduct(int id, int cant) {
        TrolleyContent trolleyContent = getTrolleyById(id);

        if (cant > 0) {
            trolleyContent.setProductCant(cant);
        }

        return trolleyContentRepository.save(trolleyContent);
    }
}
