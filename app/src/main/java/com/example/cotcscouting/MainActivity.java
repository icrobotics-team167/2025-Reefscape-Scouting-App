package com.example.cotcscouting;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    //Prosser Points
    int TelopProsserPoints = 0;
    int AutopProsserPoints = 0;

    //Net Points

    int TelopNetPoints = 0;
    int AutoNetPoints = 0;

    //L1 Points

    int TelopL1Points = 0;
    int AutoL1Points = 0;

    //Barge
    int BargePoints = 0;
    //forthe drop down

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hex_tech_view_model);

        CheckBox IsTelop = findViewById(R.id.teleOpCheck);


        //Prosser Junk
        Button ProserDec = findViewById(R.id.ProcessorDec);
        Button ProserInc = findViewById(R.id.ProcessorInc);
        TextView ProsserPoints =  findViewById(R.id.ProcessorPoints);

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

        //Net
        Button NetDec = findViewById(R.id.NetDec);
        Button NetInc = findViewById(R.id.NetInc);
        TextView NetPoints = findViewById(R.id.NetPoints);

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
        Button L1Dec = findViewById(R.id.L1CoralDec);
        Button L1Inc = findViewById(R.id.L1CoralInc);
        TextView L1Points = findViewById(R.id.L1Points);

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

        //barge

        Button BargeInc = findViewById(R.id.BargeInc);
        Button BargeDec = findViewById(R.id.BargeDec);
        TextView BargePointsLabel = findViewById(R.id.BargePoints);

        BargeInc.setOnClickListener(view -> {
            BargePoints++;
            BargePointsLabel.setText(String.valueOf(BargePoints));
        });

        BargeDec.setOnClickListener(view -> {
            if (BargePoints > 0){
                BargePoints--;
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

        //drop down

        Spinner ParkingPlaces = findViewById(R.id.parkDropDown);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.planets_array,
                android.R.layout.simple_spinner_item //

        );

        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        ParkingPlaces.setAdapter(adapter);

        //Submit Buttion

        Button Submit = findViewById(R.id.SubmitButtion);

        Submit.setOnClickListener(view -> {
            //creates file needs to be save the data am lazy
            //TODO: add fix and make work

            EditText scoutNameEditText = findViewById(R.id.scout_name);
            EditText match_number = findViewById(R.id.match_number);
            EditText team_number = findViewById(R.id.team_number);
            String FileName = scoutNameEditText.getText().toString() + "," + match_number.getText().toString() + "," + team_number.getText().toString();

            JavaData.writeFileOnInternalStorage(MainActivity.this, FileName, "");

            
        });
    }


}
