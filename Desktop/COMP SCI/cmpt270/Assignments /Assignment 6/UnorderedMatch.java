

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
 * The UnorderedMatch class implements a crafting algorithm where the order of the ingredients does not matter,
 * but the ingredients must match the required recipe exactly in terms of quantity and type.
 */
public class UnorderedMatch implements CraftingAlgorithm {
    private ArrayList<Ingredients> recipe;

    /**
     * Constructs an UnorderedMatch algorithm with the given recipe.
     *
     * @param recipe The list of ingredients required to craft the potion.
     */
    public UnorderedMatch(ArrayList<Ingredients> recipe) {
        this.recipe = recipe;
    }

    /**
     * Crafts a potion based on the unordered matching algorithm, where the ingredients must match the required recipe,
     * but the order does not matter.
     *
     * @param ingredients The list of ingredients to use in crafting the potion.
     * @return The crafted potion or a failed potion if no match is found.
     */
    @Override
    public Potion craftPotion(ArrayList<Ingredients> ingredients) {
        // Check if the ingredients contain all the recipe ingredients (size must match, no extras)
        if (ingredients.size() == recipe.size() && ingredients.containsAll(recipe)) {
            // Return the specific potion based on the ingredients
            if (ingredients.contains(Ingredients.Lemon) && ingredients.contains(Ingredients.Strawberry)) {
                return new LemonBerry(120);  // Match for LemonBerryPotion
            } else if (ingredients.contains(Ingredients.Grape) && ingredients.contains(Ingredients.Apple)) {
                return new GrapeApple(150);  // Match for GrapeApplePotion
            } else if (ingredients.contains(Ingredients.Berry) && ingredients.contains(Ingredients.Apple)) {
                return new BerryApple(180);  // Match for BerryApplePotion
            }
        }
        return new FailedPotion(0); // Return FailedPotion if no match is found
    }
}
