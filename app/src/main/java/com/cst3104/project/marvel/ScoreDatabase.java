/**
 * Full Name: Didier Iyamuremye
 * Student ID: 041104829
 * Course: CST3104
 * Term: Fall 2024
 * Assignment: Team Project
 * Date: 21/11/24*/
package com.cst3104.project.marvel;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.Executor;

@Database(entities = {Score.class}, version = 1, exportSchema = false)
public abstract class ScoreDatabase extends RoomDatabase {

    public static Executor databaseWriteExecutor; // Executor for database operations
    private static ScoreDatabase INSTANCE; // Singleton instance of the database

    public abstract ScoreDao scoreDao(); // Access methods for the ScoreDao

    // Get the database instance (singleton pattern)
    public static synchronized ScoreDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ScoreDatabase.class, "score_database")
                    .fallbackToDestructiveMigration() // Handle database migration
                    .build();
        }
        return INSTANCE;
    }
}
