package com.example.cotcscouting;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.EditText;

import com.example.cotcscouting.data.model.QRCodeUtils;

//TODO: When making chages make sure to sinc or the changes to this file woint affect the programing

public class CreateCSV {
    public void GenerateCs(Activity activity, Context context){
        //creates file needs to be save the data am lazy
        //TODO: add fix and make work

        EditText scoutNameEditText = activity.findViewById(R.id.scout_name);
        EditText match_number = activity.findViewById(R.id.match_number);
        EditText team_number = activity.findViewById(R.id.team_number);
        EditText Notes = activity.findViewById(R.id.notes);
        EditText total_points = activity.findViewById(R.id.total_points);
        //For the Message
        String FileName = scoutNameEditText.getText().toString() + "_" + match_number.getText().toString() + "_" + team_number.getText().toString();
        StringBuilder Header = new StringBuilder();
        StringBuilder vals = new StringBuilder();

        Header.append("Scout Name,");
        vals.append(scoutNameEditText.getText().toString());
        vals.append(",");

        Header.append("Match Number,");
        vals.append(match_number.getText().toString());
        vals.append(",");

        Header.append("Team Number,");
        vals.append(team_number.getText().toString());
        vals.append(",");

        Header.append("Total Points,");
        vals.append(total_points.getText().toString());
        vals.append(",");

        Header.append("Played Defense,");
        vals.append(MainActivity.PlayedDefense);
        vals.append(",");

        Header.append("Defense Score,");
        vals.append(MainActivity.DefenseScore);
        vals.append(",");

        Header.append("Auto L1 Points,");
        vals.append(MainActivity.AutoL1Points);
        vals.append(",");

        Header.append("Telop L1 Points,");
        vals.append(MainActivity.TelopL1Points);
        vals.append(",");

        Header.append("Auto Prosser Points,");
        vals.append(MainActivity.AutopProsserPoints);
        vals.append(",");

        Header.append("Telop Prosser Points,");
        vals.append(MainActivity.TelopProsserPoints);
        vals.append(",");

        Header.append("Auto Net Points,");
        vals.append(MainActivity.AutoNetPoints);
        vals.append(",");

        Header.append("Telop Net Points,");
        vals.append(MainActivity.TelopNetPoints);
        vals.append(",");

        Header.append("Passed Start,");
        vals.append(MainActivity.PassedGo);
        vals.append(",");

        Header.append("Whare They Parked,");
        vals.append(MainActivity.WhareParked);
        vals.append(",");




        int ScoredOnL2InTelop = 0;
        int ScoredOnL3InTelop = 0;
        int ScoredOnL4InTelop = 0;

        int ScoredOnL2InAuto = 0;
        int ScoredOnL3InAuto = 0;
        int ScoredOnL4InAuto = 0;


        //TODO: READD THE BARGE SCORES
        String[] Letters = {"A","B","C","D","E","F","G","H","I","J","K","L"};
        //Used to say what Branch your on
        int Counter = 0;
        int Level = 2;
        for (int i = 0; i < MainActivity.IsCheckedInTelop.length; i++) {
            if((i+1) % 4 == 0){
                Counter++;
            }
            if (Level > 4){
                Level  = 2;
            }
            Header.append("Telop " + Letters[Counter] + Level + ",");

            if (MainActivity.IsCheckedInTelop[i]){
                vals.append("1,");
                Log.d("TAG", "Found one that was checked: ");

                if (Level == 2){
                    ScoredOnL2InTelop++;
                }else if(Level == 3){
                    ScoredOnL3InTelop++;
                }else{
                    ScoredOnL4InTelop++;
                }
            }else{
                vals.append("0,");
                Log.d("Did not find it", "Found one that wasnt checked: ");
            }

            Level++;
        }

        Counter = 0;
        Level = 2;
        for (int i = 0; i < MainActivity.IsCheckedInAuto.length; i++) {
            if((i+1) % 4 == 0){
                Counter++;
            }
            if (Level > 4){
                Level  = 2;
            }
            Header.append("Auto " + Letters[Counter] + Level + ",");

            if (MainActivity.IsCheckedInAuto[i]){
                vals.append("1,");

                if (Level == 2){
                    ScoredOnL2InAuto++;
                }else if(Level == 3){
                    ScoredOnL3InAuto++;
                }else{
                    ScoredOnL4InAuto++;
                }

            }else{
                vals.append("0,");
            }

            Level++;
        }

        Header.append("Scored on l2 Telop,");
        vals.append(ScoredOnL2InTelop);
        vals.append(",");

        Header.append("Scored on l3 Telop,");
        vals.append(ScoredOnL3InTelop);
        vals.append(",");

        Header.append("Scored on l4 Telop,");
        vals.append(ScoredOnL4InTelop);
        vals.append(",");

        Header.append("Scored on l2 Auto,");
        vals.append(ScoredOnL2InAuto);
        vals.append(",");

        Header.append("Scored on l3 Auto,");
        vals.append(ScoredOnL3InAuto);
        vals.append(",");

        Header.append("Scored on l2 Auto,");
        vals.append(ScoredOnL4InAuto);
        vals.append(",");


        Header.append("Notes,");
        vals.append(Notes.getText().toString());

        Log.d("Header", Header.toString());


        QRCodeUtils.generateAndSaveQRCode(context,vals.toString(),FileName);
        QRCodeUtils.generateAndSaveQRCode(context,Header.toString(),FileName + "P2");
    }
}
