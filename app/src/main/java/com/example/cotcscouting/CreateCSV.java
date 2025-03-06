package com.example.cotcscouting;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.CheckBox;
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

        Header.append("Is Good Team,");
        vals.append(MainActivity.IsGoodTeam);
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

        Header.append("L1 Auto,");
        vals.append(MainActivity.AutoL1Points);
        vals.append(",");

        Header.append("L1 Telop,");
        vals.append(MainActivity.TelopL1Points);
        vals.append(",");

        Header.append("L2 Auto,");
        vals.append(MainActivity.AutoL2Points);
        vals.append(",");

        Header.append("L2 Telop,");
        vals.append(MainActivity.TelopL2Points);
        vals.append(",");

        Header.append("L3 Auto,");
        vals.append(MainActivity.AutoL3Points);
        vals.append(",");

        Header.append("L3 Telop,");
        vals.append(MainActivity.TelopL3Points);
        vals.append(",");

        Header.append("L4 Auto,");
        vals.append(MainActivity.AutoL4Points);
        vals.append(",");

        Header.append("L4 Telop,");
        vals.append(MainActivity.TelopL4Points);
        vals.append(",");



        Header.append("Notes,");
        vals.append(Notes.getText().toString());

        Log.d("Header", Header.toString());


        QRCodeUtils.generateAndSaveQRCode(context,vals.toString(),FileName);
        QRCodeUtils.generateAndSaveQRCode(context,Header.toString(),FileName + "P2");
    }
}
