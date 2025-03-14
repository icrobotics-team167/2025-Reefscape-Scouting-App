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
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    //all below this line is for the data entry

    //Declarations
    Button ProserDec, ProserInc, NetDec, NetInc, L1Dec, L1Inc, BargeInc, BargeDec;
    TextView ProsserPoints, NetPoints, L1Points, BargePointsLabel, BargeReferenceHeaderRight, BargeReferenceHeaderLeft;

    static int TelopProsserPoints, AutopProsserPoints, TelopNetPoints, AutoNetPoints, TelopL1Points, AutoL1Points, BargePoints = 0;


    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch BargeIsLeft;
    static CheckBox[] CheckBoxes = new CheckBox[36];

    static Boolean[] IsCheckedInAuto = new Boolean[36];

    static Boolean[] IsCheckedInTelop = new Boolean[36];

    //Used for the golden check box
    static boolean IsGoodTeam = false;
    CheckBox GoldenTeam;

    //Used for if they passed start in auto
    static boolean PassedGo = false;
    CheckBox DidTheyPassGo;

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

    //the boolen for where on left or right Barge header

    static boolean BargeOnLeft = true;


    //all below this line is for the qr code screen

    Button GoBack;

    ImageView TheQrImage1;
    ImageView TheQrImage2;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hex_tech_view_model);
        SetUpMainScreen();
    }



    @SuppressLint({"SetTextI18n", "UseCompatLoadingForDrawables"})
    public void SetUpMainScreen(){
        //restes the memery of the hexagon

        Arrays.fill(IsCheckedInAuto, Boolean.FALSE);
        Arrays.fill(IsCheckedInTelop, Boolean.FALSE);



        // will probaly make caulder happy
        for (int i = 0; i < 36; i++) {
            @SuppressLint("DiscouragedApi") int resID = getResources().getIdentifier("checkBox" + i, "id", getPackageName());
            CheckBoxes[i] = findViewById(resID);
            CheckBoxes[i].setButtonTintList(ColorStateList.valueOf(getColor(medium_purple)));
        }

        for (int i = 0; i < CheckBoxes.length; i++) {
            int finalI = i;
            CheckBoxes[i].setOnClickListener(view -> {
                if (IsTelop.isChecked()){
                    IsCheckedInTelop[finalI] = CheckBoxes[finalI].isChecked();
                    Log.d("Hecagon checked", "buttion With id: " + finalI + "Was checked and set is checked in telop to " + CheckBoxes[finalI].isChecked());
                }else if (!IsTelop.isChecked()){
                    IsCheckedInAuto[finalI] = CheckBoxes[finalI].isChecked();
                    Log.d("Hecagon checked", "buttion With id: " + finalI + "Was checked and set is check in Auto to " + CheckBoxes[finalI].isChecked());
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

        BargeDec = findViewById(R.id.BargeDec);
        BargeInc = findViewById(R.id.BargeInc);
        BargePointsLabel = findViewById(R.id.BargePoints);
        BargeReferenceHeaderRight = findViewById(R.id.BargeReferenceHeaderRight);
        BargeReferenceHeaderLeft = findViewById(R.id.BargeReferenceHeaderLeft);

        BargeIsLeft = findViewById(R.id.BargeSwitcher);





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
        BargeIsLeft.setThumbTintList(ColorStateList.valueOf(getColor(R.color.dull_red)));
        boolean FilpFlop = false;
        for (int i = 0; i < CheckBoxes.length; i++) {
            if ((i+1)%3 == 0){
                CheckBoxes[i].setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_yellow)));
            } else if (FilpFlop) {
                FilpFlop = !FilpFlop;
                CheckBoxes[i].setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));
            }else{
                FilpFlop = !FilpFlop;
                CheckBoxes[i].setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_red)));
            }
        }




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


        //barge logic

        BargeReferenceHeaderRight.setBackgroundResource(R.color.white);
        BargeReferenceHeaderLeft.setBackgroundResource(R.color.dull_red);

        IsTelop.setThumbTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));


        BargeInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BargePoints++;
                BargePointsLabel.setText(String.valueOf(BargePoints));
            }
        });

        BargeIsLeft.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (BargeIsLeft.isChecked()){
                    BargeReferenceHeaderLeft.setBackgroundResource(R.color.white);
                    BargeReferenceHeaderRight.setBackgroundResource(R.color.dull_blue);
                    BargeIsLeft.setThumbTintList(ColorStateList.valueOf(getColor(R.color.dull_blue)));
                    BargeOnLeft = true;

                }else{
                    BargeReferenceHeaderRight.setBackgroundResource(R.color.white);
                    BargeReferenceHeaderLeft.setBackgroundResource(R.color.dull_red);
                    BargeIsLeft.setThumbTintList(ColorStateList.valueOf(getColor(R.color.dull_red)));
                    BargeOnLeft = false;

                }
            }
        });
        // TODO: was commented to complex
