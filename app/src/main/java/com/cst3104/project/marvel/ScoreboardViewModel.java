package com.cst3104.project.marvel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ScoreboardViewModel extends AndroidViewModel {

    private final ScoreRepository scoreRepository;

    // Constructor to initialize the repository
    public ScoreboardViewModel(Application application) {
        super(application); // Pass the application to the superclass
        scoreRepository = new ScoreRepository(application); // Initialize the repository
    }

    // Expose the user scores as LiveData
    public LiveData<List<Score>> getUserScores() {
        return scoreRepository.getAllUserScores();  // Fetch all user scores
    }

    // Method to get the highest score for each user
    public LiveData<List<Score>> getHighestScoresForUsers() {
        return scoreRepository.getHighestScoreForUser(); // Get highest score for each user
    }
}
