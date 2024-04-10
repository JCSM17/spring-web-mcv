package com.jc.controller;

import com.jc.entity.Product;
import com.jc.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    // Post http://localhost:8080/products/new
    @PostMapping("/new")
    public String save(@ModelAttribute("product") Product product) {
        this.repository.save(product);
        return "redirect:/products";
    }

    /*
    Get http://localhost:8080/products/{id}/view

    Get http://localhost:8080/products/{id}/edit

    Get http://localhost:8080/products/{id}/delete

    Get http://localhost:8080/products/{id}/delete/all
    */
}
