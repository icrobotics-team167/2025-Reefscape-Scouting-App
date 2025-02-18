package com.example.cotcscouting;

import static androidx.core.view.ViewCompat.setBackgroundTintList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cotcscouting.data.model.QRCodeUtils;
import com.google.android.material.switchmaterial.SwitchMaterial;

import java.io.File;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    //all below this line is for the data entry

    //Declarations
    Button ProserDec, ProserInc, NetDec, NetInc, L1Dec, L1Inc, BargeInc, BargeDec;
    TextView ProsserPoints, NetPoints, L1Points, BargePointsLabel, BargeReferenceHeader;
    CheckBox L2Key, L3Key, L4Key, CheckBox1, CheckBox2, CheckBox3, CheckBox4, CheckBox5, CheckBox6, CheckBox7, CheckBox8, CheckBox9, CheckBox10, CheckBox11, CheckBox12, CheckBox13, CheckBox14, CheckBox15, CheckBox16, CheckBox17, CheckBox18, CheckBox19, CheckBox20, CheckBox21, CheckBox22, CheckBox23, CheckBox24, CheckBox25, CheckBox26, CheckBox27, CheckBox28, CheckBox29, CheckBox30, CheckBox31, CheckBox32, CheckBox33, CheckBox34, CheckBox35, CheckBox36;

    static int TelopProsserPoints, AutopProsserPoints, TelopNetPoints, AutoNetPoints, TelopL1Points, AutoL1Points, BargePoints = 0;
    static boolean checkBox1Auto, checkBox2Auto, checkBox3Auto, checkBox4Auto, checkBox5Auto, checkBox6Auto, checkBox7Auto, checkBox8Auto, checkBox9Auto, checkBox10Auto, checkBox11Auto, checkBox12Auto, checkBox13Auto, checkBox14Auto, checkBox15Auto, checkBox16Auto, checkBox17Auto, checkBox18Auto, checkBox19Auto, checkBox20Auto, checkBox21Auto, checkBox22Auto, checkBox23Auto, checkBox24Auto, checkBox25Auto, checkBox26Auto, checkBox27Auto, checkBox28Auto, checkBox29Auto, checkBox30Auto, checkBox31Auto, checkBox32Auto, checkBox33Auto, checkBox34Auto, checkBox35Auto, checkBox36Auto = false;
    static boolean checkBox1TeleOp, checkBox2TeleOp, checkBox3TeleOp, checkBox4TeleOp, checkBox5TeleOp, checkBox6TeleOp, checkBox7TeleOp, checkBox8TeleOp, checkBox9TeleOp, checkBox10TeleOp, checkBox11TeleOp, checkBox12TeleOp, checkBox13TeleOp, checkBox14TeleOp, checkBox15TeleOp, checkBox16TeleOp, checkBox17TeleOp, checkBox18TeleOp, checkBox19TeleOp, checkBox20TeleOp, checkBox21TeleOp, checkBox22TeleOp, checkBox23TeleOp, checkBox24TeleOp, checkBox25TeleOp, checkBox26TeleOp, checkBox27TeleOp, checkBox28TeleOp, checkBox29TeleOp, checkBox30TeleOp, checkBox31TeleOp, checkBox32TeleOp, checkBox33TeleOp, checkBox34TeleOp, checkBox35TeleOp, checkBox36TeleOp = false;

    //coral check box lists
    CheckBox[] CheckBoxes = {CheckBox1, CheckBox2, CheckBox3, CheckBox4, CheckBox5, CheckBox6, CheckBox7, CheckBox8, CheckBox9, CheckBox10, CheckBox11, CheckBox12, CheckBox13, CheckBox14, CheckBox15, CheckBox16, CheckBox17, CheckBox18, CheckBox19, CheckBox20, CheckBox21, CheckBox22, CheckBox23, CheckBox24, CheckBox25, CheckBox26, CheckBox27, CheckBox28, CheckBox29, CheckBox30, CheckBox31, CheckBox32, CheckBox33, CheckBox34, CheckBox35, CheckBox36};
    int[] checkBoxes = {(R.id.checkBox1), (R.id.checkBox2), (R.id.checkBox3), (R.id.checkBox4), (R.id.checkBox5), (R.id.checkBox6), (R.id.checkBox7), (R.id.checkBox8), (R.id.checkBox9), (R.id.checkBox10), (R.id.checkBox11), (R.id.checkBox12), (R.id.checkBox13), (R.id.checkBox14), (R.id.checkBox15), (R.id.checkBox16), (R.id.checkBox17), (R.id.checkBox18), (R.id.checkBox19), (R.id.checkBox20), (R.id.checkBox21), (R.id.checkBox22), (R.id.checkBox23), (R.id.checkBox24), (R.id.checkBox25), (R.id.checkBox26), (R.id.checkBox27), (R.id.checkBox28), (R.id.checkBox29), (R.id.checkBox30), (R.id.checkBox31), (R.id.checkBox32), (R.id.checkBox33), (R.id.checkBox34), (R.id.checkBox35), (R.id.checkBox36)};
    boolean[] checkBoxesAuto = {checkBox1Auto, checkBox2Auto, checkBox3Auto, checkBox4Auto, checkBox5Auto, checkBox6Auto, checkBox7Auto, checkBox8Auto, checkBox9Auto, checkBox10Auto, checkBox11Auto, checkBox12Auto, checkBox13Auto, checkBox14Auto, checkBox15Auto, checkBox16Auto, checkBox17Auto, checkBox18Auto, checkBox19Auto, checkBox20Auto, checkBox21Auto, checkBox22Auto, checkBox23Auto, checkBox24Auto, checkBox25Auto, checkBox26Auto, checkBox27Auto, checkBox28Auto, checkBox29Auto, checkBox30Auto, checkBox31Auto, checkBox32Auto, checkBox33Auto, checkBox34Auto, checkBox35Auto, checkBox36Auto};
    boolean[] checkBoxesTeleOp = {checkBox1TeleOp, checkBox2TeleOp, checkBox3TeleOp, checkBox4TeleOp, checkBox5TeleOp, checkBox6TeleOp, checkBox7TeleOp, checkBox8TeleOp, checkBox9TeleOp, checkBox10TeleOp, checkBox11TeleOp, checkBox12TeleOp, checkBox13TeleOp, checkBox14TeleOp, checkBox15TeleOp, checkBox16TeleOp, checkBox17TeleOp, checkBox18TeleOp, checkBox19TeleOp, checkBox20TeleOp, checkBox21TeleOp, checkBox22TeleOp, checkBox23TeleOp, checkBox24TeleOp, checkBox25TeleOp, checkBox26TeleOp, checkBox27TeleOp, checkBox28TeleOp, checkBox29TeleOp, checkBox30TeleOp, checkBox31TeleOp, checkBox32TeleOp, checkBox33TeleOp, checkBox34TeleOp, checkBox35TeleOp, checkBox36TeleOp};


    //for the drop down
    Spinner ParkingPlaces;

    //Keeps Tack of what page it is
    boolean IsMain = true;

    //is checked
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    static Switch IsTelop;
    TextView TeleOpCheckText;

    //submit
    Button Submit;

    //The Qr Code Screen
    Button GoToQrCode;


    //all below this line is for the qr code screen

    Button GoBack;
    Spinner QrCodes;

    ImageView TheQrImage;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hex_tech_view_model);
        SetUpMainScreen();
        ProsserPoints.setText("0");
        NetPoints.setText("0");
        L1Points.setText("0");
        TeleOpCheckText.setText("Auto");
        //check box reset
        for(int i = 0; i < 36; i++) {
            CheckBoxes[i].setChecked(false);
        }
        //colors L4
        if(true) {
            L4Key.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
            CheckBox1.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
            CheckBox2.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
            CheckBox3.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
            CheckBox4.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
            CheckBox13.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
            CheckBox18.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
            CheckBox19.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
            CheckBox24.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
            CheckBox33.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
            CheckBox34.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
            CheckBox35.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
            CheckBox36.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
        }
        //colors L3
        if(true) {
            L3Key.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
            CheckBox5.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
            CheckBox6.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
            CheckBox7.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
            CheckBox8.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
            CheckBox14.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
            CheckBox17.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
            CheckBox20.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
            CheckBox23.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
            CheckBox29.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
            CheckBox30.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
            CheckBox31.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
            CheckBox32.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
        }
        //colors L2
        if(true) {
            L2Key.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
            CheckBox9.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
            CheckBox10.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
            CheckBox11.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
            CheckBox12.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
            CheckBox15.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
            CheckBox16.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
            CheckBox21.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
            CheckBox22.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
            CheckBox25.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
            CheckBox26.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
            CheckBox27.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
            CheckBox28.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
        }
        //color extras
        if(true) {
            //colors L1
            L1Dec.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.black)));
            L1Inc.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.black)));
            //algae
            ProserDec.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.medium_green)));
            ProserInc.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.medium_green)));
            NetDec.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.medium_green)));
            NetInc.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.medium_green)));
            //Switch
            IsTelop.setThumbTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
        }
    }

    @SuppressLint("SetTextI18n")
    public void SetUpMainScreen(){

        //Coral check boxes
        L2Key = findViewById(R.id.L2Key);
        L3Key = findViewById(R.id.L3Key);
        L4Key = findViewById(R.id.L4Key);
        for(int i = 0; i < 36; i++) {
            CheckBoxes[i] = findViewById(checkBoxes[i]);//**************************************************************************************************************
        }

        //cheks telop
        IsTelop = findViewById(R.id.teleOpCheck);
        TeleOpCheckText = findViewById(R.id.teleOpCheckText);
        //check box listeners
        for(int i = 0; i < 36; i++) {
            int finalI = i;
            CheckBoxes[i].setOnClickListener(view -> {
                checkBoxListener(CheckBoxes[finalI], checkBoxesAuto[finalI], checkBoxesTeleOp[finalI]);
            });
        }


        //prosser
        ProserDec  = findViewById(R.id.ProcessorDec);
        ProserInc = findViewById(R.id.ProcessorInc);
        ProsserPoints =  findViewById(R.id.ProcessorPoints);

        ProserInc.setOnClickListener(view -> {
            if (IsTelop.isChecked()){
                TelopProsserPoints++;
                ProsserPoints.setText(String.valueOf(TelopProsserPoints));
            } else if (!IsTelop.isChecked()) {
                AutopProsserPoints++;
                ProsserPoints.setText(String.valueOf(AutopProsserPoints));
            }
        });


        ProserDec.setOnClickListener(view -> {
            if (IsTelop.isChecked() && TelopProsserPoints > 0){
                TelopProsserPoints--;
                ProsserPoints.setText(String.valueOf(TelopProsserPoints));
            } else if (!IsTelop.isChecked() && AutopProsserPoints > 0) {
                AutopProsserPoints--;
                ProsserPoints.setText(String.valueOf(AutopProsserPoints));
            }
        });

        //net
        NetDec = findViewById(R.id.NetDec);
        NetInc = findViewById(R.id.NetInc);
        NetPoints = findViewById(R.id.NetPoints);

        NetInc.setOnClickListener(view -> {
            if (IsTelop.isChecked()){
                TelopNetPoints++;
                NetPoints.setText(String.valueOf(TelopNetPoints));
            } else if (!IsTelop.isChecked()) {
                AutoNetPoints++;
                NetPoints.setText(String.valueOf(AutoNetPoints));
            }
        });

        NetDec.setOnClickListener(view -> {
            if (IsTelop.isChecked() && TelopNetPoints > 0){
                TelopNetPoints--;
                NetPoints.setText(String.valueOf(TelopNetPoints));
            } else if (!IsTelop.isChecked() && AutoNetPoints > 0) {
                AutoNetPoints--;
                NetPoints.setText(String.valueOf(AutoNetPoints));
            }
        });

        //L1
        L1Dec = findViewById(R.id.L1CoralDec);
        L1Inc = findViewById(R.id.L1CoralInc);
        L1Points = findViewById(R.id.L1Points);

        L1Inc.setOnClickListener(view -> {
            if (IsTelop.isChecked()){
                TelopL1Points++;
                L1Points.setText(String.valueOf(TelopL1Points));
            } else if (!IsTelop.isChecked()) {
                AutoL1Points++;
                L1Points.setText(String.valueOf(AutoL1Points));
            }
        });

        L1Dec.setOnClickListener(view -> {
            if (IsTelop.isChecked() && TelopL1Points > 0){
                TelopL1Points--;
                L1Points.setText(String.valueOf(TelopL1Points));
            } else if (!IsTelop.isChecked() && AutoNetPoints > 0) {
                AutoL1Points--;
                L1Points.setText(String.valueOf(AutoL1Points));
            }
        });

        BargeDec = findViewById(R.id.BargeDec);
        BargeInc = findViewById(R.id.BargeInc);
        BargePointsLabel = findViewById(R.id.BargePoints);
        BargeReferenceHeader = findViewById(R.id.BargeReferenceHeader);

        //barge
        BargeDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (BargePoints > 0){
                    BargePoints--;
                    BargePointsLabel.setText(String.valueOf(BargePoints));
                }
            }
        });

        BargeInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BargePoints++;
                BargePointsLabel.setText(String.valueOf(BargePoints));
            }
        });

        BargeReferenceHeader.setOnClickListener(view -> {
            if(((ColorDrawable) BargeReferenceHeader.getBackground()).getColor() == getResources().getColor(R.color.dull_blue)) {
                BargeReferenceHeader.setBackgroundResource(R.color.dull_red);
            } else {
                BargeReferenceHeader.setBackgroundResource(R.color.dull_blue);
            }
        });

        //needs to be at the bottem this is also whare the Telop switch happens IsTelop
        IsTelop.setOnClickListener(view -> {
            if (IsTelop.isChecked()){
                ProsserPoints.setText(String.valueOf(TelopProsserPoints));
                NetPoints.setText(String.valueOf(TelopNetPoints));
                L1Points.setText(String.valueOf(TelopL1Points));
                TeleOpCheckText.setText("Tele-Op");
                //check box reset
                for(int i = 0; i < 36; i++) {
                    CheckBoxes[i].setChecked(checkBoxesTeleOp[i]);
                }
                //colors L4
                if(true) {
                    L4Key.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_magenta)));
                    CheckBox1.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_magenta)));
                    CheckBox2.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_magenta)));
                    CheckBox3.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_magenta)));
                    CheckBox4.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_magenta)));
                    CheckBox13.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_magenta)));
                    CheckBox18.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_magenta)));
                    CheckBox19.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_magenta)));
                    CheckBox24.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_magenta)));
                    CheckBox33.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_magenta)));
                    CheckBox34.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_magenta)));
                    CheckBox35.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_magenta)));
                    CheckBox36.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_magenta)));
                }
                //colors L3
                if(true) {
                    L3Key.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_purple)));
                    CheckBox5.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_purple)));
                    CheckBox6.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_purple)));
                    CheckBox7.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_purple)));
                    CheckBox8.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_purple)));
                    CheckBox14.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_purple)));
                    CheckBox17.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_purple)));
                    CheckBox20.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_purple)));
                    CheckBox23.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_purple)));
                    CheckBox29.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_purple)));
                    CheckBox30.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_purple)));
                    CheckBox31.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_purple)));
                    CheckBox32.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_purple)));
                }
                //colors L2
                if(true) {
                    L2Key.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_blue)));
                    CheckBox9.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_blue)));
                    CheckBox10.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_blue)));
                    CheckBox11.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_blue)));
                    CheckBox12.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_blue)));
                    CheckBox15.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_blue)));
                    CheckBox16.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_blue)));
                    CheckBox21.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_blue)));
                    CheckBox22.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_blue)));
                    CheckBox25.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_blue)));
                    CheckBox26.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_blue)));
                    CheckBox27.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_blue)));
                    CheckBox28.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_blue)));
                }
                //color extras
                if(true) {
                    //colors L1
                    L1Dec.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.gray)));
                    L1Inc.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.gray)));
                    //algae
                    ProserDec.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.medium_cyan)));
                    ProserInc.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.medium_cyan)));
                    NetDec.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.medium_cyan)));
                    NetInc.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.medium_cyan)));
                    //Switch
                    IsTelop.setThumbTintList(ColorStateList.valueOf(getColor(R.color.medium_blue)));
                }
                //Barge Reference Header
            }else{
                ProsserPoints.setText(String.valueOf(AutopProsserPoints));
                NetPoints.setText(String.valueOf(AutoNetPoints));
                L1Points.setText(String.valueOf(AutoL1Points));
                TeleOpCheckText.setText("Auto");
                //check box reset
                for(int i = 0; i < 36; i++) {
                    CheckBoxes[i].setChecked(checkBoxesAuto[i]);
                }
                //colors L4
                if(true) {
                    L4Key.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
                    CheckBox1.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
                    CheckBox2.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
                    CheckBox3.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
                    CheckBox4.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
                    CheckBox13.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
                    CheckBox18.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
                    CheckBox19.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
                    CheckBox24.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
                    CheckBox33.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
                    CheckBox34.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
                    CheckBox35.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
                    CheckBox36.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
                }
                //colors L3
                if(true) {
                    L3Key.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
                    CheckBox5.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
                    CheckBox6.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
                    CheckBox7.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
                    CheckBox8.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
                    CheckBox14.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
                    CheckBox17.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
                    CheckBox20.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
                    CheckBox23.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
                    CheckBox29.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
                    CheckBox30.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
                    CheckBox31.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
                    CheckBox32.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
                }
                //colors L2
                if(true) {
                    L2Key.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
                    CheckBox9.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
                    CheckBox10.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
                    CheckBox11.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
                    CheckBox12.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
                    CheckBox15.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
                    CheckBox16.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
                    CheckBox21.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
                    CheckBox22.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
                    CheckBox25.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
                    CheckBox26.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
                    CheckBox27.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
                    CheckBox28.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
                }
                //color extras
                if(true) {
                    //colors L1
                    L1Dec.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.black)));
                    L1Inc.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.black)));
                    //algae
                    ProserDec.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.medium_green)));
                    ProserInc.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.medium_green)));
                    NetDec.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.medium_green)));
                    NetInc.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.medium_green)));
                    //Switch
                    IsTelop.setThumbTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
                }
            }
        });

        //spinner
        ParkingPlaces = findViewById(R.id.parkDropDown);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.planets_array,
                android.R.layout.simple_spinner_item //

        );

        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        ParkingPlaces.setAdapter(adapter);

        //submit
        Submit = findViewById(R.id.SubmitButtion);

        Submit.setOnClickListener(view -> {
            new CreateCSV().GenerateCs(this,MainActivity.this);
        });

        //go to the qr code screen
        GoToQrCode = findViewById(R.id.jerry);
        GoToQrCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.show_the_codes);
                SetUpQrCodes();
            }
        });
    }

    public void SetUpQrCodes(){
        GoBack = findViewById(R.id.Goback);
        GoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.hex_tech_view_model);
                RestMem();
                SetUpMainScreen();
            }
        });

        //spinner
        ArrayList<String> QrCodesFileNames = JavaData.getAllFilesInDir(MainActivity.this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, QrCodesFileNames);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    // Set the adapter to the Spinner
        Spinner qrCodesSpinner = findViewById(R.id.QrCodeFiles);
        qrCodesSpinner.setAdapter(adapter);

        TheQrImage = findViewById(R.id.QrCodeImage);
        qrCodesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Get the selected item
                String selectedItem = parentView.getItemAtPosition(position).toString();

