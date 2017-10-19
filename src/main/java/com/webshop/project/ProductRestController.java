package com.webshop.project;

import com.webshop.project.db.Product;
import com.webshop.project.db.ProductImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    ProductImageRepository imageRepository;

    @RequestMapping("/list")
    @ResponseBody
    public List<Product> list(@RequestParam(value = "sort") String sortBy){
        List<Product> products = productRepository.findAll();
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

    private Comparator<Product> comparator(final char sortBy){
        return new Comparator<Product>() {
            public int compare(Product o1, Product o2) {
                if(o1.getPrice() == o2.getPrice())
                    return 0;
                else {
                    switch (sortBy){
                        case '>':{
                            if(o1.getPrice() > o2.getPrice())
                                return 1;
                            else return -1;}
                        case '<':{
                            if(o1.getPrice() < o2.getPrice())
                                return 1;
                            else return -1;}
                        }
                    }
                    return -1;
                }
            };
        }


}