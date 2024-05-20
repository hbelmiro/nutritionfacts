package com.hbelmiro.nutritionfacts;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/nutritionfacts")
class NutritionFactsResource {

    private final NutritionFactsCalculator nutritionFactsCalculator;

    @Inject
    NutritionFactsResource(NutritionFactsCalculator nutritionFactsCalculator) {
        this.nutritionFactsCalculator = nutritionFactsCalculator;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public NutritionFacts hello(List<Ingredient> ingredients) {
        return nutritionFactsCalculator.calculateNutritionFacts(ingredients);
    }
}
