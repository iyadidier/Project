package com.cst3104.project.marvel;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cst3104.project.R;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    // Array of character names
    private final String[] characterNames = {
            "Agent 13", "Agent Coulson", "Agent Maria Hill", "Ancient One", "Ant-Man", "Ayesha",
            "Black Panther", "Black Widow", "Captain America", "Captain Stacy", "Crossbones",
            "Doctor Octopus", "Doctor Strange", "Drax", "Falcon", "Gamora", "Green Goblin", "Groot",
            "Hawkeye", "Hulk", "Hyperion", "Iron Man", "Justin Hammer", "Karl Mordo"
    };

    // Array of character images (make sure these images exist in your drawable folder)
    private final int[] characterImages = {
            R.drawable.agent_13, R.drawable.agent_coulson, R.drawable.agent_maria_hill,
            R.drawable.ancient_one, R.drawable.ant_man, R.drawable.ayesha, R.drawable.black_panther,
            R.drawable.black_widow, R.drawable.captain_america, R.drawable.captain_stacy,
            R.drawable.crossbones, R.drawable.doctor_octopus, R.drawable.doctor_strange, R.drawable.drax,
            R.drawable.falcon, R.drawable.gamora, R.drawable.green_goblin, R.drawable.groot, R.drawable.hawkeye,
            R.drawable.hulk, R.drawable.hyperion, R.drawable.iron_man, R.drawable.justin_hammer, R.drawable.karl_mordo
    };

    // UI components
    private ImageView characterImage;
    private RecyclerView optionsRecyclerView;
    private CharacterAdapter characterAdapter;
    private TextView scoreTextView;
    private TextView characterNameDisplay;

    // Game state variables
    private int correctAnswerIndex;
    private int score = 0;
    private boolean isAnswerChosen = false;
    private String currentCharacterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Initialize Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialize UI components
        characterImage = findViewById(R.id.character_image);
        optionsRecyclerView = findViewById(R.id.guessing_options);
        scoreTextView = findViewById(R.id.score_text);
        characterNameDisplay = findViewById(R.id.character_name);

        // Set up RecyclerView
        optionsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Start the game
        loadNewCharacter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.game_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_reset) {
            resetGame();
            return true;
        } else if (item.getItemId() == R.id.menu_wikipedia) {
            openWikipediaPage();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadNewCharacter() {
        // Reset answer chosen flag and background color
        isAnswerChosen = false;
        optionsRecyclerView.setBackgroundColor(getResources().getColor(android.R.color.white));

        // Randomly select a character
        Random random = new Random();
        correctAnswerIndex = random.nextInt(characterNames.length);
        currentCharacterName = characterNames[correctAnswerIndex];

        // Shuffle the character names for guessing options
        List<String> namesList = Arrays.asList(characterNames);
        Collections.shuffle(namesList);

        // Get the correct position after shuffle
        final String correctName = characterNames[correctAnswerIndex];
        final int correctAnswerPosition = namesList.indexOf(correctName);

        // Set up the adapter with the shuffled list of names
        characterAdapter = new CharacterAdapter(namesList, (name, position) -> {
            if (!isAnswerChosen) {
                // Check the user's answer
                if (position == correctAnswerPosition) {
                    Toast.makeText(GameActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                    optionsRecyclerView.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                    characterNameDisplay.setText(currentCharacterName);
                    score++;
                } else {
                    Toast.makeText(GameActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                    optionsRecyclerView.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                }
                isAnswerChosen = true;
                updateScore();
            }
        });

        // Set the adapter for RecyclerView
        optionsRecyclerView.setAdapter(characterAdapter);

        // Update character image
        characterImage.setImageResource(characterImages[correctAnswerIndex]);
    }

    private void updateScore() {
        // Update the score TextView with the current score
        scoreTextView.setText("Score: " + score);
    }

    private void resetGame() {
        // Reset the game
        score = 0;
        updateScore();
        loadNewCharacter();
    }

    private void openWikipediaPage() {
        // Open the character's Wikipedia page
        if (currentCharacterName == null || currentCharacterName.isEmpty()) {
            Toast.makeText(this, "No character selected", Toast.LENGTH_SHORT).show();
            return;
        }

        String wikipediaUrl = "https://en.wikipedia.org/wiki/" + currentCharacterName.replace(" ", "_");
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(wikipediaUrl));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "No browser found", Toast.LENGTH_SHORT).show();
        }
    }
}
