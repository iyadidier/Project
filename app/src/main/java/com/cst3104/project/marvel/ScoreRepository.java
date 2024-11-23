package com.cst3104.project.marvel;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ScoreRepository {

    private final ScoreDao scoreDao;
    private final LiveData<List<Score>> allScores;
    private final LiveData<Score> latestScore;
    private final LiveData<Score> lowestScore;
    private final LiveData<Score> highestScore;

    public ScoreRepository(Application application) {
        ScoreDatabase database = ScoreDatabase.getDatabase(application);
        scoreDao = database.scoreDao();
        allScores = scoreDao.getAllScores();
        latestScore = scoreDao.getLatestScore();
        lowestScore = scoreDao.getLowestScore();
        highestScore = scoreDao.getHighestScore();
    }

    public void insert(Score score) {
        ScoreDatabase.databaseWriteExecutor.execute(() -> {
            scoreDao.insert(score);
        });
    }

    public LiveData<List<Score>> getAllScores() {
        return allScores;
    }

    public LiveData<Score> getLatestScore() {
        return latestScore;
    }

    public LiveData<Score> getLowestScore() {
        return lowestScore;
    }

    public LiveData<Score> getHighestScore() {
        return highestScore;
    }

    public LiveData<List<Score>> getAllUserScores() {
        return null;
    }
}
