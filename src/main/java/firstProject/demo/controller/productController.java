package firstProject.demo.controller;

import firstProject.demo.model.productModel;
import firstProject.demo.service.productService;
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
    public productModel createProduct(@RequestBody productModel product){
        return service.save(product);
    }

    @PutMapping("/{id}")
    public productModel updateProduct(@PathVariable Long id, @RequestBody productModel product){
        return service.update(id,product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        return service.delete(id)? "product removed": "no product found of id";
    }




}