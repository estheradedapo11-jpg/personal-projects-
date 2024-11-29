/**
 * Esther Adedapo
 * NSID: fxy319
 * Student Number: 11366614
 * Instructor: Kemin Wang
 * Lecture Section: L01
 */
public abstract class Potion {

    /**
     * The number of gold pieces this potion is worth
     */
    private final int value;

    /**
     * The type of potion this is (specified in subclasses)
     */
    protected PotionNames potionName = null;

    /**
     * Constructor, take in value as parameter and save in instance variable
     * @param value the number of gold pieces this potion is worth
     */
    public Potion(int value) {
        this.value = value;
    }

    /**
     * Returns the name/type of this potion
     * @return the PotionName saved in this object
     */
    public PotionNames getPotionName() {
        return this.potionName;
    }

    /**
     * Makes the target drink this potion, and communicate the corresponding effect to the target
     * @param target the entity drinking this potion
     */
    public void drink(Player target)
    {
        // consume potion and apply effect to target
        // This method should be overridden in subclasses
    }
}
