package com.webshop.project;

import com.webshop.project.db.Category;
import com.webshop.project.db.Product;
import com.webshop.project.db.ProductImage;
import com.webshop.project.db.ProductToSubCategory;
import com.webshop.project.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by stanislav on 18.10.17.
 */
@Controller
@RequestMapping("/rest/products")
public class ProductRestController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductCatalogRepository productCatalogRepository;

    @Autowired
    ProductImageRepository imageRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping("/list")
    @ResponseBody
    public List<ProductToSubCategory> list(@RequestParam(value = "id") Long id, @RequestParam(value = "sort") String sortBy){
        List<ProductToSubCategory> products = productCatalogRepository.findBySubcategoryId(id);
        if(sortBy.equals("none")){
            return products;
        }else if(sortBy.equals("priceup")){
            Collections.sort(products,comparator('>'));
            return products;
        }else if (sortBy.equals("pricedown")){
            Collections.sort(products,comparator('<'));
            return products;
        }else return products;
    }



    @RequestMapping("/{id}")
    @ResponseBody
    public List<ProductImage> images(@PathVariable long id){
        return imageRepository.findProductImageByProductId(id);
    }

    @RequestMapping("/category")
    @ResponseBody
    public List<Category> categories(){
        List<Category> cat = categoryRepository.findAll();
        return cat;
    }

    private Comparator<ProductToSubCategory> comparator(final char sortBy){
        return new Comparator<ProductToSubCategory>() {
            public int compare(ProductToSubCategory o1, ProductToSubCategory o2) {
                if(o1.getProduct().getPrice() == o2.getProduct().getPrice())
                    return 0;
                else {
                    switch (sortBy){
                        case '>':{
                            if(o1.getProduct().getPrice() > o2.getProduct().getPrice())
                                return 1;
                            else return -1;}
                        case '<':{
                            if(o1.getProduct().getPrice() < o2.getProduct().getPrice())
                                return 1;
                            else return -1;}
                        }
                    }
                    return -1;
                }
            };
        }


}
