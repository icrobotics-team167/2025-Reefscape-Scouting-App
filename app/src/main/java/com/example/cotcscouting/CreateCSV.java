package com.example.cotcscouting;

import android.app.Activity;
import android.content.Context;
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
        EditText Notes = activity.findViewById(R.id.notes);;

        //For the Message
        String FileName = scoutNameEditText.getText().toString() + "_" + match_number.getText().toString() + "_" + team_number.getText().toString();
        String Header = "ScoutName; Match Number; Team Number; Total Points; Telop Prosser Points; Auto Prosser Points; Telop net points; Auto net points; Telop L1 points; Auto L1 Points; past Starting Line; Notes; Total barge Points;";
        StringBuilder vals = new StringBuilder(scoutNameEditText.getText().toString() + "," + match_number.getText().toString() + "," + MainActivity.TelopProsserPoints + "," + MainActivity.AutopProsserPoints + "," + MainActivity.TelopNetPoints + "," + MainActivity.AutoNetPoints + "," + MainActivity.TelopL1Points + ",");

        for(Boolean WasCheckedInAuto: MainActivity.IsCheckedInAuto){
            if (WasCheckedInAuto){
                vals.append("1,");
            }else {
                vals.append("0,");
            }
        }

        for(Boolean WasCheckedIntelop: MainActivity.IsCheckedInTelop){
            if (WasCheckedIntelop){
                vals.append("1,");
            }else {
                vals.append("0,");
            }
        }


        vals.append(MainActivity.WhareParked).append(",");
        vals.append(Notes.getText());



        QRCodeUtils.generateAndSaveQRCode(context,vals.toString(),FileName);
        QRCodeUtils.generateAndSaveQRCode(context,Header,FileName + "P2");
    }
}
