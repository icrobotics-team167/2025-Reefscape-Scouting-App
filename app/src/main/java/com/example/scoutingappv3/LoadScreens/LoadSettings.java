package com.example.scoutingappv3.LoadScreens;

import android.app.Activity;
import android.view.View;
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

                switch (UserName.toLowerCase()){
                    case "eldric":
                        Toast.makeText(Config.AppContext,Config.TheFunny[0],Toast.LENGTH_SHORT).show();
                        break;
                    case "tada":
                        Toast.makeText(Config.AppContext,Config.TheFunny[1],Toast.LENGTH_SHORT).show();
                        break;
                    case "jinann":
                        Toast.makeText(Config.AppContext,Config.TheFunny[2],Toast.LENGTH_SHORT).show();
                        break;
                    case "calder":
                        Toast.makeText(Config.AppContext,Config.TheFunny[3],Toast.LENGTH_SHORT).show();
                        break;
                    case "emma":
                        Toast.makeText(Config.AppContext,Config.TheFunny[4],Toast.LENGTH_SHORT).show();
                        break;
                    case "jaynou":
                        Toast.makeText(Config.AppContext,Config.TheFunny[5],Toast.LENGTH_SHORT).show();
                        break;
                    case "daniel":
                        Toast.makeText(Config.AppContext,Config.TheFunny[6],Toast.LENGTH_SHORT).show();
                        break;
                    case "kazu":
                        Toast.makeText(Config.AppContext,Config.TheFunny[7],Toast.LENGTH_SHORT).show();
                        break;
                    case "farhan":
                        Toast.makeText(Config.AppContext,Config.TheFunny[8],Toast.LENGTH_SHORT).show();
                        break;
                    case "jerry":
                        Toast.makeText(Config.AppContext,Config.TheFunny[9],Toast.LENGTH_SHORT).show();
                        break;
                    case "evan":
                        Toast.makeText(Config.AppContext,Config.TheFunny[10],Toast.LENGTH_SHORT).show();
                        break;
                    case "sara":
                        Toast.makeText(Config.AppContext,Config.TheFunny[11],Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(Config.AppContext,Config.UnknowUser,Toast.LENGTH_SHORT).show();
                }

                main.DataLoader.LoadDataScreen(appActivity,main);
            }
        });

    }
}
