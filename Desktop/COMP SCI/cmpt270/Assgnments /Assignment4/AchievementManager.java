/**
 * Esther Adedapo
 * NSID: fxy319
 * Student Number: 11366614
 * Instructor: Kemin Wang
 * Lecture Section: L01
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AchievementManager {

    /**
     * Map storing all achievements, keyed by unique IDs
     */
    private Map<Integer, Achievement> achievements;

    /**
     * Constructor, sets up achievements Map
     */
    public AchievementManager() {
        achievements = new HashMap<>();
    }

    /**
     * Adds a new achievement
     * @param achievement the achievment object to be added
     * @throws IllegalArgumentException if achievement is null
     */
    public void addAchievement(Achievement achievement) throws IllegalArgumentException {
       achievement = new Achievement(achievement.getAchievementName(), achievement.getAchievementDescription());
    }

    /**
     * Gets an achievement corresponding to specified id
     * @param id the unique identifier for the achievement
     * @return the achievement corresponding to the provided id
     * @throws IllegalArgumentException if id does not exist in collection
     */
    public Achievement getAchievement(int id) throws IllegalArgumentException
    {
	return achievements.get(id);
    }

    /**
     * Returns a List of all achievements that are currently locked
     * @return a List containing all currently locked achievements
     */
    public List<Achievement> getLockedAchievements()
    {
        List<Achievement> lockedAchievements = new ArrayList<>();

        for (Achievement achievement :achievements.values()){
            if ( !achievement.isUnlocked ()) {
                lockedAchievements.add(achievement);
            }
        }
        return lockedAchievements;

    }

    /**
     * Returns a list of all achievements that are currently unlocked
     * @return A List containing all currently unlocked achievements
     */
    public List<Achievement> getUnlockedAchievements()
    {
        List<Achievement> unlockedAchievements = new ArrayList<>();

        for (Achievement achievement :achievements.values()) {
            if ( achievement.isUnlocked() ) {
                unlockedAchievements.add(achievement);
            }
        }
        return unlockedAchievements;
    }

    /**
     * Returns a list of all Achievement objects currently stored in the map
     * @return a List of Achievements
     */
    public List<Achievement> getAllAchievements()
    {
        // Create a new ArrayList
        List<Achievement> a = new ArrayList<Achievement>();
        // Iterate through all achievements stored in the map
        for(Achievement achievement : achievements.values())
        {
            // Add each achievement to the end of the List
            a.add(achievement);
        }
        // Return the List containing all Achievements
        return a;
    }

    /**
     * Returns a list containing all integer keys
     * @return a List of Integers
     */
    public List<Integer> getAllKeys()
    {
        // Create a new Array List
        List<Integer> keys = new ArrayList<Integer>();
        // Iterate through all keys in the map
        for(int key: achievements.keySet())
        {
            // add each unique integer key to the list
            keys.add(key);
        }
        // return the final list of keys
        return keys;
    }


    /**
     * Returns a string representation of the AchievementManager object
     * Should display each achievement with its associated id
     * @return the string representation
     */
    public String toString() {
        String result = null;
        for (Integer id : achievements.keySet()) {
            Achievement achievement = achievements.get(id);
            result = "ID" + id + "-" + achievements.toString();
        }

        return result;
    }

    /**
     * Regression testing
     * @param args
     */
    public static void main(String[] args)
    {
        // todo: write regression test for all of the methods that YOU had to implement
        // there is no need to test the methods that were already implemented
    }
}
