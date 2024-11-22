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

    @Query("DELETE FROM score_table")
    void deleteAll();
}
