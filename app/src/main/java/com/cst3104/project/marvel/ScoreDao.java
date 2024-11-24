package com.cst3104.project.marvel;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ScoreDao {

    @Insert
    void insert(Score score);

    @Query("SELECT * FROM score_table ORDER BY date DESC")
    LiveData<List<Score>> getAllScores();

    @Query("SELECT * FROM score_table ORDER BY date DESC LIMIT 1")
    LiveData<Score> getLatestScore();

    @Query("SELECT * FROM score_table ORDER BY score ASC LIMIT 1")
    LiveData<Score> getLowestScore();

    // This query will return the highest score for each user
    @Query("SELECT * FROM score_table WHERE userName IN (SELECT userName FROM score_table GROUP BY userName ORDER BY MAX(score) DESC) ORDER BY score DESC")
    LiveData<List<Score>> getHighestScoreForUser();

    @Query("DELETE FROM score_table")
    void deleteAll();

    @Query("SELECT * FROM score_table ORDER BY score DESC LIMIT 1")
    LiveData<Score> getHighestScore();
}
