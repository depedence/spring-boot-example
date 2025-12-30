package com.example.controller.exeption;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ControllerAdvice
public class GlobalExceptionHandler implements ErrorController {

    @RequestMapping("/error")
    public String getErrorPage() {
        return "public/error/error-page";
    }

    @ExceptionHandler(Throwable.class)
    public String handleThrowable() {
        return "redirect:/error";
    }

}