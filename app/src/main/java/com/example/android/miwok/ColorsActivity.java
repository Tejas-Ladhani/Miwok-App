package com.example.android.miwok;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
   private ArrayList<Word> colors=new ArrayList<Word>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        colors.add(new Word("red", "weṭeṭṭi",R.mipmap.color_red));
        colors.add(new Word("green" ,"chokokki",R.mipmap.color_green));
        colors.add(new Word("brown", "ṭakaakki",R.mipmap.color_brown));
        colors.add(new Word("gray" ,"ṭopoppi",R.mipmap.color_gray));
        colors.add(new Word("black" ,"kululli",R.mipmap.color_black));
        colors.add(new Word("white" ,"kelelli",R.mipmap.color_white));
        colors.add(new Word("dusty yellow" ,"ṭopiisә",R.mipmap.color_dusty_yellow));
        colors.add(new Word("mustard yellow","chiwiiṭә",R.mipmap.color_mustard_yellow));

        WordAdapter adapter = new WordAdapter(this, colors);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

    }
}