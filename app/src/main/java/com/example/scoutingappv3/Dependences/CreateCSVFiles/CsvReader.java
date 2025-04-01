package com.example.scoutingappv3.Dependences.CreateCSVFiles;

import android.content.Context;

import com.example.scoutingappv3.Dependences.Config;
import com.example.scoutingappv3.Dependences.FileManagment.JavaFilesReader;

public class CsvReader {
    JavaFilesReader CsvReader;
    CsvReader(Context context){
        CsvReader = new JavaFilesReader(context, Config.CsvFolder,Config.CsvFile);
    }

    public String ReadLine(int line){
        return CsvReader.ReadLine(line);
    }

    public int GetNumOfLines(){
        return CsvReader.GetSize();
    }
}
