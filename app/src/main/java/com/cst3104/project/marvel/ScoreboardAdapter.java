package com.cst3104.project.marvel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cst3104.project.R;

import java.util.List;

public class ScoreboardAdapter extends RecyclerView.Adapter<ScoreboardAdapter.ScoreboardViewHolder> {

    private List<Score> scores;

    // Constructor to initialize the scores list
    public ScoreboardAdapter(List<Score> scores) {
        this.scores = scores;
    }

    // Method to update scores (called by ViewModel when data changes)
    public void updateScores(List<Score> scores) {
        this.scores = scores;
        notifyDataSetChanged(); // Notify the adapter that data has changed
    }

    @NonNull
    @Override
    public ScoreboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for individual items
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_scoreboard, parent, false); // Ensure correct layout file
        return new ScoreboardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreboardViewHolder holder, int position) {
        // Bind the data to the views in the ViewHolder
        Score score = scores.get(position);
        holder.usernameText.setText(score.getUserName()); // Corrected to getUserName()
        holder.bestScoreText.setText(String.valueOf(score.getScore())); // Set the best score
    }

    @Override
    public int getItemCount() {
        return scores == null ? 0 : scores.size(); // Return the number of items
    }

    // ViewHolder class to hold references to the views in the item layout
    public static class ScoreboardViewHolder extends RecyclerView.ViewHolder {

        TextView usernameText;
        TextView bestScoreText;

        public ScoreboardViewHolder(View itemView) {
            super(itemView);
            // Bind the views from the layout
            usernameText = itemView.findViewById(R.id.usernameText);
            bestScoreText = itemView.findViewById(R.id.bestScoreText);
        }
    }
}
