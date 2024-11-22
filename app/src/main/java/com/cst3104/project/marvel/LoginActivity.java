/** * Full Name: didier iyamuremye*
 * Student ID:041104829 *
 * Course: CST3104 *
 * Term: Fall 2024 *
 * Assignment: Team Project *
 * Date : 21/11/24*/

package com.cst3104.project.marvel;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.cst3104.project.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);  // Make sure this is the correct layout

        // Initialize the toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);  // Ensure the toolbar has this ID in the XML
        setSupportActionBar(toolbar);  // Set the toolbar as the action bar

        // Optional: Set a title on the toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Login");
        }
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
            showInfoDialog();  // Show info dialog when the menu item is clicked
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
