package com.cst3104.project.marvel;

import android.app.Application;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ScoreRepository {

    private ScoreDao scoreDao;
    private LiveData<List<Score>> allScores;

    public ScoreRepository(Application application) {
        ScoreDatabase database = ScoreDatabase.getDatabase(application);
        scoreDao = database.scoreDao();
        allScores = scoreDao.getAllScores();
    }

    public void insert(Score score) {
        ScoreDatabase.databaseWriteExecutor.execute(() -> {
            scoreDao.insert(score);
        });
    }

    public LiveData<List<Score>> getAllScores() {
        return allScores;
    }
}
