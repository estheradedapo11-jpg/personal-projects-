

/**
 * Esther Adedapo
 * NSID: fxy319
 * Student Number: 11366614
 * Instructor: Kemin Wang
 * Lecture Section: L01
 */

import java.util.ArrayList;

/**

 *
 * The PerfectMatch class implements a crafting algorithm where the ingredients must match exactly,
 * including the order and quantity, to craft a potion.
 */
public class PerfectMatch implements CraftingAlgorithm {
    private ArrayList<Ingredients> recipe;

    /**
     * Constructs a PerfectMatch algorithm with the given recipe.
     *
     * @param recipe The list of ingredients required to craft the potion.
     */
    public PerfectMatch(ArrayList<Ingredients> recipe) {
        this.recipe = recipe;
    }

    /**
     * Crafts a potion based on the perfect matching algorithm, where the ingredients must match exactly,
     * including the order and quantity.
     *
     * @param ingredients The list of ingredients to use in crafting the potion.
     * @return The crafted potion or a failed potion if no match is found.
     */
    @Override
    public Potion craftPotion(ArrayList<Ingredients> ingredients) {
        // Check for perfect match: same ingredients in same order and quantity
        if (ingredients.size() == recipe.size() && ingredients.equals(recipe)) {
            // Return the specific potion based on the ingredients
            if (ingredients.get(0) == Ingredients.Lemon && ingredients.get(1) == Ingredients.Strawberry) {
                return new LemonBerry(120);  // Match for LemonBerryPotion
            } else if (ingredients.get(0) == Ingredients.Grape && ingredients.get(1) == Ingredients.Apple) {
                return new GrapeApple(150);  // Match for GrapeApplePotion
            } else if (ingredients.get(0) == Ingredients.Berry && ingredients.get(1) == Ingredients.Apple) {
                return new BerryApple(180);  // Match for BerryApplePotion
            }
        }
        return new FailedPotion(0); // Return FailedPotion if no match is found
    }
}
