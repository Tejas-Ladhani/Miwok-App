package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class ColorsFragment extends Fragment {
    private ArrayList<Word> colors = new ArrayList<Word>();
    private MediaPlayer colorAudio;

    ColorsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        colors.add(new Word("red", "weṭeṭṭi", R.mipmap.color_red, R.raw.color_red));
        colors.add(new Word("green", "chokokki", R.mipmap.color_green, R.raw.color_green));
        colors.add(new Word("brown", "ṭakaakki", R.mipmap.color_brown, R.raw.color_brown));
        colors.add(new Word("gray", "ṭopoppi", R.mipmap.color_gray, R.raw.color_gray));
        colors.add(new Word("black", "kululli", R.mipmap.color_black, R.raw.color_black));
        colors.add(new Word("white", "kelelli", R.mipmap.color_white, R.raw.color_white));
        colors.add(new Word("dusty yellow", "ṭopiisә", R.mipmap.color_dusty_yellow, R.raw.color_dusty_yellow));
        colors.add(new Word("mustard yellow", "chiwiiṭә", R.mipmap.color_mustard_yellow, R.raw.color_mustard_yellow));

        WordAdapter adapter = new WordAdapter(getActivity(), colors, R.color.category_colors);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                colorAudio = MediaPlayer.create(getActivity(), colors.get(position).getAudioRId());
                colorAudio.start();
                colorAudio.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer();
                    }
                });
            }
        });
        return rootView;
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (colorAudio != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            colorAudio.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            colorAudio = null;
        }
    }

    @Override
    public void onStop() {
        //need to release resources ,on stopping the activity

        super.onStop();
        releaseMediaPlayer();
    }
}
