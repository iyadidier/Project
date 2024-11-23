package com.cst3104.project.marvel;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "score_table")
public class Score {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int score;
    private String userName;
    private long date;  // Timestamp for when the score was recorded

    // Constructor, getters, and setters
    public Score(int score, String userName, long date) {
        this.score = score;
        this.userName = userName;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
