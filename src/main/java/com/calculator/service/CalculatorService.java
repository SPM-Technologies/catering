package com.calculator.service;

import com.calculator.model.CalculationHistory;
import com.calculator.repository.CalculationHistoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CalculatorService {

    private static final Logger log = LoggerFactory.getLogger(CalculatorService.class);
    private final CalculationHistoryRepository historyRepository;

    public CalculatorService(CalculationHistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public double calculate(double operand1, double operand2, String operator) {
        log.debug("Calculating: {} {} {}", operand1, operator, operand2);
        double result;

        switch (operator) {
            case "add":
                result = operand1 + operand2;
                break;
            case "subtract":
                result = operand1 - operand2;
                break;
            case "multiply":
                result = operand1 * operand2;
                break;
            case "divide":
                if (operand2 == 0) {
                    log.warn("Attempt to divide by zero: {} / {}", operand1, operand2);
                    throw new ArithmeticException("Cannot divide by zero");
                }
                result = operand1 / operand2;
                break;
            default:
                log.error("Invalid operator: {}", operator);
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }

        saveHistory(operand1, operand2, operator, result);
        log.debug("Calculation result: {}", result);
        return result;
    }

    @Transactional
    private void saveHistory(double operand1, double operand2, String operator, double result) {
        log.debug("Saving calculation history: {} {} {} = {}", operand1, operator, operand2, result);
        CalculationHistory history = new CalculationHistory();
        history.setOperand1(operand1);
        history.setOperand2(operand2);
        history.setOperator(operator);
        history.setResult(result);
        historyRepository.save(history);
    }

    public List<CalculationHistory> getRecentHistory() {
        log.debug("Fetching recent calculation history");
        return historyRepository.findTop10ByOrderByCalculatedAtDesc();
    }

    @Transactional
    public void clearHistory() {
        log.info("Clearing all calculation history");
        historyRepository.deleteAll();
    }
}
