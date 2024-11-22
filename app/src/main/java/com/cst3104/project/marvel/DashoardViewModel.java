package com.cst3104.project.marvel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends ViewModel {

    private final ScoreRepository scoreRepository;

    // Constructor to initialize the repository
    public DashboardViewModel() {
        scoreRepository = new ScoreRepository(); // ScoreRepository manages Room interactions
    }

    // Expose latest score as LiveData
    public LiveData<Score> getLatestScore() {
        return scoreRepository.getLatestScore();
    }

    // Expose lowest score as LiveData
    public LiveData<Score> getLowestScore() {
        return scoreRepository.getLowestScore();
    }

    // Expose highest score as LiveData
    public LiveData<Score> getHighestScore() {
        return scoreRepository.getHighestScore();
    }
}
