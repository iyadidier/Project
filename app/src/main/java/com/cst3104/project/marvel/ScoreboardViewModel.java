package com.cst3104.project.marvel;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class ScoreboardViewModel extends ViewModel {

    private final ScoreRepository scoreRepository;

    // Constructor to initialize the repository
    public ScoreboardViewModel(Application application) {
        // Pass the application context to the repository
        scoreRepository = new ScoreRepository(application); // Now properly initialized
    }

    // Expose the user scores as LiveData
    public LiveData<List<Score>> getUserScores() {
        return scoreRepository.getAllUserScores();  // Assuming getAllUserScores() returns LiveData<List<Score>>
    }
}
