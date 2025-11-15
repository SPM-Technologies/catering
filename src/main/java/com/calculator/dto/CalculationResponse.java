package com.calculator.dto;

/**
 * Data Transfer Object for calculation responses.
 * Used for API responses.
 */
public class CalculationResponse {

    private Double result;
    private String message;
    private boolean success;

    public CalculationResponse() {
    }

    public CalculationResponse(Double result, String message, boolean success) {
        this.result = result;
        this.message = message;
        this.success = success;
    }

    public static CalculationResponse success(Double result) {
        return new CalculationResponse(result, "Calculation successful", true);
    }

    public static CalculationResponse error(String message) {
        return new CalculationResponse(null, message, false);
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
