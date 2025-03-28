package com.example.cotcscouting;

import static com.example.cotcscouting.R.color.medium_purple;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.slider.Slider;
import com.google.android.material.textfield.TextInputEditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class MainActivity extends AppCompatActivity {

    //all below this line is for the data entry

    //Declarations
    Button ProserDec, ProserInc, NetDec, NetInc, L1Dec, L1Inc;
    TextView ProsserPoints, NetPoints, L1Points;

    static int TelopProsserPoints, AutopProsserPoints, TelopNetPoints, AutoNetPoints, TelopL1Points, AutoL1Points, BargePoints = 0;


    static CheckBox[] CheckBoxes = new CheckBox[36];

    static Boolean[] IsCheckedInAuto = new Boolean[36];

    static Boolean[] IsCheckedInTelop = new Boolean[36];

    //Used for the golden check box
    static boolean PlayedDefense = false;
    CheckBox DefensiveTeam;

    //Used for if they passed start in auto
    static boolean PassedGo = false;
    CheckBox DidTheyPassStart;

    //for the drop down of parking

    Spinner ParkingPlaces;
    static String WhareParked = "Did Not Park";


    boolean isDullBlue = true;


    //is checked
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch IsTelop;
    TextView TeleOpCheckText;

    //submit
    Button Submit;

    //The Qr Code Screen
    Button GoToQrCode;

    //This is used to keep track how good they were at defense

    Slider DefenseSlider;
    static int DefenseScore = -1;



    //all below this line is for the qr code screen

    Button GoBack, RestMem;

    ImageView TheQrImage1;
    ImageView TheQrImage2;

    //Used By settings
        //Valid vals 0,1,2,3 for line 1
        // when value = -1 means it has not yet been set
        // when value = 0 means you are sitting behind the refes
        // When Value = 1 Means you are sitting in froint of the judges
        int VersionOfMainView = -1;
        int TrackedBot = 1;

        //used to track if its tracking a red Team


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        RestMem();
        //TODO: DELETE WHEN NOT TESTING PLEASE
//        JavaData.removeAllFilesInDir(MainActivity.this);
//        JavaData.DelteConfig(MainActivity.this);


        File Config = new File(this.getFilesDir(),"Config");

        if (!Config.exists()){
            SetUpSettings();
        }else{
            SetUpMainScreen();
        }
    }

    public void MainScreenLoader(){
        /*TODO: need to make it load the config
          and choose the right screen to laod depending on whare they are sitting and what bot they are tracking
         */


        if (VersionOfMainView == -1){
            Scanner scan;
            File Config = new File(this.getFilesDir(),"Config");
            try {
                scan = new Scanner(Config);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);

            }
       VersionOfMainView = Integer.parseInt(scan.nextLine());
            TrackedBot = Integer.parseInt(scan.nextLine());
            Log.d("Location", VersionOfMainView + "");
            Log.d("Bot tracked", "Bot :" + TrackedBot);
        }



        //TODO: Add more views

        if (VersionOfMainView == 0){
            setContentView(R.layout.hex_tech_view_model_v0);
        } else if (VersionOfMainView == 1) {
            setContentView(R.layout.hex_tech_view_model_v1);
        }else if(VersionOfMainView == 2){
            setContentView(R.layout.hex_tech_view_model_v2);
        } else if (VersionOfMainView == 3) {
            setContentView(R.layout.hex_tech_view_model_v3);
        }else{
            System.exit(1);
        }
    }

    @SuppressLint({"UseSwitchCompatOrMaterialCode", "SetTextI18n"})
    public void SetUpSettings(){
        setContentView(R.layout.setup_screen);

        Switch IsTrackingBlue = findViewById(R.id.IsTrackingRed);

        Button SatBehindJudges = findViewById(R.id.BehindJudges);

        Button SatFarFromJudges = findViewById(R.id.SatInFrontOfJudges);

        RadioButton TrackingBot1 = findViewById(R.id.TrackingBot1);
        RadioButton TrackingBot2 = findViewById(R.id.TrackingBot2);
        RadioButton TrackingBot3 = findViewById(R.id.TrackingBot3);



        IsTrackingBlue.setOnClickListener(view ->{
            if (IsTrackingBlue.isChecked()){
                IsTrackingBlue.setText("Tablet Will Track Blue");
            }else{
                IsTrackingBlue.setText("Tablet Will Track Red");
            }
        });

        //This is used to create the config log
        File Config = new File(this.getFilesDir(),"Config");
        try {
            Config.createNewFile();

        } catch (IOException e) {
            Log.d("Failed to create config", ":(: ");
            throw new RuntimeException(e);
        }

        //Used By settings
        //Valid vals 0,1,2,3 for line 1
        // when value = 0 means you are sitting Behind the refs and following a red bot
        // When Value = 1 Means you are sitting Behind the refs and following a blue bot
        // when value = 2 means you are sitting In front of the refs and following a red bot
        // When Value = 3 Means you are sitting In front of the refs and following a blue bot

        FileWriter Writer;

        try {
            Writer = new FileWriter(Config);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        SatBehindJudges.setOnClickListener(view -> {
            try {
                if (IsTrackingBlue.isChecked()){
                    Writer.append("1\n");
                }else{
                    Writer.append("0\n");
                }


                //for what bot is tracked
                if(TrackingBot1.isChecked()){
                    Writer.append("1");
                } else if (TrackingBot2.isChecked()) {
                    Writer.append("2");
                }else {
                    Writer.append("3");
                }


                Writer.flush();
                Writer.close();
                SetUpMainScreen();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        SatFarFromJudges.setOnClickListener(view -> {
            try {

                //for what data entry version to load
                if (IsTrackingBlue.isChecked()){
                    Writer.append("3\n");
                }else{
                    Writer.append("2\n");
                }

                //for what bot is tracked
                if(TrackingBot1.isChecked()){
                    Writer.append("1");
                } else if (TrackingBot2.isChecked()) {
                    Writer.append("2");
                }else {
                    Writer.append("3");
                }


                Writer.flush();
                Writer.close();
                SetUpMainScreen();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });




    }

    @SuppressLint({"SetTextI18n", "UseCompatLoadingForDrawables"})
    public void SetUpMainScreen(){
        //loads the correct xml
        MainScreenLoader();

        //restes the memery of the hexagon
        Arrays.fill(IsCheckedInAuto, Boolean.FALSE);
        Arrays.fill(IsCheckedInTelop, Boolean.FALSE);



        // will probaly make caulder happy
        for (int i = 1; i <= 36; i++) {
            @SuppressLint("DiscouragedApi") int resID = getResources().getIdentifier("checkBox" + i, "id", getPackageName());
            CheckBoxes[i-1] = findViewById(resID);
        }

        for (int i = 0; i < CheckBoxes.length; i++) {
            int finalI = i;
            CheckBoxes[i].setOnClickListener(view -> {
                if (IsTelop.isChecked()){
                    IsCheckedInTelop[finalI] = CheckBoxes[finalI].isChecked();
                    if (Config.Debug) {
                        Log.d("Hecagon checked", "buttion With id: " + finalI + "Was checked and set is checked in telop to " + CheckBoxes[finalI].isChecked());
                    }
                }else if (!IsTelop.isChecked()){
                    IsCheckedInAuto[finalI] = CheckBoxes[finalI].isChecked();
                    if (Config.Debug) {
                        Log.d("Hecagon checked", "buttion With id: " + finalI + "Was checked and set is check in Auto to " + CheckBoxes[finalI].isChecked());
                    }
                }
            });
        }

        //Color keys for l2 l3 l4
        CheckBox L2Key = findViewById(R.id.L2Key);
        CheckBox L3Key = findViewById(R.id.L3Key);
        CheckBox L4Key = findViewById(R.id.L4Key);

        ProserDec  = findViewById(R.id.ProcessorDec);
        ProserInc = findViewById(R.id.ProcessorInc);
        ProsserPoints =  findViewById(R.id.ProcessorPoints);

        L1Dec = findViewById(R.id.L1CoralDec);
        L1Inc = findViewById(R.id.L1CoralInc);
        L1Points =findViewById(R.id.L1Points);

        NetDec = findViewById(R.id.NetDec);
        NetInc = findViewById(R.id.NetInc);
        NetPoints = findViewById(R.id.NetPoints);



        //used to define what the defense slider does
        DefenseSlider = findViewById(R.id.DefenseSlider);

        //this local as it is only used here show what bot should be tracked
        TextView WhatBotToFollow = findViewById(R.id.TrackedBot);



        //cheks telop
        IsTelop = findViewById(R.id.teleOpCheck);
        TeleOpCheckText = findViewById(R.id.teleOpCheckText);
        //check box listeners

        ProsserPoints = findViewById(R.id.ProcessorPoints);
        ProsserPoints.setText("0");

        NetPoints.setText("0");



        L1Points.setText("0");

//        TeleOpCheckText = findViewById(R.id.)
//        TeleOpCheckText.setText("Auto");
        //check box reset
        for(int i = 0; i < 36; i++) {
            CheckBoxes[i].setChecked(false);
        }

        //color for telop Barge?
        L4Key.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
        L3Key.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
        L2Key.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
        boolean FilpFlop = false;
        for (int i = 0; i < CheckBoxes.length; i++) {
            if ((i + 1)%3 == 0){
                CheckBoxes[i].setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
            } else if (FilpFlop) {
                FilpFlop = !FilpFlop;
                CheckBoxes[i].setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
            }else{
                FilpFlop = !FilpFlop;
                CheckBoxes[i].setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
            }
        }


        //Defense slider
        DefenseSlider.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                DefenseScore = (int) value;
                if (Config.Debug) {
                Log.d("Slider moved", "New val = " + DefenseScore);
                }
            }
        });

        //prosser

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
            } else if (!IsTelop.isChecked() && AutoL1Points > 0) {
                AutoL1Points--;
                L1Points.setText(String.valueOf(AutoL1Points));
            }
        });


        IsTelop.setThumbTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));



        //needs to be at the bottem this is also whare the Telop switch happens IsTelop
        IsTelop.setOnClickListener(view -> {
            if (IsTelop.isChecked()){
                ProsserPoints.setText(String.valueOf(TelopProsserPoints));
                NetPoints.setText(String.valueOf(TelopNetPoints));
                L1Points.setText(String.valueOf(TelopL1Points));
                TeleOpCheckText.setText("Tele-Op");

                //sets the color of the chekc boxes
                boolean NewFilpFlop = false;
                for (int i = 0; i < CheckBoxes.length; i++) {
                    if ((i+1)%3 == 0){
                        CheckBoxes[i].setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_magenta)));
                    } else if (NewFilpFlop) {
                        NewFilpFlop = !NewFilpFlop;
                        CheckBoxes[i].setButtonTintList(ColorStateList.valueOf(getColor(medium_purple)));
                    }else{
                        NewFilpFlop = !NewFilpFlop;
                        CheckBoxes[i].setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_blue)));
                    }
                }


                //check box reset
                for(int i = 0; i < 36; i++) {
                    if (!IsCheckedInAuto[i]) {
                        CheckBoxes[i].setChecked(IsCheckedInTelop[i]);
                    }else{
                        CheckBoxes[i].setClickable(false);
                        CheckBoxes[i].setButtonTintList(ColorStateList.valueOf(getColor(R.color.md_theme_dark_outline)));
                    }
                }

                //color for auto
                L4Key.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_magenta)));
                L3Key.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_purple)));
                L2Key.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_blue)));





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
                //check box reset uses is check in auto
                for(int i = 0; i < 36; i++) {
                    CheckBoxes[i].setChecked(IsCheckedInAuto[i]);
                    CheckBoxes[i].setClickable(true);
                }

                //color for auto l2,l3,l4
                L4Key.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
                L3Key.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
                L2Key.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));


                boolean NewFilpFlop = false;
                for (int i = 0; i < CheckBoxes.length; i++) {
                    if ((i+1)%3 == 0){
                        CheckBoxes[i].setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
                    } else if (NewFilpFlop) {
                        NewFilpFlop = !NewFilpFlop;
                        CheckBoxes[i].setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
                    }else{
                        NewFilpFlop = !NewFilpFlop;
                        CheckBoxes[i].setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
                    }
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

        //spinner for Parking
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

        ParkingPlaces.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                WhareParked = ParkingPlaces.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //submit
        Submit = findViewById(R.id.SubmitButtion);

        Submit.setOnClickListener(view -> {
            new CreateCSV().GenerateCs(this,MainActivity.this);
            RestMem();
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

        //is good team / golden team

        DefensiveTeam = findViewById(R.id.PlayedDefense);

        DefensiveTeam.setOnClickListener(view -> {
            PlayedDefense = DefensiveTeam.isChecked();
            DefenseSlider.setEnabled(PlayedDefense);
            if (!PlayedDefense){
                DefenseSlider.setValue(0);
                DefenseScore = -1;
            }else{
                DefenseScore = 0;
            }
        });

        // This code say what bot to track
        if (VersionOfMainView == 0){
            WhatBotToFollow.setText("Track Red " + TrackedBot);
        }else if (VersionOfMainView == 1){
            WhatBotToFollow.setText("Track Blue " + TrackedBot);
        }else if (VersionOfMainView == 2){
            WhatBotToFollow.setText("Track Red " + TrackedBot);
        }else{
            WhatBotToFollow.setText("Track Blue " + TrackedBot);
        }

        //If the passed the starting line
        DidTheyPassStart = findViewById(R.id.PastStartingLineCheck);

        DidTheyPassStart.setOnClickListener(view -> {
            PassedGo = DefensiveTeam.isChecked();
        });
    }

    public void SetUpQrCodes(){
        GoBack = findViewById(R.id.Goback);
        GoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.hex_tech_view_model_v0);
                RestMemForGoingToMainScreen();
                SetUpMainScreen();
            }
        });

        RestMem = findViewById(R.id.RestMem);
        RestMem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JavaData.RemoveQrCodes(MainActivity.this);
                JavaData.DelteConfig(MainActivity.this);
                System.exit(0);
            }
        });

        //spinner
        ArrayList<String> QrCodesFileNamesAllParts = JavaData.getAllFilesInDir(MainActivity.this);
        ArrayList<String> QrCodesFileNames = new ArrayList<>();
        for (int i = 0; i < QrCodesFileNamesAllParts.size(); i++) {
            if (i%2 == 0){
                QrCodesFileNames.add(QrCodesFileNamesAllParts.get(i));
                //To hide the part 2 so that it isnt seltecd acdently
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, QrCodesFileNames);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    // Set the adapter to the Spinner
        Spinner qrCodesSpinner = findViewById(R.id.QrCodeFiles);
        qrCodesSpinner.setAdapter(adapter);

        TheQrImage1 = findViewById(R.id.QrCodeImage1);
        TheQrImage2 = findViewById(R.id.QrCodeImage2);
        qrCodesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Get the selected item
                String selectedItem1 = parentView.getItemAtPosition(position).toString();
                String selectedItem2 = parentView.getItemAtPosition(position).toString();
                //removes png header and P2 to get the secend part
                selectedItem2 = selectedItem2.substring(0,selectedItem2.length() - 4) + "P2.png";



//                idk  a= MainActivity;

                File dir = new File(getFilesDir(), "QRCodeImages");
                //file 1
                File file1 = new File(dir ,selectedItem1);
                Uri uri1 = Uri.fromFile(file1);

                //file 2
                File file2 = new File(dir ,selectedItem2);
                Uri uri2 = Uri.fromFile(file2);

                TheQrImage1.setImageURI(uri1);
                if (Config.Debug) {
                    Log.d("Set image 1", selectedItem1);
                }
                TheQrImage2.setImageURI(uri2);
                if (Config.Debug) {
                    Log.d("Set image 2", selectedItem2);
                }

                // You can now use the selectedItem
                if (Config.Debug) {
                    Log.d("Spinner", "Selected item: " + selectedItem1);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Optional: Handle the case where no item is selected (e.g., if the spinner is reset)
            }
        });
    }
