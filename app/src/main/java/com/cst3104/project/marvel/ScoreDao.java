/**
 * Full Name: Didier Iyamuremye
 * Student ID: 041104829
 * Course: CST3104
 * Term: Fall 2024
 * Assignment: Team Project
 * Date: 21/11/24
 */
package com.cst3104.project.marvel;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ScoreDao {

    @Insert
    void insert(Score score); // Insert a new score into the database

    @Query("SELECT * FROM score_table ORDER BY date DESC")
    LiveData<List<Score>> getAllScores(); // Retrieve all scores, ordered by date in descending order

    @Query("DELETE FROM score_table")
    void deleteAll(); // Delete all scores from the database
}
