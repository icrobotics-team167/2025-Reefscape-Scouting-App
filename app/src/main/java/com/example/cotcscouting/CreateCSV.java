package com.example.cotcscouting;

import android.app.Activity;
import android.content.Context;
import android.widget.EditText;

import com.example.cotcscouting.data.model.QRCodeUtils;

public class CreateCSV {
    public void GenerateCs(Activity activity, Context context){
        //creates file needs to be save the data am lazy
        //TODO: add fix and make work

        EditText scoutNameEditText = activity.findViewById(R.id.scout_name);
        EditText match_number = activity.findViewById(R.id.match_number);
        EditText team_number = activity.findViewById(R.id.team_number);
        EditText Notes = activity.findViewById(R.id.notes);

        //For the Message
        String FileName = scoutNameEditText.getText().toString() + "_" + match_number.getText().toString() + "_" + team_number.getText().toString();
        String Header = "ScoutName; Match Number; Team Number; Total Points; Telop Prosser Points; Auto Prosser Points; Telop net points; Auto net points; Telop L1 points; Auto L1 Points; past Starting Line; Notes; Total barge Points;";
        String vals = scoutNameEditText.getText().toString() + ";"  + match_number.getText().toString() + ";"  + "TODO: Points" + ";" + MainActivity.TelopProsserPoints + ";" + MainActivity.AutopProsserPoints + ";" + MainActivity.TelopNetPoints + ";" + MainActivity.AutoNetPoints + ";" + MainActivity.TelopL1Points + ";" + MainActivity.AutoL1Points + ";" + Notes.getText().toString() + ";" + MainActivity.BargePoints;

        //generates the qr code
        QRCodeUtils.generateAndSaveQRCode(context,Header + "|" + vals,FileName);
    }
}
