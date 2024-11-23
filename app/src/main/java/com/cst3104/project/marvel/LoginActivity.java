package com.cst3104.project.marvel;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.cst3104.project.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Make sure this is the correct layout file

        // Initialize the toolbar
        Toolbar toolbar = findViewById(R.id.toolbar); // Ensure the toolbar has this ID in the XML
        setSupportActionBar(toolbar);

        // Optional: Set a title on the toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Login");
        }

        // Find the login button (ensure it exists in your layout file)
        Button loginButton = findViewById(R.id.loginButton);

        // Set click listener for the login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Example: Perform login validation (dummy check here)
                boolean isAuthenticated = true; // Replace with actual authentication logic

                if (isAuthenticated) {
                    // Navigate to DashboardActivity
                    Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                    startActivity(intent);
                    finish(); // Optional: Close LoginActivity
                } else {
                    // Show error message
                    Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu
        getMenuInflater().inflate(R.menu.menu_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle menu item clicks
        if (item.getItemId() == R.id.action_info) {
            showInfoDialog(); // Show info dialog when the menu item is clicked
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showInfoDialog() {
        new AlertDialog.Builder(this)
                .setTitle("About the App")
                .setMessage("This is a collaborative project by\n\n- Didier\n- Ugo")
                .setPositiveButton("OK", null)
                .show();
    }
}
