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

        for (int i = 0; i < options.length; i++) {
            options[i] += ": " + MatchReader.getValueFromFile(Config.MatchNumber,i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                Config.AppContext,
                android.R.layout.simple_spinner_item,
                options
        ) ;


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ScoutingAssignMentSpinner.setAdapter(adapter);

        ScoutingAssignMentSpinner.setSelection(Config.BotTracked);

        ScoutingAssignMentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Config.BotTracked = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ScoutingAssignMentSpinner.setSelection(Config.BotTracked);
            }
        });


        //Tells what bot

        MatchNumberPlaceHolder.setText(Config.MatchNumber + "");

        SettingsButton.setOnClickListener(v ->{
            main.SettingsLoader.LoadSettingsPage(main);
        });

        GoButton.setOnClickListener(v -> {
            main.DataLoader.LoadDataScreen(main);
        });
    }
}
