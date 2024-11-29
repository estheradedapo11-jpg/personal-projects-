/**
 * Esther Adedapo
 * NSID: fxy319
 * Student Number: 11366614
 * Instructor: Kemin Wang
 * Lecture Section: L01
 */

import java.util.List;

public interface CraftingAlgorithm {
    /**
     * Craft a potion based on the provided list of ingredients.
     * @param providedIngredients the ingredients given by the user
     * @param requiredIngredients the ingredients required for the potion
     * @return the crafted Potion or null if crafting fails
     */
    Potion craftPotion(List<Ingredients> providedIngredients, List<Ingredients> requiredIngredients);
}
