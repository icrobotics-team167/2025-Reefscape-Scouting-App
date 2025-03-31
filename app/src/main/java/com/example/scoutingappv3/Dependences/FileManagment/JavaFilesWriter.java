package com.example.scoutingappv3.Dependences.FileManagment;

import android.content.Context;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JavaFilesWriter {

    private final Context AppContext;

    private final String Folder;

    public JavaFilesWriter(Context context, String folder){
        AppContext = context;
        Folder = folder;
    }
    //This does not appends a new line to the end of your message
    public void AppedToFile(String FileName,String Message){
        File dir = new File(AppContext.getFilesDir(), Folder);

        if(!dir.exists()){
            dir.mkdir();
        }

        File LogFile = new File(dir,FileName);

        try{
            FileWriter Writer = new FileWriter(LogFile);
            Writer.append(Message);
            Writer.flush();
            Writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    //This appends a new line to the end of your message
    public void AppedToFileLine(String FileName,String Message){
        File dir = new File(AppContext.getFilesDir(), Folder);

        if(!dir.exists()){
            dir.mkdir();
        }

        File LogFile = new File(dir,FileName);

        try {
            FileWriter Writer = new FileWriter(LogFile,true);
            Writer.append(Message).append("\n");
            Writer.flush();
            Writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
