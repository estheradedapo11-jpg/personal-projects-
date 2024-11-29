/**
 * Esther Adedapo
 * NSID: fxy319
 * Student Number: 11366614
 * Instructor: Kemin Wang
 * Lecture Section: L01
 */
import java.util.ArrayList;

/**
 * The AlchemyFactory class manages the crafting of potions using different crafting algorithms.
 * It allows the dynamic setting of a crafting algorithm and uses it to craft a potion from a list of ingredients.
 */
public class AlchemyFactory {
    private CraftingAlgorithm craftingAlgorithm;

    /**
     * Sets the crafting algorithm dynamically.
     *
     * @param craftingAlgorithm The algorithm used to craft potions.
     */
    public void setCraftingAlgorithm(CraftingAlgorithm craftingAlgorithm) {
        this.craftingAlgorithm = craftingAlgorithm;
    }

    /**
     * Crafts a potion based on the current crafting algorithm.
     *
     * @param ingredients The list of ingredients to use in crafting the potion.
     * @return The crafted potion or a failed potion if no algorithm is set.
     */
    public Potion craftPotion(ArrayList<Ingredients> ingredients) {
        if (craftingAlgorithm != null) {
            return craftingAlgorithm.craftPotion(ingredients);
        }
        return new FailedPotion(0); // Return failed potion if no algorithm is set
    }
}
