/**
 * Esther Adedapo
 * NSID: fxy319
 * Student Number: 11366614
 * Instructor: Kemin Wang
 * Lecture Section: L01
 */


import java.util.HashMap;
import java.util.List;

public class UnorderedMatch implements CraftingAlgorithm {
    @Override
    public Potion craftPotion(List<Ingredients> providedIngredients, List<Ingredients> requiredIngredients) {
        if (providedIngredients.size() != requiredIngredients.size()) {
            return new FailedPotion(0);
        }

        HashMap<Ingredients, Integer> providedCounts = countIngredients(providedIngredients);
        HashMap<Ingredients, Integer> requiredCounts = countIngredients(requiredIngredients);

        if (providedCounts.equals(requiredCounts)) {
            // Match the recipe to a specific potion
            if (requiredIngredients.containsAll(List.of(Ingredients.Strawberry, Ingredients.Lemon))) {
                return new LemonBerry(200);
            } else if (requiredIngredients.containsAll(List.of(Ingredients.Strawberry, Ingredients.Pineapples))) {
                return new BerryApple(150);
            } else if (requiredIngredients.containsAll(List.of(Ingredients.Grapes, Ingredients.Pineapples))) {
                return new GrapeApple(120);
            }
        }
        return new FailedPotion(0);
    }

    private HashMap<Ingredients, Integer> countIngredients(List<Ingredients> ingredients) {
        HashMap<Ingredients, Integer> counts = new HashMap<>();
        for (Ingredients ingredient : ingredients) {
            counts.put(ingredient, counts.getOrDefault(ingredient, 0) + 1);
        }
        return counts;
    }
}
