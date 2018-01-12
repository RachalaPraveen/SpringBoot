package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    private ProductService service;

    @Autowired
    public void setService(ProductService service) {
        this.service = service;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping("product/new")
    public String createNew(Model model){
        model.addAttribute("product", new Product());
        return "productform";
    }

//    @RequestMapping(value = "product", method = RequestMethod.POST)
//    public String save(Product product) {
//        service.save(product);
//        return "redirect:/product/" + product.getId();
//    }

//    @RequestMapping("product/edit/{id}")
//    public String edit(@PathVariable Integer id, Model model) {
//        model.addAttribute("product", service.getById(id));
//        return "productform";
//    }
//
//    @RequestMapping(value = "product/{id}")
//    public String showOne(@PathVariable Integer id, Model model) {
//        model.addAttribute("product", service.getById(id));
//        return "productshow";
//    }
//
//    @RequestMapping(value = "product/all")
//    public String showAll(Model model) {
//        model.addAttribute("products", service.getAll());
//        return "products";
//    }

    @RequestMapping("product/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/product/all";
    }
}
