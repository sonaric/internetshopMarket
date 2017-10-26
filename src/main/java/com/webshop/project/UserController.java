package com.webshop.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;


/**
 * Created by stanislav on 26.10.17.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    UserDetailRepository userDetailRepository;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String showProfile(Model uiModel, Principal principal){
        uiModel.addAttribute("categories",categoryRepository.findAll());
        uiModel.addAttribute("user_detail",userDetailRepository.findUserDetailByUsername(principal.getName()));
        return "profile";
    }
}
