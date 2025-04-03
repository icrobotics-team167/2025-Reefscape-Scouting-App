package com.example.scoutingappv3;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.scoutingappv3.Dependences.Config;
import com.example.scoutingappv3.LoadScreens.DataEntryScreen;


public class Main extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Very Importent DO NOT DELTE
        Config.setAppContext(this);

        DataEntryScreen DataLoader = new DataEntryScreen();

        DataLoader.LoadDataScreen(this);

    }


}
