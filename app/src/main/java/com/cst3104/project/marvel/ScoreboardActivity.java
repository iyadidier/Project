package com.cst3104.project.marvel;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cst3104.project.R;

public class ScoreboardActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ScoreboardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        // Set up the Toolbar as the ActionBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); // Set the custom toolbar as the action bar

        // Set the title for the ActionBar
        getSupportActionBar().setTitle("Game Scoreboard");

        // Set up RecyclerView
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Set up ViewModel
        ScoreboardViewModel scoreboardViewModel = new ViewModelProvider(
                this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())
        ).get(ScoreboardViewModel.class);

        // Observe changes in the ViewModel's LiveData
        scoreboardViewModel.getUserScores().observe(this, scores -> {
            if (scores == null || scores.isEmpty()) {
                Log.d("ScoreboardActivity", "No scores available or LiveData is empty.");
            } else {
                Log.d("ScoreboardActivity", "Scores received: " + scores.size());
                if (adapter == null) {
                    adapter = new ScoreboardAdapter(scores);
                    recyclerView.setAdapter(adapter);
                } else {
                    adapter.updateScores(scores);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu layout to add items
        getMenuInflater().inflate(R.menu.scoreboard_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle menu item selection
        if (item.getItemId() == R.id.info_menu) {
            // Show the Info dialog with app details
            new AlertDialog.Builder(this)
                    .setTitle("About the App")
                    .setMessage("This app lets you guess Avenger characters. Created by Ugo and Didier.")
                    .setPositiveButton("OK", null)
                    .show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
