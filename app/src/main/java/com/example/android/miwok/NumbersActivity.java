package com.example.android.miwok;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class NumbersActivity extends AppCompatActivity {

    //private String[] arr={"ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE","TEN"};

    //private ArrayList<String> EngWords=new ArrayList<>();
    private ArrayList<Word> words=new ArrayList<>();
    // Word is our object, which contains two string members.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

      /*  EngWords.add("ONE");
        EngWords.add("TWO");
        EngWords.add("THREE");
        EngWords.add("FOUR");
        EngWords.add("FIVE");
        EngWords.add("SIX");
        EngWords.add("SEVEN");
        EngWords.add("EIGHT");
        EngWords.add("NINE");
        EngWords.add("TEN");*/

        /*
           LinearLayout rootview = findViewById(R.id.Nroot_view);

            for (int i = 0; i < EngWords.size(); i++)
            {
                TextView textView=new TextView(this);
                textView.setText(EngWords.get(i));
                rootview.addView(textView);
            }
        */

        //    ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, EngWords);

        /*  Array Adapter with LISTVIEW

            ListView listView = (ListView) findViewById(R.id.list);
            listView.setAdapter(itemsAdapter);
        */

        /*  Array Adapter with GRIDVIEW

            GridView gridView=(GridView) findViewById(R.id.list);
            gridView.setAdapter(itemsAdapter);
        */
       //_____________________// ArrayAdapter<Word> itemsAdapter=new ArrayAdapter<Word>();
        words.add(new Word("one", "lutti",R.mipmap.number_one));
        words.add(new Word("two", "otiiko",R.mipmap.number_two));
        words.add(new Word("three", "tolookosu",R.mipmap.number_three));
        words.add(new Word("four", "oyyisa",R.mipmap.number_four));
        words.add(new Word("five", "massokka",R.mipmap.number_five));
        words.add(new Word("six", "temmokka",R.mipmap.number_six));
        words.add(new Word("seven", "kenekaku",R.mipmap.number_seven));
        words.add(new Word("eight", "kawinta",R.mipmap.number_eight));
        words.add(new Word("nine", "wo’e",R.mipmap.number_nine));
        words.add(new Word("ten", "na’aacha",R.mipmap.number_ten));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
    }

}

/*
    this is similar to normal ArrayAdapter + ListView
    here , we are have our own data structure "Word" ,which is having two String objects in it.
    Now, to Display that two text in ListView we need to make our own custom ArrayAdapter ,WordAdapter.(By overriding getView())
    than setting up that adapter with the ListView (Of numbers_activty).
    list_item willbe used by ListView .
*/

