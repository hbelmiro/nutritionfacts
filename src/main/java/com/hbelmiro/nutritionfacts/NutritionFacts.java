package com.hbelmiro.nutritionfacts;

import java.math.BigDecimal;
import java.util.Objects;

public final class NutritionFacts {

    private final BigDecimal carbs;
    private final BigDecimal proteins;
    private final BigDecimal totalFats;
    private final BigDecimal saturatedFats;
    private final BigDecimal caloricValue;

    private NutritionFacts(BigDecimal carbs, BigDecimal proteins, BigDecimal totalFats, BigDecimal saturatedFats,
                           BigDecimal caloricValue) {
        this.carbs = carbs;
        this.proteins = proteins;
        this.totalFats = totalFats;
        this.saturatedFats = saturatedFats;
        this.caloricValue = caloricValue;
    }

    static NutritionFacts of(BigDecimal carbs, BigDecimal proteins, BigDecimal totalFats, BigDecimal saturatedFats) {
        BigDecimal caloricValue = carbs.multiply(BigDecimal.valueOf(4)).
                add(proteins.multiply(BigDecimal.valueOf(4)))
                .add(totalFats.multiply(BigDecimal.valueOf(9)));

        return new NutritionFacts(carbs, proteins, totalFats, saturatedFats, caloricValue);
    }

    public BigDecimal getCarbs() {
        return carbs;
    }

    public BigDecimal getProteins() {
        return proteins;
    }

    public BigDecimal getTotalFats() {
        return totalFats;
    }

    public BigDecimal getSaturatedFats() {
        return saturatedFats;
    }

    public BigDecimal getCaloricValue() {
        return caloricValue;
    }

    @Override
    public String toString() {
        return "NutritionFacts{" +
                "carbs=" + carbs +
                ", proteins=" + proteins +
                ", totalFats=" + totalFats +
                ", saturatedFats=" + saturatedFats +
                ", caloricValue=" + caloricValue +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NutritionFacts that = (NutritionFacts) o;
        return Objects.equals(carbs, that.carbs)
                && Objects.equals(proteins, that.proteins)
                && Objects.equals(totalFats, that.totalFats)
                && Objects.equals(saturatedFats, that.saturatedFats)
                && Objects.equals(caloricValue, that.caloricValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carbs, proteins, totalFats, saturatedFats, caloricValue);
    }
}
