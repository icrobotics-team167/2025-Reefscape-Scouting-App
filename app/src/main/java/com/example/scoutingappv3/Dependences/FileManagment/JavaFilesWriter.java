package com.example.scoutingappv3.Dependences.FileManagment;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class JavaFilesWriter {


    private File dir;

    private String FileName;

    public JavaFilesWriter(Context context, String folder,String FileName){
        dir = new File(context.getFilesDir(), folder);
        if(!dir.exists()){
            dir.mkdir();
        }

        dir = new File(dir,FileName);
    }
    //This does not appends a new line to the end of your message
    public void AppedToFile(String Message){

        try{
            FileWriter Writer = new FileWriter(dir,true);
            Writer.append(Message);
            Writer.flush();
            Writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    //This appends a new line to the end of your message
    public void AppedToFileLine(String Message){

        try {
            FileWriter Writer = new FileWriter(dir,true);
            Writer.append(Message).append("\n");
            Writer.flush();
            Writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void ClearFile(){
        try {
            FileWriter Writer = new FileWriter(dir);
            Writer.append("");
            Writer.flush();
            Writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void WriteLn(String message, int line){
        List<String> Data = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            try {
                Data = Files.readAllLines(dir.toPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if (line > Data.size()){
            Log.d("Index out of bounds", "Index out of bounds Message: " + message);
        }

        Data.set(line,message);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            try {
                Files.write(dir.toPath(),Data);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
