package com.cst3104.project.marvel;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import java.util.Date;

@Entity(tableName = "score_table")
@TypeConverters(Converters.class)  // Ensure the converter is applied to this entity
public class Score {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String username;
    private int score;

    private Date date;

    // Constructor
    public Score(String username, int score, Date date) {
        this.username = username;
        this.score = score;
        this.date = date;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
