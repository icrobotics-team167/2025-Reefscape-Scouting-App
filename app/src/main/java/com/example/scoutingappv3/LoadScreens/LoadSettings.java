package com.example.scoutingappv3.LoadScreens;


import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.scoutingappv3.Dependences.Config;
import com.example.scoutingappv3.Main;
import com.example.scoutingappv3.R;

public class LoadSettings {
    Button SettingsSubmitButton;
    Button SettingsCancelButton;
    EditText SettingsNameEntryTextBox;
    Spinner BotSpinner;
    EditText SettingsMatchNumberOverrideTextBox;

    @SuppressLint("SetTextI18n")
    public void LoadSettingsPage(Main main) {
        main.setContentView(R.layout.settings);

        //Buttions
        SettingsSubmitButton = main.findViewById(R.id.SettingsSubmitButton);
        SettingsCancelButton = main.findViewById(R.id.SettingsCancelButton);

        //Text edit
        SettingsNameEntryTextBox = main.findViewById(R.id.SettingsNameEntryTextBox);
        SettingsMatchNumberOverrideTextBox = main.findViewById(R.id.MatchNumberTextEntry);

        //Spinner
        BotSpinner = main.findViewById(R.id.MatchSpinner);


        //Load Defaults
        SettingsNameEntryTextBox.setText(Config.UserName);
        SettingsMatchNumberOverrideTextBox.setText(Config.MatchNumber + "");

        //Spinner Code

        String[] options = main.getResources().getStringArray(R.array.tracking_options);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                main,
                R.array.tracking_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        BotSpinner.setAdapter(adapter);

        BotSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        SettingsSubmitButton.setOnClickListener(v -> {
            String UserName = SettingsNameEntryTextBox.getText().toString().toLowerCase();

            Config.UserName = UserName;

            try {
                Config.MatchNumber = Integer.parseInt(SettingsMatchNumberOverrideTextBox.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(main,"Unknow match Number",Toast.LENGTH_SHORT).show();
            }

            boolean FoundUser = false;

            for (int i = 0; i < Config.Names.length; i++) {
                if(Config.Names[i].toLowerCase().equals(UserName)){
                    Toast.makeText(Config.AppContext,Config.TheFunnyMessages[i],Toast.LENGTH_LONG).show();
                    FoundUser = true;
                    break;
                }


            }

            if (!FoundUser){
                Toast.makeText(Config.AppContext,Config.UnknowUser,Toast.LENGTH_LONG).show();
            }

            main.MatchIntroductionLoader.LoadIntroduction(main);

        });

        SettingsCancelButton.setOnClickListener(v -> {
            main.MatchIntroductionLoader.LoadIntroduction(main);
        });


    }
}
