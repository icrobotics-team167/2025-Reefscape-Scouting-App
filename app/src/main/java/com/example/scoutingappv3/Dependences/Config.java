package com.example.scoutingappv3.Dependences;

import android.app.Activity;
import android.content.Context;

public class Config {

    public static String CsvFolder = "Csv_Files";
    public static String CsvFile = "Csv_File.txt";
    public static String QrCodesFolder = "QrCodes";
    public static String UserName = "";
    public static int MatchNumber = 0;
    public static String BotTracked = "";

    public static String[] TheFunny = {"Hello Creator!","Shouldn't You Be Driving?","10 People?!?!?!?!!","man I lOvE StringInconsitent var_Names","Why all the jinann slander?", "Luzz iuzz Jaynuzz", "Why hello daniel >:)", "Chicken Jockey, Farhan watch out!", "Hi Eldric! -Calder", "Are you playing Minecraft right now?...", "EMMM-I mean SARA!!!!!"};
    public static String UnknowUser = "Thank you for scouting!";
    public static Context AppContext;

    public static void setAppContext(Context appContext) {
        AppContext = appContext;
    }

}
