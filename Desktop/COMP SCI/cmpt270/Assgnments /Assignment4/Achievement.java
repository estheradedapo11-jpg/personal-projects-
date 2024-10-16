/**
 * Esther Adedapo
 * NSID: fxy319
 * Student Number: 11366614
 * Instructor: Kemin Wang
 * Lecture Section: L01
 */

public class Achievement {
    private String achievementName;
    private String achievementDescription;
    protected boolean isUnlocked;


    public Achievement(String achievementName, String achievementDescription) {
        this.achievementName = achievementName;
        this.achievementDescription = achievementDescription;

    }

    public String getAchievementName() {
        return achievementName;
    }

    public String getAchievementDescription() {
        return achievementDescription;
    }

    public boolean isUnlocked() {
        return isUnlocked;
    }


    public boolean checkUnlocked() {
        if (isUnlocked == true) {
            return true;
        } else {
            return false;
        }
    }

    public void unlockAchievement() {
        isUnlocked = true;
    }

    @Override
    public String toString() {
        return "Name:" + achievementName + "," + "Description:" + achievementDescription + "," +
                "Unlocekd" + isUnlocked;
    }

    public static void main(String[] args) {
        // Create an achievement
        Achievement achievement = new Achievement("Master Coder", "Complete 100 coding challenges.");

        // Test getAchievementName
        if (!achievement.getAchievementName().equals("Master Coder")) {
            System.out.println("Test failed: getAchievementName()");
        }

        // Test getAchievementDescription
        if (!achievement.getAchievementDescription().equals("Complete 100 coding challenges.")) {
            System.out.println("Test failed: getAchievementDescription()");
        }

        // Test checkUnlocked (should be false initially)
        if (achievement.checkUnlocked()) {
            System.out.println("Test failed: checkUnlocked() - expected false");
        }

        // Unlock the achievement
        achievement.unlockAchievement();

        // Test checkUnlocked (should be true after unlocking)
        if (!achievement.checkUnlocked()) {
            System.out.println("Test failed: checkUnlocked() - expected true after unlocking");
        }

        // Test toString()
        String expectedString = "Name: Master Coder, Description: Complete 100 coding challenges., Unlocked: true";
        if (!achievement.toString().equals(expectedString)) {
        }
    }

    }




