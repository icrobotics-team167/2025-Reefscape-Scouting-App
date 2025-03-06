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

        Header.append("Total Barge Alge,");
        vals.append(MainActivity.BargePoints);
        vals.append(",");


        //Starts at h based of the blue judges tabel and goes clock wise

        int Offset = 0;
        //Wing counter is uesd to keep track of waht wing it is;
        int WingCounter = 0;

        if (!MainActivity.BargeOnLeft){
            Offset = 17;
            WingCounter = 6;
        }
        char[] Places = {'h','g','f','e','d','c','b','a','l','k','j','i'};


        //Counter is ued to keep track of whareter its l2 l3 l4
        int counter = 2;
        for (int i = 0; i < MainActivity.IsCheckedInAuto.length; i++) {
            if ((i + 1) % 3 == 0){
                WingCounter++;
            }

            if(WingCounter >= Places.length){
                WingCounter = WingCounter - Places.length;
            }

            //TODO: Finsih the logic here for rotation
            Header.append("Auto Wing :");

            Header.append(Places[WingCounter]);
            Header.append(" Level :");
            Header.append(counter);
            Header.append(",");



            counter++;
            if(counter > 4){
                counter = 2;
            }
            if ((i + Offset) < MainActivity.IsCheckedInAuto.length){
                if(MainActivity.IsCheckedInAuto[i + Offset]){
                    vals.append("1,");
                }else{
                    vals.append("0,");
                }
            }else {
                if (MainActivity.IsCheckedInAuto[(i + Offset) - MainActivity.IsCheckedInAuto.length]) {
                    vals.append("1,");
                } else {
                    vals.append("0,");
                }
            }

        }


        Offset = 0;
        //Wing counter is uesd to keep track of What wing it is ie
        WingCounter = 0;

        if (!MainActivity.BargeOnLeft){
            Offset = 17;
            WingCounter = 6;
        }
        counter = 2;
        for (int i = 0; i < MainActivity.IsCheckedInTelop.length; i++) {
            if ((i + 1) % 3 == 0){
                WingCounter++;
            }

            if(WingCounter >= Places.length){
                WingCounter = WingCounter - Places.length;
            }

            //TODO: Finsih the logic here for rotation
            Header.append("Telop Wing :");

            Header.append(Places[WingCounter]);
            Header.append(" Level :");
            Header.append(counter);
            Header.append(",");


            counter++;
            if(counter > 4){
                counter = 2;
            }
            if ((i + Offset) < MainActivity.IsCheckedInAuto.length){
                if(MainActivity.IsCheckedInTelop[i + Offset]){
                    vals.append("1,");
                }else{
                    vals.append("0,");
                }
            }else {
                if (MainActivity.IsCheckedInTelop[(i + Offset) - MainActivity.IsCheckedInAuto.length]) {
                    vals.append("1,");
                } else {
                    vals.append("0,");
                }
            }

        }


        Header.append("Notes,");
        vals.append(Notes.getText().toString());

        Log.d("Header", Header.toString());


        QRCodeUtils.generateAndSaveQRCode(context,vals.toString(),FileName);
        QRCodeUtils.generateAndSaveQRCode(context,Header.toString(),FileName + "P2");
    }
}
