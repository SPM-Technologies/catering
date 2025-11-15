package com.calculator.service;

import com.calculator.model.CalculationHistory;
import com.calculator.repository.CalculationHistoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Unit tests for CalculatorService.
 */
@ExtendWith(MockitoExtension.class)
class CalculatorServiceTest {

    @Mock
    private CalculationHistoryRepository historyRepository;

    @InjectMocks
    private CalculatorService calculatorService;

    @Test
    void testAddition() {
        // When
        double result = calculatorService.calculate(10, 5, "add");

        // Then
        assertEquals(15.0, result, 0.001);
        verify(historyRepository, times(1)).save(any(CalculationHistory.class));
    }

    @Test
    void testSubtraction() {
        // When
        double result = calculatorService.calculate(10, 5, "subtract");

        // Then
        assertEquals(5.0, result, 0.001);
        verify(historyRepository, times(1)).save(any(CalculationHistory.class));
    }

    @Test
    void testMultiplication() {
        // When
        double result = calculatorService.calculate(10, 5, "multiply");

        // Then
        assertEquals(50.0, result, 0.001);
        verify(historyRepository, times(1)).save(any(CalculationHistory.class));
    }

    @Test
    void testDivision() {
        // When
        double result = calculatorService.calculate(10, 5, "divide");

        // Then
        assertEquals(2.0, result, 0.001);
        verify(historyRepository, times(1)).save(any(CalculationHistory.class));
    }

    @Test
    void testDivisionByZero() {
        // When & Then
        ArithmeticException exception = assertThrows(
            ArithmeticException.class,
            () -> calculatorService.calculate(10, 0, "divide")
        );
        
        assertEquals("Cannot divide by zero", exception.getMessage());
        verify(historyRepository, never()).save(any());
    }

    @Test
    void testInvalidOperator() {
        // When & Then
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> calculatorService.calculate(10, 5, "invalid")
        );
        
        assertTrue(exception.getMessage().contains("Invalid operator"));
        verify(historyRepository, never()).save(any());
    }

    @Test
    void testGetRecentHistory() {
        // Given
        CalculationHistory history1 = new CalculationHistory();
        CalculationHistory history2 = new CalculationHistory();
        List<CalculationHistory> mockHistory = Arrays.asList(history1, history2);
        when(historyRepository.findTop10ByOrderByCalculatedAtDesc()).thenReturn(mockHistory);

        // When
        List<CalculationHistory> result = calculatorService.getRecentHistory();

        // Then
        assertEquals(2, result.size());
        verify(historyRepository, times(1)).findTop10ByOrderByCalculatedAtDesc();
    }

    @Test
    void testClearHistory() {
        // When
        calculatorService.clearHistory();

        // Then
        verify(historyRepository, times(1)).deleteAll();
    }

    @Test
    void testNegativeNumbers() {
        // When
        double result = calculatorService.calculate(-10, -5, "add");

        // Then
        assertEquals(-15.0, result, 0.001);
    }

    @Test
    void testDecimalNumbers() {
        // When
        double result = calculatorService.calculate(10.5, 2.5, "multiply");

        // Then
        assertEquals(26.25, result, 0.001);
    }
}