// checkBox + num + teleop
    public void RestMemForGoingToMainScreen(){
        TelopProsserPoints = 0;
        AutopProsserPoints = 0;
        TelopNetPoints = 0;
        AutoNetPoints = 0;
        TelopL1Points = 0;
        AutoL1Points = 0;
        BargePoints = 0;
        for(int i = 0; i < 36; i++) {
            IsCheckedInAuto[i] = false;
            IsCheckedInTelop[i] = false;
        }


    }


    //Should only be used when in the data entry screen
    @SuppressLint("SetTextI18n")
    public void RestMem(){
        TelopProsserPoints = 0;
        AutopProsserPoints = 0;
        TelopNetPoints = 0;
        AutoNetPoints = 0;
        TelopL1Points = 0;
        AutoL1Points = 0;
        BargePoints = 0;
        for(int i = 0; i < 36; i++) {
            IsCheckedInAuto[i] = false;
            IsCheckedInTelop[i] = false;
        }

        ProsserPoints.setText(String.valueOf(AutopProsserPoints));
        NetPoints.setText(String.valueOf(AutoNetPoints));
        L1Points.setText(String.valueOf(AutoL1Points));
        TeleOpCheckText.setText("Auto");

        DidTheyPassStart.setChecked(false);
        DefensiveTeam.setChecked(false);


        //check box reset uses is check in auto
        for(int i = 0; i < 36; i++) {
            CheckBoxes[i].setChecked(IsCheckedInAuto[i]);
            CheckBoxes[i].setClickable(true);
        }

        IsTelop.setChecked(false);

        //color for auto l2,l3,l4
        CheckBox L2Key = findViewById(R.id.L2Key);
        CheckBox L3Key = findViewById(R.id.L3Key);
        CheckBox L4Key = findViewById(R.id.L4Key);

        L4Key.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
        L3Key.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
        L2Key.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));


        boolean NewFilpFlop = false;
        for (int i = 0; i < CheckBoxes.length; i++) {
            if ((i+1)%3 == 0){
                CheckBoxes[i].setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
            } else if (NewFilpFlop) {
                NewFilpFlop = !NewFilpFlop;
                CheckBoxes[i].setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
            }else{
                NewFilpFlop = !NewFilpFlop;
                CheckBoxes[i].setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
            }
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

        TextInputEditText RestMatchNumber = findViewById(R.id.match_number);
        RestMatchNumber.setText("");

        TextInputEditText RestTeamNumber = findViewById(R.id.team_number);
        RestTeamNumber.setText("");

        TextInputEditText RestTotalPoints = findViewById(R.id.total_points);
        RestTotalPoints.setText("");

    }
}
