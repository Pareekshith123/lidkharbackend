package com.backend.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.backend.Dtos.ProductsDto;
import com.backend.exceptions.ProductNotFoundException;
import com.backend.exceptions.ResourceNotFoundException;
import com.backend.service.ProductsService;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductsService productService;


    @PostMapping("/create/{categoryId}")
    public ResponseEntity<ProductsDto> createProduct(@PathVariable Long categoryId, @RequestBody ProductsDto productsDto) {


        ProductsDto createdProduct = productService.createProduct(productsDto, categoryId);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping("/update/{categoryId}/{productId}")
    public ResponseEntity<ProductsDto> updateProduct(@PathVariable Long categoryId, @PathVariable Long productId, @RequestBody ProductsDto productsDto) {

        ProductsDto updatedProduct = productService.updateProduct(categoryId, productId, productsDto);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @GetMapping("/getById/{productId}")
    public ResponseEntity<ProductsDto> getProductById(@PathVariable("productId") Long productId) {
        ProductsDto product = productService.getProductById(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<ProductsDto>> getAllProducts() {


        List<ProductsDto> productList = productService.getAllProducts() ;
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {



        String result = productService.deleteProduct(productId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<List<ProductsDto>> searchProductByName(@PathVariable String name) {
        try {
            List<ProductsDto> productDto = productService.searchByProductName(name);
            return new ResponseEntity<>(productDto, HttpStatus.OK);
        } catch (ProductNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}





