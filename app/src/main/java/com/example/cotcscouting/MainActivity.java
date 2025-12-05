package com.example.cotcscouting;

//import static com.example.cotcscouting.R.color.medium_purple;

import android.annotation.SuppressLint;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



//import com.example.scoutingappv3.R;



public class MainActivity extends AppCompatActivity {

    static int Score = 0;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_screen);

        Button suptractButton = (Button) findViewById(R.id.minus);

        Button addButton = (Button) findViewById(R.id.plus);

        TextView scoreShower= (TextView) findViewById(R.id.textView);
        scoreShower.setText(Score + "");

        suptractButton.setOnClickListener(view -> {
            if (Score >= 0){
                Score--;
            }

            scoreShower.setText(Score + "");

        });

        addButton.setOnClickListener(view -> {
            Score++;

            scoreShower.setText(Score + "");

        });

    }


}
