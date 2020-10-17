package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    WordAdapter(Activity context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @NonNull

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.textView);
        // Get the version name from the current word object and
        // set this text on the name TextView
        miwokTextView.setText(currentWord.getTranslateMiwok());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView engTextView = (TextView) listItemView.findViewById(R.id.textView2);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        engTextView.setText(currentWord.getEngTanslation());
        ImageView imgView =(ImageView)listItemView.findViewById(R.id.image);


        if(!currentWord.hasImage())
            imgView.setVisibility(View.GONE);
        else{
            imgView.setImageResource(currentWord.getResourceId());
        }
        /*
            // Find the ImageView in the list_item.xml layout with the ID list_item_icon
            ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
            // Get the image resource ID from the current AndroidFlavor object and
            // set the image to iconView
            iconView.setImageResource(currentAndroidFlavor.getImageResourceId());
        */

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}