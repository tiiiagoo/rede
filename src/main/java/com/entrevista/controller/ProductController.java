package com.entrevista.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entrevista.model.Product;
import com.entrevista.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping(value = "/list")
    public List<Product> getClientList() {
       return productService.getAllProducts();
    }
}
