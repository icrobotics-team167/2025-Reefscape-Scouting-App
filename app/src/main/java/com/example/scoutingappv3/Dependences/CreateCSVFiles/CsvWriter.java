package com.example.scoutingappv3.Dependences.CreateCSVFiles;

import android.content.Context;

import com.example.scoutingappv3.Dependences.Config;
import com.example.scoutingappv3.Dependences.FileManagment.JavaFilesWriter;

public class CsvWriter {

    JavaFilesWriter CsvWriter;
    public CsvWriter(Context context){
        CsvWriter = new JavaFilesWriter(context, Config.CsvFolder);
    }

    public void AppendData(String file, String data){
        CsvWriter.AppedToFile(file,data);
    }

    public void AppendDataLn(String file, String data){
        CsvWriter.AppedToFileLine(file,data);
    }

}
