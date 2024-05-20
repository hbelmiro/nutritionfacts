package com.hbelmiro.nutritionfacts;

import java.math.BigDecimal;

public record Ingredient(String name, BigDecimal carbs, BigDecimal proteins, BigDecimal totalFats, BigDecimal saturatedFats) {
}
