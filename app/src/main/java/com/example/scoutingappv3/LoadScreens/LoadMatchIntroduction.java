package com.example.scoutingappv3.LoadScreens;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.scoutingappv3.Dependences.Config;
import com.example.scoutingappv3.Dependences.MatchReader.MatchReader;
import com.example.scoutingappv3.Main;
import com.example.scoutingappv3.R;

public class LoadMatchIntroduction {

    Button SettingsButton;
    Button GoButton;
    TextView MatchNumberPlaceHolder;
    Spinner ScoutingAssignMentSpinner;

    public void LoadIntroduction(Main main){
        main.setContentView(R.layout.match_introduction_layout);

        SettingsButton = main.findViewById(R.id.SettingsButton);
        GoButton = main.findViewById(R.id.GoButton);

        MatchNumberPlaceHolder = main.findViewById(R.id.MatchNumberPlaceHolder);

        ScoutingAssignMentSpinner = main.findViewById(R.id.ScoutingAssignMentSpinner);

        //Spinner Code

        String[] options = main.getResources().getStringArray(R.array.tracking_options);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                main,
                R.array.tracking_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ScoutingAssignMentSpinner.setAdapter(adapter);

        ScoutingAssignMentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (options[position]){
                    case "Red 1":
                        Config.BotTracked = 0;
                        Log.d("Bot Chosen", "Red 1");
                        break;
                    case "Red 2":
                        Config.BotTracked = 1;
                        Log.d("Bot Chosen", "Red 2");
                        break;
                    case "Red 3":
                        Config.BotTracked = 2;
                        break;
                    case "Blue 1":
                        Config.BotTracked = 3;
                        break;
                    case "Blue 2":
                        Config.BotTracked = 4;
                        break;
                    case "Blue 3":
                        Config.BotTracked = 5;
                        Log.d("Bot Chosen", "Blue 3");
                        break;
                    default:
                        break;

                }

                MatchNumberPlaceHolder.setText(MatchReader.getValueFromFile(Config.MatchNumber,Config.BotTracked) + "");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //Tells what bot

        MatchNumberPlaceHolder.setText(MatchReader.getValueFromFile(Config.MatchNumber,Config.BotTracked) + "");

        SettingsButton.setOnClickListener(v ->{
            main.SettingsLoader.LoadSettingsPage(main);
        });

        GoButton.setOnClickListener(v -> {
            main.DataLoader.LoadDataScreen(main);
        });
    }
}
