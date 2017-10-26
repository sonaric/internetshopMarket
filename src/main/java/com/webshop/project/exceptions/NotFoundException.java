package com.webshop.project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by stanislav on 25.10.17.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,
reason = "Category/Product Not Found")
public class NotFoundException extends RuntimeException{
}
