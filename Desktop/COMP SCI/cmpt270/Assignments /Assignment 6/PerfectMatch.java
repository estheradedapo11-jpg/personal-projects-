/**
 * Esther Adedapo
 * NSID: fxy319
 * Student Number: 11366614
 * Instructor: Kemin Wang
 * Lecture Section: L01
 */

import java.util.List;

public class PerfectMatch implements CraftingAlgorithm {
    @Override
    public Potion craftPotion(List<Ingredients> providedIngredients, List<Ingredients> requiredIngredients) {
        if (providedIngredients.equals(requiredIngredients)) {
            // Match the recipe to a specific potion
            if (requiredIngredients.equals(List.of(Ingredients.Strawberry, Ingredients.Lemon))) {
                return new LemonBerry(200);
            } else if (requiredIngredients.equals(List.of(Ingredients.Strawberry, Ingredients.Pineapples))) {
                return new BerryApple(150);
            } else if (requiredIngredients.equals(List.of(Ingredients.Grapes, Ingredients.Pineapples))) {
                return new GrapeApple(120);
            }
        }
        return new FailedPotion(0);
    }
}

