package com.example.scoutingappv3.Dependences;

import android.content.Context;

public class Config {
    public static String[] ParkingSpots = {"Did Not park","Parked in Middle","Shallow","Deep"};
    public static String ParkingPlace;
    public static String CsvFolder = "Csv_Files";
    public static String CsvFile = "Csv_File.txt";
    public static String QrCodesFolder = "QrCodes";
    public static String UserName = "";
    public static int MatchNumber = 1;
    //This tells witch bot to track as in col in  the matches
    public static int BotTracked = 0;
    //Team Number
    public static int TeamNumber = 0;
    public static String[] TheFunnyMessages = {"Hello Dungeon!","Doint Scout And drive Tada!!!","26 People?!?!?!?!!","man I lOvE StringInconsitent var_Names","Hello SAR-I mean EMMA!!!!!", "Luzz iuzz Jaynuzz", "80000 points is insane, don't do it again","Kazu How Could You Betray Tada  !!! " ,"Chicken Jockey, Farhan watch out!", "Hi Eldric! -Calder", "Are you playing Minecraft right now?...", "Hello EMMM-I mean SARA!!!!!","Thank You Elly For All Your Hard Work!!!!  :D","i hear You like sliders :D","Hello Mom-A-Tron"};
    public static String[] Names = {"Eldric","Tada","jinann","calder","emma","jaynou","daniel","kazu","farhan","jerry","evan","sara","elly","madison","momatron"};
    public static String UnknowUser = "Thank you for scouting! Give it a secend to load";
    public static int DriverScore = 0;
    public static Context AppContext;

    public static String EventCode = "2025chcmp";

    public static void setAppContext(Context appContext) {
        AppContext = appContext;
    }

}
