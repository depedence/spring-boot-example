package com.example.controller.exeption;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
@ControllerAdvice
public class GlobalExceptionHandler implements ErrorController {

    @RequestMapping("/error")
    public String redirectToSpecificErrorPage(HttpServletResponse response) {
        int status = response.getStatus();

        switch (HttpStatus.valueOf(status)) {
            case FORBIDDEN:
                return "redirect:/error/403";
            case NOT_FOUND:
                return "redirect:/error/404";
            default:
                return "redirect:/error/500";
        }
    }

    @RequestMapping("/error/500")
    public String getCommonErrorPage() {
        return "public/error/common-error-page";
    }

    @RequestMapping("/error/403")
    public String getForbiddenErrorPage() {
        return "public/error/forbidden-error-page";
    }

    @RequestMapping("/error/404")
    public String getNotFoundErrorPage() {
        return "public/error/not-found-error-page";
    }

    @ExceptionHandler(Throwable.class)
    public String handleThrowable() {
        return "redirect:/error/500";
    }

}