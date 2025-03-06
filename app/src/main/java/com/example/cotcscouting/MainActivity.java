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
    Button ProserDec, ProserInc, NetDec, NetInc, L1Dec, L1Inc,L2Dec, L2Inc,L3Dec, L3Inc,L4Dec, L4Inc;
    TextView ProsserPoints, NetPoints, L1Points,L2Points,L3Points,L4Points, BargePointsLabel, BargeReferenceHeaderRight, BargeReferenceHeaderLeft;

    static int TelopProsserPoints, AutopProsserPoints, TelopNetPoints, AutoNetPoints, TelopL1Points, TelopL2Points, TelopL3Points, TelopL4Points, AutoL1Points, AutoL2Points, AutoL3Points, AutoL4Points, BargePoints = 0;

    //Used for the golden check box
    static boolean IsGoodTeam = false;
    CheckBox GoldenTeam;

    //Used for if they passed start in auto
    static boolean PassedGo = false;
    CheckBox DidTheyPassGo;

    //for the drop down of parking

    Spinner ParkingPlaces;
    static String WhareParked = "Did Not Park";




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

        ProserDec  = findViewById(R.id.ProcessorDec);
        ProserInc = findViewById(R.id.ProcessorInc);
        ProsserPoints =  findViewById(R.id.ProcessorPoints);

        L1Dec = findViewById(R.id.L1CoralDec);
        L1Inc = findViewById(R.id.L1CoralInc);
        L1Points =findViewById(R.id.L1Points);

        L2Dec = findViewById(R.id.L2CoralDec);
        L2Inc = findViewById(R.id.L2CoralInc);
        L2Points = findViewById(R.id.L2Points);

        L3Dec = findViewById(R.id.L3CoralDec);
        L3Inc = findViewById(R.id.L3CoralInc);
        L3Points =findViewById(R.id.L3Points);

        L4Dec = findViewById(R.id.L4CoralDec);
        L4Inc = findViewById(R.id.L4CoralInc);
        L4Points =findViewById(R.id.L4Points);

        NetDec = findViewById(R.id.NetDec);
        NetInc = findViewById(R.id.NetInc);
        NetPoints = findViewById(R.id.NetPoints);

        //cheks telop
        IsTelop = findViewById(R.id.teleOpCheck);
        TeleOpCheckText = findViewById(R.id.teleOpCheckText);
        //check box listeners

        ProsserPoints = findViewById(R.id.ProcessorPoints);
        ProsserPoints.setText("0");

        NetPoints.setText("0");



        L1Points.setText("0");

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



        // For l1

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

        // For l2

        L2Inc.setOnClickListener(view -> {
            if (IsTelop.isChecked()){
                TelopL2Points++;
                L2Points.setText(String.valueOf(TelopL2Points));
            } else if (!IsTelop.isChecked()) {
                AutoL2Points++;
                L2Points.setText(String.valueOf(AutoL2Points));
            }
        });

        L2Dec.setOnClickListener(view -> {
            if (IsTelop.isChecked() && TelopL2Points > 0){
                TelopL2Points--;
                L2Points.setText(String.valueOf(TelopL2Points));
            } else if (!IsTelop.isChecked() && AutoL2Points > 0) {
                AutoL2Points--;
                L2Points.setText(String.valueOf(AutoL2Points));
            }
        });

        // For L3

        L3Inc.setOnClickListener(view -> {
            if (IsTelop.isChecked()){
                TelopL3Points++;
                L3Points.setText(String.valueOf(TelopL3Points));
            } else if (!IsTelop.isChecked()) {
                AutoL3Points++;
                L3Points.setText(String.valueOf(AutoL3Points));
            }
        });

        L3Dec.setOnClickListener(view -> {
            if (IsTelop.isChecked() && TelopL3Points > 0){
                TelopL3Points--;
                L3Points.setText(String.valueOf(TelopL3Points));
            } else if (!IsTelop.isChecked() && AutoL3Points > 0) {
                AutoL3Points--;
                L3Points.setText(String.valueOf(AutoL3Points));
            }
        });

        // For L4

        L4Inc.setOnClickListener(view -> {
            if (IsTelop.isChecked()){
                TelopL4Points++;
                L4Points.setText(String.valueOf(TelopL4Points));
            } else if (!IsTelop.isChecked()) {
                AutoL4Points++;
                L4Points.setText(String.valueOf(AutoL4Points));
            }
        });

        L4Dec.setOnClickListener(view -> {
            if (IsTelop.isChecked() && TelopL4Points > 0){
                TelopL4Points--;
                L4Points.setText(String.valueOf(TelopL4Points));
            } else if (!IsTelop.isChecked() && AutoL4Points > 0) {
                AutoL4Points--;
                L4Points.setText(String.valueOf(AutoL4Points));
            }
        });

        IsTelop.setThumbTintList(ColorStateList.valueOf(getColor(R.color.medium_orange)));

        //needs to be at the bottem this is also whare the Telop switch happens IsTelop
        IsTelop.setOnClickListener(view -> {
            if (IsTelop.isChecked()){
                ProsserPoints.setText(String.valueOf(TelopProsserPoints));
                NetPoints.setText(String.valueOf(TelopNetPoints));
                L1Points.setText(String.valueOf(TelopL1Points));
                L2Points.setText(String.valueOf(TelopL2Points));
                L3Points.setText(String.valueOf(TelopL3Points));
                L4Points.setText(String.valueOf(TelopL4Points));
                TeleOpCheckText.setText("Tele-Op");

                //color extras
                if(true) {
                    //colors L1
                    L1Dec.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.gray)));
                    L1Inc.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.gray)));

                    //colors L2
                    L2Dec.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.gray)));
                    L2Inc.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.gray)));

                    //colors L3
                    L3Dec.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.gray)));
                    L3Inc.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.gray)));

                    //colors L4
                    L4Dec.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.gray)));
                    L4Inc.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.gray)));

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
                L2Points.setText(String.valueOf(AutoL2Points));
                L3Points.setText(String.valueOf(AutoL3Points));
                L4Points.setText(String.valueOf(AutoL4Points));

                TeleOpCheckText.setText("Auto");



                //color extras
                if(true) {
                    //colors L1
                    L1Dec.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.black)));
                    L1Inc.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.black)));
                    //colors L2
                    L2Dec.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.black)));
                    L2Inc.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.black)));
                    //colors L3
                    L3Dec.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.black)));
                    L3Inc.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.black)));
                    //colors L4
                    L4Dec.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.black)));
                    L4Inc.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.black)));
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

        Submit.setOnClickListener(view -> new CreateCSV().GenerateCs(this,MainActivity.this));

        //go to the qr code screen
        GoToQrCode = findViewById(R.id.jerry);
        GoToQrCode.setOnClickListener(view -> {
            setContentView(R.layout.show_the_codes);
            SetUpQrCodes();
        });

        //is good team / golden team

        GoldenTeam = findViewById(R.id.checkBox);

        GoldenTeam.setOnClickListener(view -> IsGoodTeam = GoldenTeam.isChecked());

        //If the passed the starting line

        DidTheyPassGo = findViewById(R.id.PastStartingLineCheck);

        DidTheyPassGo.setOnClickListener(view -> PassedGo = GoldenTeam.isChecked());
    }

    public void SetUpQrCodes(){
        GoBack = findViewById(R.id.Goback);
        GoBack.setOnClickListener(view -> {
            setContentView(R.layout.hex_tech_view_model);
            RestMem();
            SetUpMainScreen();
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
        TelopL2Points = 0;
        AutoL2Points = 0;
        TelopL3Points = 0;
        AutoL3Points = 0;
        TelopL4Points = 0;
        AutoL4Points = 0;
        BargePoints = 0;

    }

}
