package com.cst3104.project.marvel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ScoreViewModel extends AndroidViewModel {

    private ScoreRepository scoreRepository;

    private LiveData<List<Score>> allScores;

    public ScoreViewModel(Application application) {
        super(application);
        scoreRepository = new ScoreRepository(application);
        allScores = scoreRepository.getAllScores();
    }

    public void insert(Score score) {
        scoreRepository.insert(score);
    }

    public LiveData<List<Score>> getAllScores() {
        return allScores;
    }

    public LiveData<Score> getLatestScore() {
        return scoreRepository.getLatestScore();
    }

    public LiveData<Score> getLowestScore() {
        return scoreRepository.getLowestScore();
    }

    public LiveData<Score> getHighestScore() {
        return scoreRepository.getHighestScore();
    }
}
