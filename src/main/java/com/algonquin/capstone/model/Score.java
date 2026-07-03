package com.algonquin.capstone.model;

public class Score {
    private int scoreId;
    private int quizId;
    private int totalScore;

    public Score() {}
    public Score(int scoreId, int quizId, int totalScore) {
        this.scoreId = scoreId; this.quizId = quizId; this.totalScore = totalScore;
    }
    public int getScoreId()           { return scoreId; }
    public void setScoreId(int id)    { this.scoreId = id; }
    public int getQuizId()            { return quizId; }
    public void setQuizId(int id)     { this.quizId = id; }
    public int getTotalScore()        { return totalScore; }
    public void setTotalScore(int ts) { this.totalScore = ts; }
}