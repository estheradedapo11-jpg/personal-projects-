

/**
 * Esther Adedapo
 * NSID: fxy319
 * Student Number: 11366614
 * Instructor: Kemin Wang
 * Lecture Section: L01
 */


import java.util.ArrayList;

/**
 * The LooseMatch class implements a crafting algorithm where extra ingredients are ignored,
 * and it checks if the required ingredients are present to craft a potion.
 */
public class LooseMatch implements CraftingAlgorithm {
    private ArrayList<Ingredients> recipe;

    /**
     * Constructs a LooseMatch algorithm with the given recipe.
     *
     * @param recipe The list of ingredients required to craft the potion.
     */
    public LooseMatch(ArrayList<Ingredients> recipe) {
        this.recipe = recipe;
    }

    /**
     * Crafts a potion based on the loose matching algorithm, where extra ingredients are ignored,
     * but required ingredients must be present.
     *
     * @param ingredients The list of ingredients to use in crafting the potion.
     * @return The crafted potion or a failed potion if no match is found.
     */
    @Override
    public Potion craftPotion(ArrayList<Ingredients> ingredients) {
        // Ignore extra ingredients and check if required ones are present
        if (ingredients.containsAll(recipe)) {
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
