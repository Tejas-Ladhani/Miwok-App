package com.example.android.miwok;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class familyActivity extends AppCompatActivity {
    private ArrayList<Word> members=new ArrayList<Word>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        members.add(new Word("father", "әpә",R.mipmap.family_father));
        members.add(new Word("Mother", "әṭa",R.mipmap.family_mother));
        members.add(new Word("Son", "angsi",R.mipmap.family_son));
        members.add(new Word("Daughter", "tune",R.mipmap.family_daughter));
        members.add(new Word("Older Brother", "taachi",R.mipmap.family_older_brother));
        members.add(new Word("Young Brother", "chalitti",R.mipmap.family_younger_brother));
        members.add(new Word("Older Sister", "teṭe",R.mipmap.family_older_sister));
        members.add(new Word("Younger Sister", "kolliti",R.mipmap.family_younger_sister));
        members.add(new Word("grandmother", "ama",R.mipmap.family_grandmother));
        members.add(new Word("grandfather", "paapa",R.mipmap.family_grandfather));

        WordAdapter adapter = new WordAdapter(this, members);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
