
package com.cst3104.project.marvel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class ScoreboardViewModel extends ViewModel {

    private final ScoreRepository scoreRepository;

    // Constructor to initialize the repository
    public ScoreboardViewModel() {
        scoreRepository = new ScoreRepository(); // Assuming ScoreRepository manages Room interactions
    }

    // Expose the user scores as LiveData
    public LiveData<List<Score>> getUserScores() {
        return scoreRepository.getAllUserScores();  // Assuming getAllUserScores() returns LiveData<List<Score>>
    }
}
