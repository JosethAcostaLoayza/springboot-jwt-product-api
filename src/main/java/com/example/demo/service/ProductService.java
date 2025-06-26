package com.example.demo.service;
import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDTO> getAll() {
        return productRepository.findAll().stream()
                .map(p -> new ProductDTO(p.getId(), p.getName(), p.getPrice()))
                .toList();
    }

    public ProductDTO getById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return new ProductDTO(product.getId(), product.getName(), product.getPrice());
    }

    public ProductDTO create(ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        Product saved = productRepository.save(product);
        return new ProductDTO(saved.getId(), saved.getName(), saved.getPrice());
    }

    public ProductDTO update(Long id, ProductDTO dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        Product updated = productRepository.save(product);
        return new ProductDTO(updated.getId(), updated.getName(), updated.getPrice());
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
