package com.cst3104.project.marvel;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.cst3104.project.R;

public class DashboardActivity extends AppCompatActivity {

    private TextView latestScore, lowestScore, highestScore;
    private Button playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Bind views
        latestScore = findViewById(R.id.latest_score);
        lowestScore = findViewById(R.id.lowest_score);
        highestScore = findViewById(R.id.highest_score);
        playButton = findViewById(R.id.play_button);

        // Toolbar setup
        setSupportActionBar(findViewById(R.id.toolbar));

        // Fetch and display scores using ViewModel
        ScoreViewModel scoreViewModel = new ViewModelProvider(this).get(ScoreViewModel.class);
        scoreViewModel.getLatestScore().observe(this, score ->
                latestScore.setText("Latest Score: " + score));
        scoreViewModel.getLowestScore().observe(this, score ->
                lowestScore.setText("Lowest Score: " + score));
        scoreViewModel.getHighestScore().observe(this, score ->
                highestScore.setText("Highest Score: " + score));

        // Play button functionality
        playButton.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, GameActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dashboard_menu, menu);
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
