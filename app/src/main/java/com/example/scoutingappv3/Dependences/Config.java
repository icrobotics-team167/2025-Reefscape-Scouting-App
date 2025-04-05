package com.example.scoutingappv3.Dependences;

import android.content.Context;

public class Config {

    public static String CsvFolder = "Csv_Files";
    public static String CsvFile = "Csv_File.txt";
    public static String QrCodesFolder = "QrCodes";
    public static String UserName = "";
    public static int MatchNumber = 0;
    public static String BotTracked = "";

    public static String MatchesFile = "Matches";

    public static String[] TheFunnyMessages = {"Hello Creator!","Shouldn't You Be Driving?","10 People?!?!?!?!!","man I lOvE StringInconsitent var_Names","Hello SAR-I mean EMMA!!!!!", "Luzz iuzz Jaynuzz", "Why hello daniel >:)","Kazu How Could You Betray Tada  !!! " ,"Chicken Jockey, Farhan watch out!", "Hi Eldric! -Calder", "Are you playing Minecraft right now?...", "Hello EMMM-I mean SARA!!!!!","Thank You Elly For All Your Hard Work!!!!  :D"};
    public static String[] Names = {"Eldric","Tada","jinann","calder","emma","jaynou","daniel","kazu","farhan","jerry","evan","sara","elly"};
    public static String UnknowUser = "Thank you for scouting! Give it a secend to load";
    public static Context AppContext;

    public static String EventCode = "2025chcmp";

    public static void setAppContext(Context appContext) {
        AppContext = appContext;
    }

}
