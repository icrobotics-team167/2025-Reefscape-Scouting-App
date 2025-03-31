package com.example.scoutingappv3;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.scoutingappv3.Dependences.Config;
import com.example.scoutingappv3.Dependences.CreateCSVFiles.CsvReader;
import com.example.scoutingappv3.Dependences.CreateCSVFiles.CsvWriter;
import com.example.scoutingappv3.Dependences.FileManagment.JavaFilesReader;
import com.example.scoutingappv3.Dependences.FileManagment.JavaFilesWriter;
import com.example.scoutingappv3.Dependences.QrCodeManagment.CreateQrCodes;
import com.example.scoutingappv3.LoadScreens.LoadDataEntry;
import com.example.scoutingappv3.LoadScreens.LoadTesting;

public class Main extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Very Importent DO NOT DELTE
        Config.setAppContext(this);

        LoadTesting.LoadTestMenu(this);

    }
}
