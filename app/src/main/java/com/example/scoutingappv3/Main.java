package com.example.scoutingappv3;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.scoutingappv3.Dependences.Config;
import com.example.scoutingappv3.LoadScreens.DataEntryScreen;
import com.example.scoutingappv3.LoadScreens.LoadMatchIntroduction;
import com.example.scoutingappv3.LoadScreens.LoadSettings;


public class Main extends AppCompatActivity{

    public DataEntryScreen DataLoader;
    public LoadSettings SettingsLoader;
    public LoadMatchIntroduction MatchIntroductionLoader;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Very Importent DO NOT DELTE
        Config.setAppContext(this);

         DataLoader = new DataEntryScreen();
         SettingsLoader = new LoadSettings();
         MatchIntroductionLoader = new LoadMatchIntroduction();

        SettingsLoader.LoadSettingsPage(this);

    }


}
