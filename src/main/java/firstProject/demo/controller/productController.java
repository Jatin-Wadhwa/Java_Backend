package firstProject.demo.controller;

import firstProject.demo.DTO.productDto;
import firstProject.demo.model.productModel;
import firstProject.demo.service.productService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class productController{
    private final productService service;

    public productController(productService service){
        this.service=service;
    }
    @GetMapping
    public List<productModel> getAllProducts(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public productModel getProduct(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public productModel createProduct(@Valid @RequestBody productDto productDTO) {
        return service.create(productDTO);
    }

    @PutMapping("/{id}")
    public productModel updateProduct(@PathVariable Long id,@Valid @RequestBody productDto productDto){
        return service.update(id,productDto);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        return service.delete(id)? "product removed": "no product found of id";
    }




}