package com.example.nutrimarket.service;

import com.example.nutrimarket.DTO.ProductDTO;
import com.example.nutrimarket.model.Product;
import com.example.nutrimarket.repository.ProductRepository;
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
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    /**
     * Muestra todos los productos existentes.
     *
     * @return  Lista de los productos existentes.
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Muestra un producto dado su 'id'.
     *
     * @param id    Id del producto.
     *
     * @return  Producto con el mismo id.
     */
    public Product getProductById(int id) {
        return productRepository.findByProductId(id);
    }

    /**
     * Muestra todos los productos de una misma coategoria.
     *
     * @param category  Categoria de por la que hacer la búsqueda de los productos.
     *
     * @return  Lista de productos que coincidan con la categoria.
     */
    public List<Product> getProductByCategory(String category) {
        return productRepository.findByProductCategory(category);
    }

    /**
     * Muestra todos los productos con el mismo nombre.
     *
     * @param name  Nombre por el que haremos la búsqueda.
     *
     * @return  Lista de productos que coincidan con el nombre.
     */
    public List<Product> getProductByName(String name) {
        return productRepository.findByProductName(name);
    }

    /**
     * Eliminación de un producto dado su 'id'.
     *
     * @param id    Id del producto.
     */
    public void deleteProductById(int id) {
        productRepository.deleteByProductId(id);
    }

    /**
     * Creación de un producto.
     *
     * @param productDTO Objeto con todos los datos del nuevo producto.
     *
     * @return  Producto creado.
     */
    public Product createProduct(ProductDTO productDTO) {
        Product product = new Product();

        if (productDTO != null) {
            product.setProductName(productDTO.getProductName());
            product.setProductCategory(productDTO.getProductCategory());
            product.setProductDescription(productDTO.getProductDescription());
            product.setProductStock(productDTO.getProductStock());
            product.setProductPrice(productDTO.getProductPrice());
            product.setProductPhotoUrl(productDTO.getProductPhotoUrl());
        }

        return productRepository.save(product);
    }

    /**
     * Modificación de los campos de un producto.
     *
     * @param id            Id del producto el cuál queremos modifiacar.
     * @param productDTO    Objeto que contiene los datos modificados.
     *
     * @return  Producto modificado.
     */
    public Product updateProduct(int id, ProductDTO productDTO) {
        Product product = productRepository.findByProductId(id);

        if (productDTO != null) {
            product.setProductName(productDTO.getProductName());
            product.setProductCategory(productDTO.getProductCategory());
            product.setProductDescription(productDTO.getProductDescription());
            product.setProductStock(productDTO.getProductStock());
            product.setProductPrice(productDTO.getProductPrice());
            product.setProductPhotoUrl(productDTO.getProductPhotoUrl());
        }

        return productRepository.save(product);
    }
}
