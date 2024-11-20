package com.cst3104.project.marvel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.cardview.widget.CardView;
import com.cst3104.project.R;
import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {

    private List<String> characterNames;  // List to hold character names
    private OnOptionClickListener onOptionClickListener;  // Listener for item click events

    // Interface for item click handling
    public interface OnOptionClickListener {
        void onOptionClick(String name, int position);  // Called when an item is clicked
    }

    // Constructor for the adapter
    public CharacterAdapter(List<String> characterNames, OnOptionClickListener onOptionClickListener) {
        this.characterNames = characterNames;
        this.onOptionClickListener = onOptionClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the custom layout for each item in the RecyclerView
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.character_option_item, parent, false);
        return new ViewHolder(view);  // Return the ViewHolder
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Get the character name for the current position
        String characterName = characterNames.get(position);

        // Set the character name in the corresponding view
        holder.characterNameText.setText(characterName);

        // Set an onClickListener for the CardView to trigger the item click event
        holder.cardView.setOnClickListener(v -> {
            if (onOptionClickListener != null) {
                onOptionClickListener.onOptionClick(characterName, position);  // Notify the listener about the item click
            }
        });
    }

    @Override
    public int getItemCount() {
        return characterNames.size();  // Return the total number of items in the list
    }

    // ViewHolder class to hold references to the views for each item
    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;  // CardView container for the item
        TextView characterNameText;  // TextView for displaying the character's name

        // Constructor to initialize the views
        public ViewHolder(View itemView) {
            super(itemView);
            // Initialize the views from the item layout
            cardView = itemView.findViewById(R.id.character_card_view);
            characterNameText = itemView.findViewById(R.id.character_name_text);
        }
    }
}