//        BargeReferenceHeaderRight.setOnClickListener(view -> {
//            if(isDullBlue && BargeIsLeft.isChecked()) {
//                BargeReferenceHeaderRight.setBackgroundResource(R.color.dull_red);
//                BargeReferenceHeaderLeft.setBackgroundResource(R.color.white);
//
//                isDullBlue = false;
//            } else if(BargeIsLeft.isChecked()) {
//                BargeReferenceHeaderRight.setBackgroundResource(R.color.dull_blue);
//                BargeReferenceHeaderLeft.setBackgroundResource(R.color.white);
//
//                isDullBlue = true;
//            }
//        });
//
//        BargeReferenceHeaderLeft.setOnClickListener(view -> {
//            if(isDullBlue && !BargeIsLeft.isChecked()) {
//                BargeReferenceHeaderLeft.setBackgroundResource(R.color.dull_red);
//                BargeReferenceHeaderRight.setBackgroundResource(R.color.white);
//                isDullBlue = false;
//            } else if(!BargeIsLeft.isChecked()){
//                BargeReferenceHeaderLeft.setBackgroundResource(R.color.dull_blue);
//                BargeReferenceHeaderRight.setBackgroundResource(R.color.white);
//                isDullBlue = true;
//            }
//        });

        //needs to be at the bottem this is also whare the Telop switch happens IsTelop
        IsTelop.setOnClickListener(view -> {
            if (IsTelop.isChecked()){
                ProsserPoints.setText(String.valueOf(TelopProsserPoints));
                NetPoints.setText(String.valueOf(TelopNetPoints));
                L1Points.setText(String.valueOf(TelopL1Points));
                TeleOpCheckText.setText("Tele-Op");
                //check box reset
                for(int i = 0; i < 36; i++) {
                    CheckBoxes[i].setChecked(IsCheckedInTelop[i]);
                }

                //color for auto
                L4Key.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_magenta)));
                L3Key.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_purple)));
                L2Key.setButtonTintList(ColorStateList.valueOf(getColor(R.color.medium_blue)));


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

        GoldenTeam = findViewById(R.id.checkBox);

        GoldenTeam.setOnClickListener(view -> {
            IsGoodTeam = GoldenTeam.isChecked();
        });

        //If the passed the starting line

        DidTheyPassGo = findViewById(R.id.PastStartingLineCheck);

        DidTheyPassGo.setOnClickListener(view -> {
            PassedGo = GoldenTeam.isChecked();
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
                Log.d("Set image 1", selectedItem1);
                TheQrImage2.setImageURI(uri2);
                Log.d("Set image 2", selectedItem2);


                // You can now use the selectedItem
                Log.d("Spinner", "Selected item: " + selectedItem1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Optional: Handle the case where no item is selected (e.g., if the spinner is reset)
            }
        });
    }
// checkBox + num + teleop
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
    }

}
