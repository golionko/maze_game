package com.game.maze.helper;

public class LevelUpHelper {
    private static final double BASE_XP = 500;
    private static final double EXPONENT = 1.04f;

    private static double calcXpForLevel(int level) {
        return BASE_XP + (BASE_XP * Math.pow(level, EXPONENT));
    }

    public static double calculateFullTargetXp(int level) {
        double requiredXP = 0;
        for (int i = 0; i <= level; i++) {
            requiredXP += calcXpForLevel(i);
        }
        return requiredXP;
    }

    public static long calculateLevel(long xp) {
        int level = 0;
        double maxXp = calcXpForLevel(0);
        do {
            maxXp += calcXpForLevel(++level);
        } while (maxXp < xp);
        return level;
    }

}