//                idk  a= MainActivity;

                File dir = new File(getFilesDir(), "QRCodeImages");
                File file = new File(dir ,selectedItem);
                Uri uri = Uri.fromFile(file);
                TheQrImage.setImageURI(uri);

                // You can now use the selectedItem
                Log.d("Spinner", "Selected item: " + selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Optional: Handle the case where no item is selected (e.g., if the spinner is reset)
            }
        });
    }
// checkBox + num + teleop
    public static void checkBoxListener(CheckBox CheckBox, boolean checkBoxAuto, boolean checkBoxTeleOp){
        if (IsTelop.isChecked() && !CheckBox.isChecked()) {
            checkBoxTeleOp = true;
            CheckBox.setChecked(checkBoxTeleOp);
        } else if (!IsTelop.isChecked() && !CheckBox.isChecked()) {
            checkBoxAuto = true;
            CheckBox.setChecked(checkBoxAuto);
        } else if (IsTelop.isChecked() && CheckBox.isChecked()) {
            checkBoxTeleOp = false;
            CheckBox.setChecked(checkBoxTeleOp);
        } else if (!IsTelop.isChecked() && CheckBox.isChecked()) {
            checkBoxAuto = false;
            CheckBox.setChecked(checkBoxAuto);
        }
    }

    public void RestMem(){
        TelopProsserPoints = 0;
        AutopProsserPoints = 0;
        TelopNetPoints = 0;
        AutoNetPoints = 0;
        TelopL1Points = 0;
        AutoL1Points = 0;
        BargePoints = 0;
        for(int i = 0; i < 36; i++) {
            checkBoxesAuto[i] = false;
            checkBoxesTeleOp[i] = false;
        }
    }

}
