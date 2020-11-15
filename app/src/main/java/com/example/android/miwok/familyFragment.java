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

public class familyFragment extends Fragment {
    private ArrayList<Word> members = new ArrayList<Word>();
    private MediaPlayer audio;

    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
        //made it global so that the resource allocation can be done efficiently.
    };

    familyFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        members.add(new Word("father", "әpә", R.mipmap.family_father, R.raw.family_father));
        members.add(new Word("Mother", "әṭa", R.mipmap.family_mother, R.raw.family_mother));
        members.add(new Word("Son", "angsi", R.mipmap.family_son, R.raw.family_son));
        members.add(new Word("Daughter", "tune", R.mipmap.family_daughter, R.raw.family_daughter));
        members.add(new Word("Older Brother", "taachi", R.mipmap.family_older_brother, R.raw.family_older_brother));
        members.add(new Word("Young Brother", "chalitti", R.mipmap.family_younger_brother, R.raw.family_younger_brother));
        members.add(new Word("Older Sister", "teṭe", R.mipmap.family_older_sister, R.raw.family_older_sister));
        members.add(new Word("Younger Sister", "kolliti", R.mipmap.family_younger_sister, R.raw.family_younger_sister));
        members.add(new Word("grandmother", "ama", R.mipmap.family_grandmother, R.raw.family_grandmother));
        members.add(new Word("grandfather", "paapa", R.mipmap.family_grandfather, R.raw.family_grandfather));

        WordAdapter adapter = new WordAdapter(getActivity(), members, R.color.category_family);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                audio = MediaPlayer.create(getActivity(), members.get(position).getAudioRId());
                audio.start();
                audio.setOnCompletionListener(onCompletionListener);
            }
        });
        return rootView;
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (audio != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            audio.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            audio = null;
        }
    }

    @Override
    public void onStop() {
        //need to release resources ,on stopping the activity
        super.onStop();
        releaseMediaPlayer();
    }


}
