package com.webshop.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by stanislav on 17.10.17.
 */
@Controller
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String mainPage(Model uiModel){
        uiModel.addAttribute("categories",categoryRepository.findAll());
        return "products/main";
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String productByCategory (@RequestParam(value = "id") Long id, Model uiModel) {
        uiModel.addAttribute("categories",categoryRepository.findAll());
        uiModel.addAttribute("id_category", id);
        System.out.println(id);
        return "products/list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String product(@PathVariable Long id, Model uiModel){
        uiModel.addAttribute("product",productService.findProductById(id));
        uiModel.addAttribute("categories",categoryRepository.findAll());
        return "products/view";
    }
}
