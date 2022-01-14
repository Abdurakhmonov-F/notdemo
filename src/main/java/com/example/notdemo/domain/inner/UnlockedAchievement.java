package com.example.notdemo.domain.inner;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.Instant;

public class UnlockedAchievement implements Serializable {
    private String achievementId;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private Instant unlockDate;

    public String getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(String achievementId) {
        this.achievementId = achievementId;
    }

    public Instant getUnlockDate() {
        return unlockDate;
    }

    public void setUnlockDate(Instant unlockDate) {
        this.unlockDate = unlockDate;
    }

    @Override
    public String toString() {
        return "UnlockedAchievement{" +
                "achievementId='" + achievementId + '\'' +
                ", unlockDate=" + unlockDate +
                '}';
    }
}
