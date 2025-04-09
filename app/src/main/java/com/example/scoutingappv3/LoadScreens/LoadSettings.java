package com.example.scoutingappv3.LoadScreens;


import android.annotation.SuppressLint;
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
    int LocalBotTracked = 0;

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

        BotSpinner.setSelection(Config.BotTracked);

        BotSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                LocalBotTracked = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        SettingsSubmitButton.setOnClickListener(v -> {
            String UserName = SettingsNameEntryTextBox.getText().toString().toLowerCase();

            Config.UserName = UserName;
            Config.BotTracked = LocalBotTracked;

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
