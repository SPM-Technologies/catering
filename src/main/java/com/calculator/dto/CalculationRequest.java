package com.calculator.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * Data Transfer Object for calculation requests.
 * Contains validation rules for calculator inputs.
 */
public class CalculationRequest {

    @NotNull(message = "First operand is required")
    private Double operand1;

    @NotNull(message = "Second operand is required")
    private Double operand2;

    @NotNull(message = "Operator is required")
    @Pattern(regexp = "add|subtract|multiply|divide", 
             message = "Operator must be one of: add, subtract, multiply, divide")
    private String operator;

    public CalculationRequest() {
    }

    public CalculationRequest(Double operand1, Double operand2, String operator) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
    }

    public Double getOperand1() {
        return operand1;
    }

    public void setOperand1(Double operand1) {
        this.operand1 = operand1;
    }

    public Double getOperand2() {
        return operand2;
    }

    public void setOperand2(Double operand2) {
        this.operand2 = operand2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
