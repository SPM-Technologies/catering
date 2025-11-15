package com.calculator.controller;

import com.calculator.model.CalculationHistory;
import com.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for CalculatorController.
 */
@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;

    @Test
    void testHomePage() throws Exception {
        // Given
        List<CalculationHistory> history = new ArrayList<>();
        when(calculatorService.getRecentHistory()).thenReturn(history);

        // When & Then
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attributeExists("history"));

        verify(calculatorService, times(1)).getRecentHistory();
    }

    @Test
    void testCalculateAddition() throws Exception {
        // Given
        when(calculatorService.calculate(10.0, 5.0, "add")).thenReturn(15.0);
        when(calculatorService.getRecentHistory()).thenReturn(new ArrayList<>());

        // When & Then
        mockMvc.perform(post("/calculate")
                .param("operand1", "10")
                .param("operand2", "5")
                .param("operator", "add"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("result", 15.0))
                .andExpect(model().attribute("operand1", 10.0))
                .andExpect(model().attribute("operand2", 5.0))
                .andExpect(model().attribute("operator", "add"));

        verify(calculatorService, times(1)).calculate(10.0, 5.0, "add");
    }

    @Test
    void testCalculateDivisionByZero() throws Exception {
        // Given
        when(calculatorService.calculate(10.0, 0.0, "divide"))
                .thenThrow(new ArithmeticException("Cannot divide by zero"));
        when(calculatorService.getRecentHistory()).thenReturn(new ArrayList<>());

        // When & Then
        mockMvc.perform(post("/calculate")
                .param("operand1", "10")
                .param("operand2", "0")
                .param("operator", "divide"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attributeExists("error"));

        verify(calculatorService, times(1)).calculate(10.0, 0.0, "divide");
    }

    @Test
    void testCalculateInvalidOperator() throws Exception {
        // Given
        when(calculatorService.calculate(anyDouble(), anyDouble(), eq("invalid")))
                .thenThrow(new IllegalArgumentException("Invalid operator: invalid"));
        when(calculatorService.getRecentHistory()).thenReturn(new ArrayList<>());

        // When & Then
        mockMvc.perform(post("/calculate")
                .param("operand1", "10")
                .param("operand2", "5")
                .param("operator", "invalid"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attributeExists("error"));
    }

    @Test
    void testClearHistory() throws Exception {
        // When & Then
        mockMvc.perform(post("/clear-history"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));

        verify(calculatorService, times(1)).clearHistory();
    }

    @Test
    void testCalculateSubtraction() throws Exception {
        // Given
        when(calculatorService.calculate(10.0, 5.0, "subtract")).thenReturn(5.0);
        when(calculatorService.getRecentHistory()).thenReturn(new ArrayList<>());

        // When & Then
        mockMvc.perform(post("/calculate")
                .param("operand1", "10")
                .param("operand2", "5")
                .param("operator", "subtract"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("result", 5.0));
    }

    @Test
    void testCalculateMultiplication() throws Exception {
        // Given
        when(calculatorService.calculate(10.0, 5.0, "multiply")).thenReturn(50.0);
        when(calculatorService.getRecentHistory()).thenReturn(new ArrayList<>());

        // When & Then
        mockMvc.perform(post("/calculate")
                .param("operand1", "10")
                .param("operand2", "5")
                .param("operator", "multiply"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("result", 50.0));
    }

    @Test
    void testCalculateDivision() throws Exception {
        // Given
        when(calculatorService.calculate(10.0, 5.0, "divide")).thenReturn(2.0);
        when(calculatorService.getRecentHistory()).thenReturn(new ArrayList<>());

        // When & Then
        mockMvc.perform(post("/calculate")
                .param("operand1", "10")
                .param("operand2", "5")
                .param("operator", "divide"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("result", 2.0));
    }
}
