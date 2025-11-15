package com.calculator.controller;

import com.calculator.model.CalculationHistory;
import com.calculator.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CalculatorController {

    private static final Logger log = LoggerFactory.getLogger(CalculatorController.class);
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/")
    public String home(Model model) {
        log.info("Loading calculator home page");
        addHistoryToModel(model);
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam("operand1") double operand1,
            @RequestParam("operand2") double operand2,
            @RequestParam("operator") String operator,
            Model model) {

        try {
            log.info("Calculating: {} {} {}", operand1, operator, operand2);
            double result = calculatorService.calculate(operand1, operand2, operator);
            model.addAttribute("result", result);
            model.addAttribute("operand1", operand1);
            model.addAttribute("operand2", operand2);
            model.addAttribute("operator", operator);
            log.info("Calculation successful: {} {} {} = {}", operand1, operator, operand2, result);
        } catch (ArithmeticException | IllegalArgumentException e) {
            log.error("Calculation error: {} for operand1={}, operand2={}, operator={}", 
                      e.getMessage(), operand1, operand2, operator);
            model.addAttribute("error", e.getMessage());
        }

        addHistoryToModel(model);
        return "calculator";
    }

    @PostMapping("/clear-history")
    public String clearHistory() {
        log.info("Clearing calculation history");
        calculatorService.clearHistory();
        return "redirect:/";
    }

    private void addHistoryToModel(Model model) {
        List<CalculationHistory> history = calculatorService.getRecentHistory();
        model.addAttribute("history", history);
    }
}
