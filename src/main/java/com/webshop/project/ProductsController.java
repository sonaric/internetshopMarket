package com.webshop.project;

import com.webshop.project.db.Category;
import com.webshop.project.db.Product;
import com.webshop.project.db.ProductToSubCategory;
import com.webshop.project.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public String productByCategory (@PathVariable(value = "id") Long id, Model uiModel) {
        uiModel.addAttribute("categories",categoryRepository.findAll());
        uiModel.addAttribute("id_category", id);
        System.out.println(id);
        return "products/list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String product(@PathVariable Long id, Model uiModel){
        Product product = productService.findProductById(id);
        if (product == null){
            throw new NotFoundException();
        }
        uiModel.addAttribute("product",product);
        uiModel.addAttribute("categories",categoryRepository.findAll());
        return "products/view";
    }
}
