/**
 * Full Name: Didier Iyamuremye
 * Student ID: 041104829
 * Course: CST3104
 * Term: Fall 2024
 * Assignment: Team Project
 * Date: 21/11/24
 */
package com.cst3104.project.marvel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

//  ViewModel class  responsible for managing UI-related data for Scores
public class ScoreViewModel extends AndroidViewModel {

    // Declaring a private field that handles Score data
    private ScoreRepository scoreRepository;

    // Declaring LiveData object that will hold a list of Score objects
    private LiveData<List<Score>> allScores;

    // Constructor for ScoreViewModel accepting Application context
    public ScoreViewModel(Application application) {
        super(application); // Calling the parent class constructor
        scoreRepository = new ScoreRepository(application); // Initializing the repository with the application context
        allScores = scoreRepository.getAllScores(); // Getting all scores from the repository
    }

    //  insert new Score object in repository
    public void insert(Score score) {
        scoreRepository.insert(score); // Calling insert method
    }

    // Method to get all the scores as LiveData
    public LiveData<List<Score>> getAllScores() {
        return allScores; // Returning all scores
    }
}
