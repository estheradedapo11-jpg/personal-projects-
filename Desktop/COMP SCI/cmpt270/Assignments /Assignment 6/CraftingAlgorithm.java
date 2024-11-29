

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
 * The CraftingAlgorithm interface defines the method for crafting a potion based on a list of ingredients.
 */
public interface CraftingAlgorithm {

    /**
     * Crafts a potion based on the provided ingredients.
     *
     * @param ingredients The list of ingredients used in crafting the potion.
     * @return The crafted potion or a failed potion if the recipe does not match.
     */
    Potion craftPotion(ArrayList<Ingredients> ingredients);
}
