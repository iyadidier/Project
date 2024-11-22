package com.cst3104.project.marvel;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
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

        // Set up RecyclerView
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Set up ViewModel
        ScoreboardViewModel scoreboardViewModel = new ViewModelProvider(this).get(ScoreboardViewModel.class);

        // Observer to update the RecyclerView when data changes
        scoreboardViewModel.getUserScores().observe(this, scores -> {
            // Initialize the adapter and set it to the RecyclerView
            if (adapter == null) {
                adapter = new ScoreboardAdapter(scores);
                recyclerView.setAdapter(adapter);
            } else {
                // Update the adapter with new data
                adapter.updateScores(scores);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.scoreboard_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.info_menu) {
            // Show info dialog
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
