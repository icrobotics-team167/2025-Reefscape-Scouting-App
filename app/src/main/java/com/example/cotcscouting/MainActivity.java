package com.example.cotcscouting;

import android.content.Context;
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
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cotcscouting.data.model.QRCodeUtils;

import java.io.File;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    //all below this line is for the data entry
    //Prosser
    int TelopProsserPoints = 0;
    int AutopProsserPoints = 0;
    Button ProserDec;
    Button ProserInc;
    TextView ProsserPoints;

    //Net Points
    int TelopNetPoints = 0;
    int AutoNetPoints = 0;
    Button NetDec;
    Button NetInc;
    TextView NetPoints;

    //L1
    int TelopL1Points = 0;
    int AutoL1Points = 0;
    Button L1Dec;
    Button L1Inc;
    TextView L1Points;

    //Barge
    int BargePoints = 0;
    Button BargeInc;
    Button BargeDec;
    TextView BargePointsLabel;

    //forthe drop down
    Spinner ParkingPlaces;

    //Keeps Tack of what page it is
    boolean IsMain = true;

    //is checked
    CheckBox IsTelop;

    //submit
    Button Submit;

    //The Qr Code Screen
    Button GoToQrCode;


    //all below this line is for the qr code screen

    Button GoBack;
    Spinner QrCodes;

    ImageView TheQrImage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hex_tech_view_model);

        SetUpMainScreen();

    }

    public void SetUpMainScreen(){

        //cheks telop
        IsTelop = findViewById(R.id.teleOpCheck);

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
                ProsserPoints.setText(String.valueOf(TelopNetPoints));
            } else if (!IsTelop.isChecked() && AutoNetPoints > 0) {
                AutoNetPoints--;
                NetPoints.setText(String.valueOf(AutoNetPoints));
            }
        });

        //L1
        L1Dec = findViewById(R.id.L1CoralDec);
        L1Inc = findViewById(R.id.L1CoralInc);
        L1Points = findViewById(R.id.L1Text);

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
        BargePointsLabel = findViewById(R.id.BargeText);

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

        //needs to be at the bottem this is also whare the Telop switch happens IsTelop
        IsTelop.setOnClickListener(view -> {
            if (IsTelop.isChecked()){
                ProsserPoints.setText(String.valueOf(TelopProsserPoints));
                NetPoints.setText(String.valueOf(TelopNetPoints));
                L1Points.setText(String.valueOf(TelopL1Points));
            }else{
                ProsserPoints.setText(String.valueOf(AutopProsserPoints));
                NetPoints.setText(String.valueOf(AutoNetPoints));
                L1Points.setText(String.valueOf(AutoL1Points));
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
            //creates file needs to be save the data am lazy
            //TODO: add fix and make work

            EditText scoutNameEditText = findViewById(R.id.scout_name);
            EditText match_number = findViewById(R.id.match_number);
            EditText team_number = findViewById(R.id.team_number);
            String FileName = scoutNameEditText.getText().toString() + "," + match_number.getText().toString() + "," + team_number.getText().toString();

            QRCodeUtils.generateAndSaveQRCode(MainActivity.this,"skibbdi1");

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

}
