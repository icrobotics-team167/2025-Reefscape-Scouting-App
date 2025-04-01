package com.example.scoutingappv3.Dependences;

import android.content.Context;

public class Config {

    public static String CsvFolder = "Csv_Files";
    public static String CsvFile = "Csv_File.txt";
    public static String QrCodesFolder = "QrCodes";

    public static Context AppContext;

    public static void setAppContext(Context appContext) {
        AppContext = appContext;
    }
}
