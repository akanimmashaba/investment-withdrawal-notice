package com.enviro.assessment.grad001.akanimashaba.service;

import com.enviro.assessment.grad001.akanimashaba.model.Product;
import com.enviro.assessment.grad001.akanimashaba.repository.ProductRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long productId) throws ChangeSetPersister.NotFoundException {
        return productRepository.findById(productId)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public Product createProduct(Product product) {
        // Additional validation or business logic can be added here
        return productRepository.save(product);
    }

    public Product updateProduct(Long productId, Product updatedProduct) {
        // Additional validation or business logic can be added here
        return productRepository.findById(productId)
                .map(existingProduct -> {
                    existingProduct.setType(updatedProduct.getType());
                    existingProduct.setName(updatedProduct.getName());
                    existingProduct.setCurrentBalance(updatedProduct.getCurrentBalance());
                    return productRepository.save(existingProduct);
                })
                .orElse(null);
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }


}
