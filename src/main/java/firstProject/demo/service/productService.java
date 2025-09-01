package firstProject.demo.service;

import firstProject.demo.model.productModel;
import firstProject.demo.repository.productRepo;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class productService {
    private final productRepo repository;

    public productService(productRepo repository) {
        this.repository = repository;
    }

    public List<productModel> findAll() {
        return new ArrayList<>(repository.findAll());
    }

    public productModel findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public productModel save(productModel user) {
        return repository.save(user);
    }

    public productModel update(Long id, productModel user) {
        return repository.findById(id)
                .map(existing -> {
                    // update only non-null fields
                    if (user.getName() != null) {
                        existing.setName(user.getName());
                    }
                    if (user.getEmail() != null) {
                        existing.setEmail(user.getEmail());
                    }
                    return repository.save(existing); // save updated existing, not user
                })
                .orElse(null);
    }

    public boolean delete(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}
