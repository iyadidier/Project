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

    @Query("SELECT * FROM score_table ORDER BY score DESC LIMIT 1")
    LiveData<Score> getHighestScore();

    @Query("DELETE FROM score_table")
    void deleteAll();
}
