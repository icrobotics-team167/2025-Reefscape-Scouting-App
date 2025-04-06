package com.example.scoutingappv3.LoadScreens;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.scoutingappv3.Dependences.Config;
import com.example.scoutingappv3.Dependences.MatchReader.MatchReader;
import com.example.scoutingappv3.Main;
import com.example.scoutingappv3.R;

public class LoadSettings {
    Button LoginButton;
    EditText UserNameEditText;
    EditText BotToTrackEditText;
    EditText MatchNumberEditText;

    @SuppressLint("SetTextI18n")
    public void LoadSettingsPage(Main main){
        main.setContentView(R.layout.settings);

        LoginButton = main.findViewById(R.id.Loginbutton);
        UserNameEditText = main.findViewById(R.id.UserName);
        BotToTrackEditText = main.findViewById(R.id.RobotToTrack);
        MatchNumberEditText = main.findViewById(R.id.MatchNumber);

        UserNameEditText.setText(Config.UserName);
        BotToTrackEditText.setText(MatchReader.getValueFromFile(Config.MatchNumber,Config.BotTracked) + "");
        if (Config.MatchNumber > 0) {
            MatchNumberEditText.setText(Config.MatchNumber + "");
        }

        LoginButton.setOnClickListener(v -> {
            String UserName = UserNameEditText.getText().toString();
            int MatchNumber = -1;
            int BotToTrack  = -1;

            try{
                MatchNumber = Integer.parseInt(MatchNumberEditText.getText().toString());
                BotToTrack = Integer.parseInt(BotToTrackEditText.getText().toString());

            } catch (NumberFormatException e) {
                Toast.makeText(Config.AppContext,"Hey Thats Not A Valid match / bot Number",Toast.LENGTH_LONG).show();
            }

            if(MatchNumber >= 0 && BotToTrack >= 1){
                Config.MatchNumber = MatchNumber;
                Config.UserName = UserName;
                Config.TeamNumber = BotToTrack;

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

                if (Config.UserName.equalsIgnoreCase("madison")){

                }else {
                    main.DataLoader.LoadDataScreen(main);
                }
            }
        });

    }
}
