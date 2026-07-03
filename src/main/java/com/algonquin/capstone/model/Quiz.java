package com.algonquin.capstone.model;

public class Quiz {
    private int quizId;
    private int userId;
    private String mathLevel;
    private String status;

    public Quiz() {}
    public Quiz(int quizId, int userId, String mathLevel, String status) {
        this.quizId = quizId; this.userId = userId;
        this.mathLevel = mathLevel; this.status = status;
    }
    public int    getQuizId()              { return quizId; }
    public void   setQuizId(int id)        { this.quizId = id; }
    public int    getUserId()              { return userId; }
    public void   setUserId(int id)        { this.userId = id; }
    public String getMathLevel()           { return mathLevel; }
    public void   setMathLevel(String ml)  { this.mathLevel = ml; }
    public String getStatus()              { return status; }
    public void   setStatus(String s)      { this.status = s; }
}