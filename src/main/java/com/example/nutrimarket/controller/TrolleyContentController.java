package com.example.nutrimarket.controller;

import com.example.nutrimarket.DTO.TrolleyContentDTO;
import com.example.nutrimarket.model.TrolleyContent;
import com.example.nutrimarket.service.TrolleyContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contenido")
public class TrolleyContentController {
    @Autowired
    TrolleyContentService trolleyContentService;

    @GetMapping("/{id}")
    public List<Integer> getProductsByTrolleyId(@PathVariable int id) {
        return trolleyContentService.getAllProductsOfTrolley(id);
    }

    @DeleteMapping("/delete/productId-trolleyId")
    public String deleteProductOfTrolley(@RequestParam("productId") int idProduct, @RequestParam("trolleyId") int idTrolley) {
        return trolleyContentService.deleteProduct(idProduct, idTrolley);
    }

    @PostMapping
    public TrolleyContent addProductToTrolley(@RequestBody TrolleyContentDTO trolleyContentDTO) {
        return trolleyContentService.addProduct(trolleyContentDTO);
    }

    @PutMapping("/id-cantidad")
    public TrolleyContent updateQuantityProductOfTrolley(@RequestParam("trolleyId") int id, @RequestParam("productQuantity") int quantity) {
        return trolleyContentService.updateQuantityProduct(id, quantity);
    }
}
