/**
 * Full Name: Didier Iyamuremye
 * Student ID: 041104829
 * Course: CST3104
 * Term: Fall 2024
 * Assignment: Team Project
 * Date: 21/11/24*/
package com.cst3104.project.marvel;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import java.util.Date;

@Entity(tableName = "score_table")
@TypeConverters(Converters.class)  // Ensure the converter is applied to this entity
public class Score {

    @PrimaryKey(autoGenerate = true)
    private int id; // Unique identifier for each score entry

    private String username; // Username of the player
    private int score; // The score value
    private Date date; // Date when the score was recorded

    // Constructor
    public Score(String username, int score, Date date) {
        this.username = username;
        this.score = score;
        this.date = date;
    }

    // Getters and Setters
    public int getId() {
        return id; // Get the unique ID of the score
    }

    public void setId(int id) {
        this.id = id; // Set the unique ID of the score
    }

    public String getUsername() {
        return username; // Get the username
    }

    public void setUsername(String username) {
        this.username = username; // Set the username
    }

    public int getScore() {
        return score; // Get the score value
    }

    public void setScore(int score) {
        this.score = score; // Set the score value
    }

    public Date getDate() {
        return date; // Get the date of the score
    }

    public void setDate(Date date) {
        this.date = date; // Set the date of the score
    }
}
