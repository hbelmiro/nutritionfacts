package com.hbelmiro.nutritionfacts;

import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;
import java.util.List;

@ApplicationScoped
class NutritionFactsCalculator {

    NutritionFacts calculateNutritionFacts(List<Ingredient> ingredients) {
        BigDecimal carbs = BigDecimal.ZERO;
        BigDecimal proteins = BigDecimal.ZERO;
        BigDecimal totalFats = BigDecimal.ZERO;
        BigDecimal saturatedFats = BigDecimal.ZERO;

        for (Ingredient ingredient : ingredients) {
            carbs = carbs.add(ingredient.carbs());
            proteins = proteins.add(ingredient.proteins());
            totalFats = totalFats.add(ingredient.totalFats());
            saturatedFats = saturatedFats.add(carbs);
        }

        return NutritionFacts.of(carbs, proteins, totalFats, saturatedFats);
    }
}
