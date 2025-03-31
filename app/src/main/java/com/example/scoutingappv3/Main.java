package com.example.scoutingappv3;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.scoutingappv3.Dependences.FileManagment.JavaFilesReader;
import com.example.scoutingappv3.Dependences.FileManagment.JavaFilesWriter;

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

        DebugWriteing = new JavaFilesWriter(this,"DebugFiles");
        DebugReading = new JavaFilesReader(this,"DebugFiles");

        DebugWriteing.ClearFile("Test1.txt");

        Log.d("Clearing File", "File cleared");

//        DebugWriteing.WriteLn("Test1.txt","lolSigma",0);
//        Log.d("test", DebugReading.ReadData("Test1.txt",0));

        DebugWriteing.AppedToFile("Test1.txt","Hello");
        Log.d("test", DebugReading.ReadLine("Test1.txt",0));

        DebugWriteing.AppedToFile("Test1.txt"," World");
        Log.d("test", DebugReading.ReadLine("Test1.txt",0));
    }

    public void SetUpTempScreen(){
        Data = findViewById(R.id.Data);
        SubmitButtion = findViewById(R.id.Submit);

        SubmitButtion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Buttion Clicked", "Data: " + Data.getText());
            }
        });
    }
}
