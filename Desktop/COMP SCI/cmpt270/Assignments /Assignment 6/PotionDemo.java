/**
 * Esther Adedapo
 * NSID: fxy319
 * Student Number: 11366614
 * Instructor: Kemin Wang
 * Lecture Section: L01
 */
import java.util.ArrayList;

public class PotionDemo {

    /**
     * Main program to test your PotionFactory
     * Below is some provided starter code setting up the player and factory class.
     * <p>
     * You should add your own code demonstrating your Factory in action, highlighting the different types of potions
     * as well as the different algorithms your factory supports.
     * <p>
     * This is essentially a form of integration testing - testing that your Factory creates the correct potion, and
     * that the player is set up to be able to 'drink' the potion.
     * <p>
     * The markers will heavily rely on your tests here to verify that your Factory and Player are implemented correctly.
     *
     * @param args
     */
   public static void main(String[] args) {
        // Create player
        Player player = new Player();

        // Create list of ingredients
        ArrayList<Ingredients> ingredients = new ArrayList<>();
        ingredients.add(Ingredients.Grape);
        ingredients.add(Ingredients.Strawberry);

        // Set up the crafting algorithm
        ArrayList<Ingredients> recipe = new ArrayList<>();
        recipe.add(Ingredients.Grape);
        recipe.add(Ingredients.Strawberry);

        // Create AlchemyFactory and set the crafting algorithm (e.g., PerfectMatch)
        AlchemyFactory alchemyFactory = new AlchemyFactory();
        CraftingAlgorithm craftingAlgorithm = new PerfectMatch(recipe);
        alchemyFactory.setCraftingAlgorithm(craftingAlgorithm);

        // Craft potion
        Potion potion = alchemyFactory.craftPotion(ingredients);

        // Player drinks the potion
        potion.drink(player);  // Apply the potion's effect to the player
    }
}
