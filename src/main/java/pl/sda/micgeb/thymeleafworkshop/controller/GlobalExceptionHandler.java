package pl.sda.micgeb.thymeleafworkshop.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView handleIllegalArgException(IllegalArgumentException ex) {
        ModelAndView mav = new ModelAndView();
        ex.printStackTrace();
        mav.addObject("errorMessage", ex.getMessage());
        mav.setViewName("wrongData");
        return mav;
    }
}
