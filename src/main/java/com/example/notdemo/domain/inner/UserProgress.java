package com.example.notdemo.domain.inner;

import java.io.Serializable;
import java.util.List;

public class UserProgress implements Serializable {
    private int currentLevel;
    private int nextLevel;
    private int score;
    private int scoreLeft;
    private List<UnlockedAchievement> unlockedAchievements;

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getNextLevel() {
        return nextLevel;
    }

    public void setNextLevel(int nextLevel) {
        this.nextLevel = nextLevel;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScoreLeft() {
        return scoreLeft;
    }

    public void setScoreLeft(int scoreLeft) {
        this.scoreLeft = scoreLeft;
    }

    public List<UnlockedAchievement> getUnlockedAchievements() {
        return unlockedAchievements;
    }

    public void setUnlockedAchievements(List<UnlockedAchievement> unlockedAchievements) {
        this.unlockedAchievements = unlockedAchievements;
    }

    @Override
    public String toString() {
        return "UserProgress{" +
                "currentLevel=" + currentLevel +
                ", nextLevel=" + nextLevel +
                ", score=" + score +
                ", scoreLeft=" + scoreLeft +
                ", unlockedAchievements=" + unlockedAchievements +
                '}';
    }
}
