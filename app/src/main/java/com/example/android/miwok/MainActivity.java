package com.example.android.miwok;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView numbers = (TextView) findViewById(R.id.numbers);
        // Set a click listener on that View

        numbers.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(numbersIntent);
            }
        });

        TextView color=(TextView)findViewById(R.id.colors);
        color.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent colorsIntent =new Intent(MainActivity.this,ColorsActivity.class);
                startActivity(colorsIntent);
            }
        });

        TextView phrases=(TextView)findViewById(R.id.phrases);

        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phrasesIntent=new Intent(MainActivity.this,PhrasesActivity.class);
                startActivity(phrasesIntent);
            }
        });

        TextView Family=(TextView)findViewById(R.id.family);
        Family.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent familyIntent=new Intent(MainActivity.this,familyActivity.class);
                startActivity(familyIntent);
            }
            });
    }

//    public void ViewNumberList(View view){
//        //the first argument of the constructor is the current activity (will useful when we press back button on our phone) ANd the second arguement : is the activity , we want.
//        //intent will be stored in 'i'
//        //and then we will call Start activity by passing intent i.
//        Intent i=new Intent(this,NumbersActivity.class);
//        startActivity(i);
//    }



}