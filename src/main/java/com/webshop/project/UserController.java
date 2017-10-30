package com.webshop.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registrationForn(Model uiModel, Principal principal){
        uiModel.addAttribute("categories",categoryRepository.findAll());
        return "registerForm";
    }

    @RequestMapping(value = "/validation", method = RequestMethod.GET)
    @ResponseBody
    public String checkExistUser(@RequestParam(value = "username") String user,
                                 @RequestParam(value = "email") String email){
        int existUser = 0;
        int existEmail = 0;
        if(userDetailRepository.findUserDetailByUsername(user) != null) existUser = 1;
        if(userDetailRepository.findUserDetailByEmail(email) !=null ) existEmail = 1;
        return "{\"username\": "+existUser+", \"email\": "+existEmail+"}";
    }
}
