package com.example.scoutingappv3;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Stack;

public class Main extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Very Importent DO NOT DELTE
        Config.setAppContext(this);

        LoadTesting.LoadTestMenu(this);

        CsvWriter test = new CsvWriter();
        test.ResetFile();
        test.AppendDataLn("Lol");
        test.AppendData("Lol 1");


    }


}
