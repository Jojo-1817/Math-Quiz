package com.algonquin.capstone.model;

public class Reward {
    private int rewardId;
    private int scoreId;
    private String rewardName;

    public Reward() {}
    public Reward(int rewardId, int scoreId, String rewardName) {
        this.rewardId = rewardId; this.scoreId = scoreId; this.rewardName = rewardName;
    }
    public int    getRewardId()            { return rewardId; }
    public void   setRewardId(int id)      { this.rewardId = id; }
    public int    getScoreId()             { return scoreId; }
    public void   setScoreId(int id)       { this.scoreId = id; }
    public String getRewardName()          { return rewardName; }
    public void   setRewardName(String rn) { this.rewardName = rn; }
}