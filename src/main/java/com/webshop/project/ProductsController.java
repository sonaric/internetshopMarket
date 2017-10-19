package com.webshop.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by stanislav on 17.10.17.
 */
@Controller
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model uiModel){
        //uiModel.addAttribute("products",productService.findAll());
        return "products/list";
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String product(@PathVariable Long id, Model uiModel){
        uiModel.addAttribute("product",productService.findProductById(id));
        return "products/view";
    }
}
