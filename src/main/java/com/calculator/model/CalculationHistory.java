package com.calculator.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "calculation_history",
       indexes = @Index(name = "idx_calculated_at", columnList = "calculated_at DESC"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double operand1;

    @Column(nullable = false)
    private Double operand2;

    @Column(nullable = false, length = 10)
    private String operator;

    @Column(nullable = false)
    private Double result;

    @Column(name = "calculated_at", nullable = false)
    private LocalDateTime calculatedAt;

    @PrePersist
    protected void onCreate() {
        calculatedAt = LocalDateTime.now();
    }
}
