package com.example.scoutingappv3;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.scoutingappv3.Dependences.Config;
import com.example.scoutingappv3.Dependences.FileManagment.JavaFilesReader;
import com.example.scoutingappv3.Dependences.FileManagment.JavaFilesWriter;
import com.example.scoutingappv3.Dependences.QrCodeManagment.CreateQrCodes;

public class Main extends AppCompatActivity{
    Button SubmitButtion;
    EditText Data;

    JavaFilesWriter DebugWriteing;
    JavaFilesReader DebugReading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp);
        SetUpTempScreen();

        DebugWriteing = new JavaFilesWriter(this,Config.CsvFolder);
        DebugReading = new JavaFilesReader(this,Config.CsvFolder);

        DebugWriteing.ClearFile(Config.CsvFile);

        Log.d("Clearing File", "File cleared");

//        DebugWriteing.WriteLn("Test1.txt","lolSigma",0);
//        Log.d("test", DebugReading.ReadData("Test1.txt",0));

        DebugWriteing.AppedToFile(Config.CsvFile,"Hello");
        Log.d("test", DebugReading.ReadLine(Config.CsvFile,0));

        DebugWriteing.AppedToFile(Config.CsvFile," World");
        Log.d("test", DebugReading.ReadLine(Config.CsvFile,0));
    }

    public void SetUpTempScreen(){
        Data = findViewById(R.id.Data);
        SubmitButtion = findViewById(R.id.Submit);

        SubmitButtion.setOnClickListener(v -> {
            Log.d("Buttion Clicked", "Data: " + Data.getText());
            CreateQrCodes.CreateCodes(this);
        });
    }
}
