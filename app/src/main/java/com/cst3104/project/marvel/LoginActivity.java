/** Full Name: Didier Iyamuremye
 * Student ID: 041104829
 * Course: CST3104
 * Term: Fall 2024
 * Assignment: Team Project
 * Date: 21/11/24*/
package com.cst3104.project.marvel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.cst3104.project.R;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;  // Input field for username
    private static final String SHARED_PREFS_FILE = "UserPrefs";  // File to store user preferences
    private static final String KEY_LAST_USERNAME = "lastUsername";  // Key to store the last used username

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);  // Set the layout for this activity

        // Initialize the toolbar, which is used for the app's top navigation bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set the title of the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.avenger_guessing_game);
        }

        // Initialize the EditText where the user will input their username
        usernameEditText = findViewById(R.id.usernameEditText);

        // Load the last entered username from SharedPreferences (if it exists)
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_FILE, MODE_PRIVATE);
        String lastUsername = sharedPreferences.getString(KEY_LAST_USERNAME, "");
        if (!lastUsername.isEmpty()) {
            usernameEditText.setText(lastUsername); // Auto-fill the username field with the last used username
        }

        // Set an OnClickListener for the login button
        findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();  // Get the username entered by the user

                // Validate the username
                if (username.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Username cannot be empty", Toast.LENGTH_SHORT).show();  // Show toast if the username is empty
                } else if (username.length() < 3) {
                    Toast.makeText(LoginActivity.this, "Username must be at least 3 characters", Toast.LENGTH_SHORT).show();  // Show toast if the username is too short
                } else {
                    // Save the username to SharedPreferences for future use
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_LAST_USERNAME, username);
                    editor.apply();

                    // Create an intent to navigate to the next activity
                    Intent intent;
                    if (username.equalsIgnoreCase("admin")) {
                        intent = new Intent(LoginActivity.this, ScoreboardActivity.class);  // If the username is "admin", go to the scoreboard
                    } else {
                        intent = new Intent(LoginActivity.this, DashboardActivity.class);  // Otherwise, go to the dashboard
                    }

                    intent.putExtra("username", username);  // Pass the username to the next activity
                    startActivity(intent);  // Start the next activity
                    finish();  // Close LoginActivity
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu with the info option
        getMenuInflater().inflate(R.menu.menu_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle menu item clicks
        if (item.getItemId() == R.id.action_info) {
            // Show an info dialog when the "Info" menu item is clicked
            showInfoDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Method to display the info dialog with details about the app
    private void showInfoDialog() {
        new AlertDialog.Builder(this)
                .setTitle("About the App")
                .setMessage("This is a collaborative project by\n\n- Didier\n- Ugo")  // Information about the app and contributors
                .setPositiveButton("OK", null)  // Button to close the dialog
                .show();
    }
}
