package com.example.cotcscouting;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;


//TODO: When making chages make sure to sinc or the changes to this file woint affect the programing


public class JavaData {

    //Note appends daat if given the name of a file.
    public static void writeFileOnInternalStorage(Context mcoContext, String sFileName, String sBody){
        File dir = new File(mcoContext.getFilesDir(), "mydir");
        if(!dir.exists()){
            dir.mkdir();
        }

        try {
            File gpxfile = new File(dir, sFileName);
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(sBody);
            writer.flush();
            writer.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }



    public static ArrayList<String> getAllFilesInDir(Context context) {
        // Create a File object pointing to the directory
        File dir = new File(context.getFilesDir(), "QRCodeImages"); //dir for qr codes

        // Create an ArrayList to hold the file names
        ArrayList<String> fileList = new ArrayList<>();

        // Check if the directory exists and is a directory
        if (dir.exists() && dir.isDirectory()) {
            // Get all files in the directory
            File[] files = dir.listFiles();
            assert files != null;
            for (File FileName: files) {
                Log.d("Found File", FileName.getName());
            }

            // If files are found, loop through them and add their names to the list
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        fileList.add(file.getName()); // Add only file names to the list
                    }
                }
            }
        }

        return fileList; // Return the list of file names
    }

    public static void removeAllFilesInDir(Context context) {

        Log.d("Starting Deletion Of All Files!","Make sure this is called after all data is collected");

        // Create a File object pointing to the directory
        File dir = new File(context.getFilesDir(), "QRCodeImages");

        // Create an ArrayList to hold the file names


        // Check if the directory exists and is a directory
        if (dir.exists() && dir.isDirectory()) {
            // Get all files in the directory
            File[] files = dir.listFiles();

            // If files are found, loop through them and add their names to the list
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        file.delete(); // Add only file names to the list
                    }
                }
            }
        }

        Log.d("Finsihed Deletion Of All Files!","Make sure this is called after all data is collected");
    }

}
