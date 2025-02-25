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
        String vals = scoutNameEditText.getText().toString() + ","  + match_number.getText().toString() + "," + MainActivity.TelopProsserPoints + "," + MainActivity.AutopProsserPoints + "," + MainActivity.TelopNetPoints + "," + MainActivity.AutoNetPoints + "," + MainActivity.TelopL1Points + "," + MainActivity.AutoL1Points + "," + Notes.getText().toString() + "," + MainActivity.BargePoints + "," + MainActivity.checkBox1Auto + "," + MainActivity.checkBox2Auto + "," + MainActivity.checkBox3Auto + "," + MainActivity.checkBox4Auto + "," + MainActivity.checkBox5Auto + "," + MainActivity.checkBox6Auto + "," + MainActivity.checkBox7Auto + "," + MainActivity.checkBox8Auto + "," + MainActivity.checkBox9Auto + "," + MainActivity.checkBox10Auto + "," + MainActivity.checkBox11Auto + "," + MainActivity.checkBox12Auto + "," + MainActivity.checkBox13Auto + "," + MainActivity.checkBox14Auto + "," + MainActivity.checkBox15Auto + "," + MainActivity.checkBox16Auto + "," + MainActivity.checkBox17Auto + "," + MainActivity.checkBox18Auto + "," + MainActivity.checkBox19Auto + "," + MainActivity.checkBox20Auto + "," + MainActivity.checkBox21Auto + "," + MainActivity.checkBox22Auto + "," + MainActivity.checkBox23Auto + "," + MainActivity.checkBox24Auto + "," + MainActivity.checkBox25Auto + "," + MainActivity.checkBox26Auto + "," + MainActivity.checkBox27Auto + "," + MainActivity.checkBox28Auto + "," + MainActivity.checkBox29Auto + "," + MainActivity.checkBox30Auto + "," + MainActivity.checkBox31Auto + "," + MainActivity.checkBox32Auto + "," + MainActivity.checkBox33Auto + "," + MainActivity.checkBox34Auto + "," + MainActivity.checkBox35Auto + "," + MainActivity.checkBox36Auto + "," + MainActivity.checkBox1TeleOp + "," + MainActivity.checkBox2TeleOp + "," + MainActivity.checkBox3TeleOp + "," + MainActivity.checkBox4TeleOp + "," + MainActivity.checkBox5TeleOp + "," + MainActivity.checkBox6TeleOp + "," + MainActivity.checkBox7TeleOp + "," + MainActivity.checkBox8TeleOp + "," + MainActivity.checkBox9TeleOp + "," + MainActivity.checkBox10TeleOp + "," + MainActivity.checkBox11TeleOp + "," + MainActivity.checkBox12TeleOp + "," + MainActivity.checkBox13TeleOp + "," + MainActivity.checkBox14TeleOp + "," + MainActivity.checkBox15TeleOp + "," + MainActivity.checkBox16TeleOp + "," + MainActivity.checkBox17TeleOp + "," + MainActivity.checkBox18TeleOp + "," + MainActivity.checkBox19TeleOp + "," + MainActivity.checkBox20TeleOp + "," + MainActivity.checkBox21TeleOp + "," + MainActivity.checkBox22TeleOp + "," + MainActivity.checkBox23TeleOp + "," + MainActivity.checkBox24TeleOp + "," + MainActivity.checkBox25TeleOp + "," + MainActivity.checkBox26TeleOp + "," + MainActivity.checkBox27TeleOp + "," + MainActivity.checkBox28TeleOp + "," + MainActivity.checkBox29TeleOp + "," + MainActivity.checkBox30TeleOp + "," + MainActivity.checkBox31TeleOp + "," + MainActivity.checkBox32TeleOp + "," + MainActivity.checkBox33TeleOp + "," + MainActivity.checkBox34TeleOp + "," + MainActivity.checkBox35TeleOp + "," + MainActivity.checkBox36TeleOp;

        //generates the qr code
        String ValsP1 = vals.substring(0,vals.length()/2);
        String ValsP2 = vals.substring(vals.length()/2);
        QRCodeUtils.generateAndSaveQRCode(context,ValsP1,FileName);
        QRCodeUtils.generateAndSaveQRCode(context,ValsP2,FileName + "P2");
    }
}
