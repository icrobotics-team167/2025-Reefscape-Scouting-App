package com.example.scoutingappv3.Dependences.FileManagment;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class JavaFilesReader {
    private final String Path;

    public JavaFilesReader(Context appContext, String folder) {

        Path = appContext.getFilesDir() + "/" + folder;
        Log.d("Path", "Data IS stored at: " + Path);
    }


    //TODO: Optmise as will be kindda slow
    public String ReadData(String file,int line){
        File ReadFile = new File(Path,file);
        Scanner FileReader;

        int NumberOfLines = GetSize(file);

        if (NumberOfLines < line){
            Log.d("Out Of Bounds", "that was to big max size: " + NumberOfLines + " Provied Size: " + line);
            return "";
        }

        try {
             FileReader = new Scanner(ReadFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        ArrayList<String> Data = new ArrayList<>();

        while (FileReader.hasNext()){
            Data.add(FileReader.next());
        }

        return Data.get(line);
    }

    public int GetSize(String file){
        File ReadFile = new File(Path,file);
        Scanner FileReader;

        try {
            FileReader = new Scanner(ReadFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int Lines = 0;

        while (FileReader.hasNextLine()){
            FileReader.nextLine();
            Lines++;
        }

        return Lines;
    }
}
