/**
 * Full Name: Didier Iyamuremye
 * Student ID: 041104829
 * Course: CST3104
 * Term: Fall 2024
 * Assignment: Team Project
 * Date: 21/11/24*/
package com.cst3104.project.marvel;

import android.app.Application;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ScoreRepository {

    private ScoreDao scoreDao;
    private LiveData<List<Score>> allScores;

    // Constructor: Initializes the DAO and retrieves all scores
    public ScoreRepository(Application application) {
        ScoreDatabase database = ScoreDatabase.getDatabase(application);
        scoreDao = database.scoreDao();
        allScores = scoreDao.getAllScores();
    }

    // Insert a score into the database
    public void insert(Score score) {
        ScoreDatabase.databaseWriteExecutor.execute(() -> {
            scoreDao.insert(score);
        });
    }

    // Get all scores as LiveData
    public LiveData<List<Score>> getAllScores() {
        return allScores;
    }
}
