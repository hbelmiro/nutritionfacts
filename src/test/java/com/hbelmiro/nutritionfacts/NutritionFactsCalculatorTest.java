package com.hbelmiro.nutritionfacts;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class NutritionFactsCalculatorTest {

    @Inject
    NutritionFactsCalculator nutritionFactsCalculator;

    @Test
    void calculateNutritionFacts() {
        List<Ingredient> ingredients = List.of(
                new Ingredient("Tomato", BigDecimal.valueOf(3.9), BigDecimal.valueOf(0.9), BigDecimal.valueOf(0.2), BigDecimal.valueOf(0.03)),
                new Ingredient("Cucumber", BigDecimal.valueOf(3.6), BigDecimal.valueOf(0.7), BigDecimal.valueOf(0.1), BigDecimal.valueOf(0.02)),
                new Ingredient("Olive Oil", BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.valueOf(15), BigDecimal.valueOf(2.1))
        );
        NutritionFacts nutritionFacts = nutritionFactsCalculator.calculateNutritionFacts(ingredients);

        assertThat(nutritionFacts).isEqualTo(
                NutritionFacts.of(BigDecimal.valueOf(13.2), BigDecimal.valueOf(2.85), BigDecimal.valueOf(15.55), BigDecimal.valueOf(2.19))
        );
    }
}