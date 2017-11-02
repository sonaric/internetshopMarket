package com.webshop.project;

import com.webshop.project.db.User;
import com.webshop.project.db.UserDetail;
import com.webshop.project.db.UserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.relation.Role;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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

    @Autowired
    UserRepository userRepository;

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

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void processRegistration(UserDetail user,
                                      @RequestParam(value = "password") String password,
                                      Model uiModel,
                                      HttpServletRequest request,


                                      HttpServletResponse response) throws ServletException {
        UserRoles userRole = new UserRoles();
        userRole.setUsername(user.getUsername());
        userRole.setRole("ROLE_USER");
        List<UserRoles> roles = new ArrayList<UserRoles>();
        roles.add(userRole);
        User signUpUser = new User();
        signUpUser.setUsername(user.getUsername());
        signUpUser.setEnabled(true);
        signUpUser.setRoles(roles);
        signUpUser.setPassword(PasswordEncoder.encode(password));
        signUpUser.setUserDetail(user);
        userRepository.save(signUpUser);
        uiModel.addAttribute("categories",categoryRepository.findAll());
        request.login(user.getUsername(), password);
       // return "products/main";
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

    protected static class PasswordEncoder{
        public static String encode(String password){
            return new StandardPasswordEncoder("d15m12y1995").encode(password);
        }
    }
}
