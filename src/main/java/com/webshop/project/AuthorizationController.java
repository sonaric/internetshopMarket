package com.webshop.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by stanislav on 25.10.17.
 */
@Controller
@RequestMapping("/auth")
public class AuthorizationController {

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model uiModel){
        uiModel.addAttribute("categories",categoryRepository.findAll());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(){
        return "redirect:/products/";
    }
}
