package com.calculator.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Global exception handler for the calculator application.
 * Provides centralized exception handling across all controllers.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Handles arithmetic exceptions (e.g., division by zero).
     */
    @ExceptionHandler(ArithmeticException.class)
    public String handleArithmeticException(ArithmeticException e, Model model, RedirectAttributes redirectAttributes) {
        log.error("Arithmetic error occurred: {}", e.getMessage());
        redirectAttributes.addFlashAttribute("error", e.getMessage());
        return "redirect:/";
    }

    /**
     * Handles illegal argument exceptions (e.g., invalid operator).
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(IllegalArgumentException e, Model model, RedirectAttributes redirectAttributes) {
        log.error("Invalid argument error: {}", e.getMessage());
        redirectAttributes.addFlashAttribute("error", e.getMessage());
        return "redirect:/";
    }

    /**
     * Handles all other unexpected exceptions.
     */
    @ExceptionHandler(Exception.class)
    public String handleGenericException(Exception e, Model model, RedirectAttributes redirectAttributes) {
        log.error("Unexpected error occurred", e);
        redirectAttributes.addFlashAttribute("error", "An unexpected error occurred. Please try again.");
        return "redirect:/";
    }
}
