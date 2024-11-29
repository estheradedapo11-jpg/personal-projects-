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
     *
     * You should add your own code demonstrating your Factory in action, highlighting the different types of potions
     * as well as the different algorithms your factory supports.
     *
     * This is essentially a form of integration testing - testing that your Factory creates the correct potion, and
     * that the player is set up to be able to 'drink' the potion.
     *
     * The markers will heavily rely on your tests here to verify that your Factory and Player are implemented correctly.
     *
     * @param args
     */



    public static void main(String[] args) {
        // Sample ingredient lists
        ArrayList<Ingredients> perfectIngredients = new ArrayList<>();
        perfectIngredients.add(Ingredients.Lemon);
        perfectIngredients.add(Ingredients.Strawberry);

        ArrayList<Ingredients> unorderedIngredients = new ArrayList<>();
        unorderedIngredients.add(Ingredients.Strawberry);
        unorderedIngredients.add(Ingredients.Lemon);

        ArrayList<Ingredients> looseIngredients = new ArrayList<>();
        looseIngredients.add(Ingredients.Strawberry);
        looseIngredients.add(Ingredients.Lemon);
        looseIngredients.add(Ingredients.Mint); // Extra ingredient that will be ignored in Loose Match

        // Set up the recipe (same for each algorithm)
        ArrayList<Ingredients> recipe = new ArrayList<>();
        recipe.add(Ingredients.Lemon);
        recipe.add(Ingredients.Strawberry);

        // Create an AlchemyFactory instance
        AlchemyFactory factory = new AlchemyFactory();

        // Test Perfect Match
        factory.setCraftingAlgorithm(new PerfectMatch(recipe));
        Potion craftedPotion = factory.craftPotion(perfectIngredients);
        System.out.println("Potion crafted (Perfect Match): " + (craftedPotion instanceof FailedPotion ? "Failed" : "Success"));

        // Test Unordered Match
        factory.setCraftingAlgorithm(new UnorderedMatch(recipe));
        craftedPotion = factory.craftPotion(unorderedIngredients);
        System.out.println("Potion crafted (Unordered Match): " + (craftedPotion instanceof FailedPotion ? "Failed" : "Success"));

        // Test Loose Match
        factory.setCraftingAlgorithm(new LooseMatch(recipe));
        craftedPotion = factory.craftPotion(looseIngredients);
        System.out.println("Potion crafted (Loose Match): " + (craftedPotion instanceof FailedPotion ? "Failed" : "Success"));
    }
}
