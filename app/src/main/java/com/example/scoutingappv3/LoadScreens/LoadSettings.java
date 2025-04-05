package com.example.scoutingappv3.LoadScreens;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.scoutingappv3.Dependences.Config;
import com.example.scoutingappv3.Main;
import com.example.scoutingappv3.R;

public class LoadSettings {
    Button LoginButton;
    EditText UserNameEditText;
    EditText BotToTrackEditText;
    EditText MatchNumberEditText;

    public void LoadSettingsPage(Activity appActivity,Main main){
        appActivity.setContentView(R.layout.settings);

        LoginButton = appActivity.findViewById(R.id.Loginbutton);
        UserNameEditText = appActivity.findViewById(R.id.UserName);
        BotToTrackEditText = appActivity.findViewById(R.id.RobotToTrack);
        MatchNumberEditText = appActivity.findViewById(R.id.MatchNumber);

        UserNameEditText.setText(Config.UserName + "");
        BotToTrackEditText.setText(Config.BotTracked + "");
        if (Config.MatchNumber > 0) {
            MatchNumberEditText.setText(Config.MatchNumber + "");
        }

        LoginButton.setOnClickListener(v -> {
            String UserName = UserNameEditText.getText().toString();
            String BotToTrack = BotToTrackEditText.getText().toString();
            int MatchNumber = -1;

            try{
                MatchNumber = Integer.parseInt(MatchNumberEditText.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(Config.AppContext,"Hey Thats Not A Valid Match Number",Toast.LENGTH_LONG).show();
            }

            if(MatchNumber >= 0){
                Config.MatchNumber = MatchNumber;
                Config.UserName = UserName;
                Config.BotTracked = BotToTrack;

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
                    main.DataLoader.LoadDataScreen(appActivity, main);
                }
            }
        });

    }
}
