package com.algonquin.capstone.model;

public class Question {
    private int questionId;
    private int quizId;
    private String questionText;
    private String correctAnswer;

    public Question() {}
    public Question(int questionId, int quizId, String questionText, String correctAnswer) {
        this.questionId = questionId; this.quizId = quizId;
        this.questionText = questionText; this.correctAnswer = correctAnswer;
    }
    public int    getQuestionId()               { return questionId; }
    public void   setQuestionId(int id)         { this.questionId = id; }
    public int    getQuizId()                   { return quizId; }
    public void   setQuizId(int id)             { this.quizId = id; }
    public String getQuestionText()             { return questionText; }
    public void   setQuestionText(String qt)    { this.questionText = qt; }
    public String getCorrectAnswer()            { return correctAnswer; }
    public void   setCorrectAnswer(String ca)   { this.correctAnswer = ca; }
}