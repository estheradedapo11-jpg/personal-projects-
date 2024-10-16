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
       if (achievement == null){
           throw new IllegalArgumentException("Achievement cannot be null");
       }
       int id= achievements.size();
       achievements.put(id, achievement);
    }

    /**
     * Gets an achievement corresponding to specified id
     * @param id the unique identifier for the achievement
     * @return the achievement corresponding to the provided id
     * @throws IllegalArgumentException if id does not exist in collection
     */
    public Achievement getAchievement(int id) throws IllegalArgumentException
    {
        if (!achievements.containsKey(id)) {
            throw new IllegalArgumentException("Achievement with id " + id + " does not exist");
        }
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
        StringBuilder result = new StringBuilder();
        for (Integer id : achievements.keySet()) {
            Achievement achievement = achievements.get(id);
           result.giappend(("ID")).append(id).append("-").append(achievement.toString()).append("\n");
        }

        return result.toString();
    }

    /**
     * Regression testing
     * @param args
     */
    public static void main(String[] args) {
    // Regression Tests for AchievementManager class


    // Create the AchievementManager
    AchievementManager manager = new AchievementManager();

    // Create test Achievements
    Achievement achievement1 = new Achievement("Master Coder", "Complete 100 coding challenges.");
    Achievement achievement2 = new Achievement("Bug Hunter", "Find and fix 50 bugs.");
    Achievement achievement3 = new Achievement("Marathon Coder", "Code for 24 hours straight.");

    // Test 1: addAchievement
    try {
        manager.addAchievement(achievement1);
        manager.addAchievement(achievement2);
        manager.addAchievement(achievement3);
    } catch (IllegalArgumentException e) {
        System.out.println("Test failed: addAchievement - " + e.getMessage());
    }

    // Test 2: getAchievement
    try {
        Achievement retrievedAchievement1 = manager.getAchievement(0);
        Achievement retrievedAchievement2 = manager.getAchievement(1);
        Achievement retrievedAchievement3 = manager.getAchievement(2);

        if (retrievedAchievement1.equals(achievement1) &&
            retrievedAchievement2.equals(achievement2) &&
            retrievedAchievement3.equals(achievement3)) {
        } else {
            System.out.println("Test failed: getAchievement");
        }
    } catch (IllegalArgumentException e) {
        System.out.println("Test failed: getAchievement - " + e.getMessage());
    }

    // Test 3: getLockedAchievements (assuming all achievements are locked initially)
    List<Achievement> lockedAchievements = manager.getLockedAchievements();
    if (lockedAchievements.size() == 3) {
    } else {
        System.out.println("Test failed: getLockedAchievements");
    }

    // Test 4: Unlock one achievement and test getUnlockedAchievements
    achievement1.unlockAchievement();  // Unlock the first achievement
    List<Achievement> unlockedAchievements = manager.getUnlockedAchievements();
    if (unlockedAchievements.size() == 1 && unlockedAchievements.contains(achievement1)) {
    } else {
        System.out.println("Test failed: getUnlockedAchievements");
    }

    // Test 5: getAllAchievements
    List<Achievement> allAchievements = manager.getAllAchievements();
    if (allAchievements.size() == 3 &&
        allAchievements.contains(achievement1) &&
        allAchievements.contains(achievement2) &&
        allAchievements.contains(achievement3)) {
    } else {
        System.out.println("Test failed: getAllAchievements");
    }

    // Test 6: getAllKeys
    List<Integer> keys = manager.getAllKeys();
    if (keys.size() == 3 && keys.contains(0) && keys.contains(1) && keys.contains(2)) {

    } else {
        System.out.println("Test failed: getAllKeys");
    }

    // Test 7: toString
    String managerString = manager.toString();
    if (managerString.contains("ID0") && managerString.contains("ID1") && managerString.contains("ID2")) {
    } else {
        System.out.println("Test failed: toString");
    }


}












}
