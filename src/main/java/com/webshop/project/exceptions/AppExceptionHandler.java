package com.webshop.project.exceptions;

import com.webshop.project.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by stanislav on 25.10.17.
 */
@ControllerAdvice
public class AppExceptionHandler {
    @Autowired
    private CategoryRepository categoryRepository;

    @ExceptionHandler(NotFoundException.class)
    public String notFoundHandler(Model uiModel){
        uiModel.addAttribute("categories", categoryRepository.findAll());
        return "errors/notFound";
    }
}
