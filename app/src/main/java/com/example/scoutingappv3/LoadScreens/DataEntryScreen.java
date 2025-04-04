package com.example.scoutingappv3.LoadScreens;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.scoutingappv3.Dependences.CreateCSVFiles.CsvBuilder;
import com.example.scoutingappv3.R;

public class DataEntryScreen {
    Button L4CoralDecButtonAuto;
    Button L4CoralIncButtonAuto;
    Button L3CoralDecButtonAuto;
    Button L3CoralIncButtonAuto;
    Button L2CoralDecButtonAuto;
    Button L2CoralIncButtonAuto;
    Button L1CoralDecButtonAuto;
    Button L1CoralIncButtonAuto;
    Button DroppedCoralDecButtonAuto;
    Button DroppedCoralIncButtonAuto;


    // Teleop buttons
    Button L4CoralDecButtonTeleop;
    Button L4CoralIncButtonTeleop;
    Button L3CoralDecButtonTeleop;
    Button L3CoralIncButtonTeleop;
    Button L2CoralDecButtonTeleop;
    Button L2CoralIncButtonTeleop;
    Button L1CoralDecButtonTeleop;
    Button L1CoralIncButtonTeleop;
    Button DroppedCoralDecButtonTeleop;
    Button DroppedCoralIncButtonTeleop;
    Button ProcessorAlgaeDecButton;
    Button ProcessorAlgaeIncButton;
    Button BargeAlgaeDecButton;
    Button BargeAlgaeIncButton;
    Button DereefedAlgaeDecButton;
    Button DereefedAlgaeIncButton;
    Button NetMissedAlgaeDecButton;
    Button NetMissedAlgaeIncButton;
    Button SubmitButton;

    //Check box
    public CheckBox PlayedDefense;
    public CheckBox MoveCheckBox;

    // Point Views
    TextView L4CoralValueAutoView;
    TextView L3CoralValueAutoView;
    TextView L2CoralValueAutoView;
    TextView L1CoralValueAutoView;
    TextView DroppedCoralValueAutoView;
    TextView L4CoralValueTeleopView;
    TextView L3CoralValueTeleopView;
    TextView L2CoralValueTeleopView;
    TextView L1CoralValueTeleopView;
    TextView DroppedCoralValueTeleopView;
    TextView ProcessorAlgaeValue;
    TextView BargeAlgaeValue;
    TextView DereefedAlgaeValue;
    TextView NetMissedAlgaeValue;

    //int vals

    public int L4CoralValueAuto = 0;
    public int L3CoralValueAuto = 0;
    public int L2CoralValueAuto = 0;
    public int L1CoralValueAuto = 0;

    public int DroppedCoralAuto = 0;

    public int L4CoralValueTeleop = 0;
    public int L3CoralValueTeleop = 0;
    public int L2CoralValueTeleop = 0;
    public int L1CoralValueTeleop = 0;
    public int DroppedCoralTeleop = 0;
    public int ProsserScored = 0;
    public int BargeScored = 0;
    public int DereefedAlgae = 0;
    public int NetMissedAlgae = 0;

    //Notes
    public EditText Notes;





    Activity LocalActivity;


    public void LoadDataScreen(Activity AppActivity){

        AppActivity.setContentView(R.layout.data_entry_layout_v3);


        //l4 Coral Auto
        L4CoralDecButtonAuto = AppActivity.findViewById(R.id.L4CoralDecButtonAuto);
        L4CoralIncButtonAuto = AppActivity.findViewById(R.id.L4CoralIncButtonAuto);
        L4CoralValueAutoView = AppActivity.findViewById(R.id.L4CoralValueAuto);

        //l3 Coral Auto
        L3CoralDecButtonAuto = AppActivity.findViewById(R.id.L3CoralDecButtonAuto);
        L3CoralIncButtonAuto = AppActivity.findViewById(R.id.L3CoralIncButtonAuto);
        L3CoralValueAutoView = AppActivity.findViewById(R.id.L3CoralValueAuto);

        //l2 Coral Auto
        L2CoralDecButtonAuto = AppActivity.findViewById(R.id.L2CoralDecButtonAuto);
        L2CoralIncButtonAuto = AppActivity.findViewById(R.id.L2CoralIncButtonAuto);
        L2CoralValueAutoView = AppActivity.findViewById(R.id.L2CoralValueAuto);

        //l1 Coral Auto
        L1CoralDecButtonAuto = AppActivity.findViewById(R.id.L1CoralDecButtonAuto);
        L1CoralIncButtonAuto = AppActivity.findViewById(R.id.L1CoralIncButtonAuto);
        L1CoralValueAutoView = AppActivity.findViewById(R.id.L1CoralValueAuto);

        //Droped coral in auto
        DroppedCoralDecButtonAuto = AppActivity.findViewById(R.id.DroppedCoralDecButtonAuto);
        DroppedCoralIncButtonAuto = AppActivity.findViewById(R.id.DroppedCoralIncButtonAuto);
        DroppedCoralValueAutoView = AppActivity.findViewById(R.id.DroppedCoralValueAuto);

        //l4 Coral Teleop
        L4CoralDecButtonTeleop = AppActivity.findViewById(R.id.L4CoralDecButtonTeleop);
        L4CoralIncButtonTeleop = AppActivity.findViewById(R.id.L4CoralIncButtonTeleop);
        L4CoralValueTeleopView = AppActivity.findViewById(R.id.L4CoralValueTeleop);

        // L3 Coral Teleop
        L3CoralDecButtonTeleop = AppActivity.findViewById(R.id.L3CoralDecButtonTeleop);
        L3CoralIncButtonTeleop = AppActivity.findViewById(R.id.L3CoralIncButtonTeleop);
        L3CoralValueTeleopView = AppActivity.findViewById(R.id.L3CoralValueTeleop);

        // L2 Coral Teleop
        L2CoralDecButtonTeleop = AppActivity.findViewById(R.id.L2CoralDecButtonTeleop);
        L2CoralIncButtonTeleop = AppActivity.findViewById(R.id.L2CoralIncButtonTeleop);
        L2CoralValueTeleopView = AppActivity.findViewById(R.id.L2CoralValueTeleop);

        // L1 Coral Teleop
        L1CoralDecButtonTeleop = AppActivity.findViewById(R.id.L1CoralDecButtonTeleop);
        L1CoralIncButtonTeleop = AppActivity.findViewById(R.id.L1CoralIncButtonTeleop);
        L1CoralValueTeleopView = AppActivity.findViewById(R.id.L1CoralValueTeleop);

        //Droped coral in auto
        DroppedCoralDecButtonTeleop = AppActivity.findViewById(R.id.DroppedCoralDecButtonTeleop);
        DroppedCoralIncButtonTeleop = AppActivity.findViewById(R.id.DroppedCoralIncButtonTeleop);
        DroppedCoralValueTeleopView = AppActivity.findViewById(R.id.DroppedCoralValueTeleop);

        //Prosser
        ProcessorAlgaeDecButton = AppActivity.findViewById(R.id.ProcessorAlgaeDecButton);
        ProcessorAlgaeIncButton = AppActivity.findViewById(R.id.ProcessorAlgaeIncButton);
        ProcessorAlgaeValue = AppActivity.findViewById(R.id.ProcessorAlgaeValue);

        //Barge
        BargeAlgaeDecButton = AppActivity.findViewById(R.id.BargeAlgaeDecButton);
        BargeAlgaeIncButton = AppActivity.findViewById(R.id.BargeAlgaeIncButton);
        BargeAlgaeValue = AppActivity.findViewById(R.id.BargeAlgaeValue);

        //Dereef
        DereefedAlgaeDecButton = AppActivity.findViewById(R.id.DereefedAlgaeDecButton);
        DereefedAlgaeIncButton = AppActivity.findViewById(R.id.DereefedAlgaeIncButton);
        DereefedAlgaeValue = AppActivity.findViewById(R.id.DereefedAlgaeValue);

        //Net Missed Alge
        NetMissedAlgaeDecButton = AppActivity.findViewById(R.id.NetMissedAlgaeDecButton);
        NetMissedAlgaeIncButton = AppActivity.findViewById(R.id.NetMissedAlgaeIncButton);
        NetMissedAlgaeValue = AppActivity.findViewById(R.id.NetMissedAlgaeValue);

        //Notes
        Notes = AppActivity.findViewById(R.id.NotesTextBox);

        //Submit Button
        SubmitButton = AppActivity.findViewById(R.id.SubmitButton);

        //played Defense
        PlayedDefense = AppActivity.findViewById(R.id.DefenseCheckBox);

        //Moved past go
        MoveCheckBox = AppActivity.findViewById(R.id.MoveCheckBox);


        //Start of Auto
        //L4 Coral Auto
        L4CoralDecButtonAuto.setOnClickListener(v -> {
            if (L4CoralValueAuto > 0) {
                L4CoralValueAuto--;
                L4CoralValueAutoView.setText(L4CoralValueAuto + "");
            }
        });

        L4CoralIncButtonAuto.setOnClickListener(v -> {
            L4CoralValueAuto++;
            L4CoralValueAutoView.setText(L4CoralValueAuto + "");
        });

        //L3 Coral Auto
        L3CoralDecButtonAuto.setOnClickListener(v -> {
            if (L3CoralValueAuto > 0) {
                L3CoralValueAuto--;
                L3CoralValueAutoView.setText(L3CoralValueAuto + "");
            }
        });

        L3CoralIncButtonAuto.setOnClickListener(v -> {
            L3CoralValueAuto++;
            L3CoralValueAutoView.setText(L3CoralValueAuto + "");
        });

        //L2 Coral Auto
        L2CoralDecButtonAuto.setOnClickListener(v -> {
            if (L2CoralValueAuto > 0) {
                L2CoralValueAuto--;
                L2CoralValueAutoView.setText(L2CoralValueAuto + "");
            }
        });

        L2CoralIncButtonAuto.setOnClickListener(v -> {
            L2CoralValueAuto++;
            L2CoralValueAutoView.setText(L2CoralValueAuto + "");
        });

        //L1 Coral Auto
        L1CoralDecButtonAuto.setOnClickListener(v -> {
            if (L1CoralValueAuto > 0) {
                L1CoralValueAuto--;
                L1CoralValueAutoView.setText(L1CoralValueAuto + "");
            }
        });

        L1CoralIncButtonAuto.setOnClickListener(v -> {
            L1CoralValueAuto++;
            L1CoralValueAutoView.setText(L1CoralValueAuto + "");
        });

        //Dropped Coral Auto
        DroppedCoralDecButtonAuto.setOnClickListener(v -> {
            if (DroppedCoralAuto > 0) {
                DroppedCoralAuto--;
                DroppedCoralValueAutoView.setText(DroppedCoralAuto + "");
            }
        });

        DroppedCoralIncButtonAuto.setOnClickListener(v -> {
            DroppedCoralAuto++;
            DroppedCoralValueAutoView.setText(DroppedCoralAuto + "");
        });

        //Start of Teleop
        //L4 Coral TTeleop
        L4CoralDecButtonTeleop.setOnClickListener(v -> {
            if (L4CoralValueTeleop > 0) {
                L4CoralValueTeleop--;
                L4CoralValueTeleopView.setText(L4CoralValueTeleop + "");
            }
        });

        L4CoralIncButtonTeleop.setOnClickListener(v -> {
            L4CoralValueTeleop++;
            L4CoralValueTeleopView.setText(L4CoralValueTeleop + "");
        });

        L3CoralDecButtonTeleop.setOnClickListener(v -> {
            if (L3CoralValueTeleop > 0) {
                L3CoralValueTeleop--;
                L3CoralValueTeleopView.setText(L3CoralValueTeleop + "");
            }
        });

        L3CoralIncButtonTeleop.setOnClickListener(v -> {
            L3CoralValueTeleop++;
            L3CoralValueTeleopView.setText(L3CoralValueTeleop + "");
        });

        L2CoralDecButtonTeleop.setOnClickListener(v -> {
            if (L2CoralValueTeleop > 0) {
                L2CoralValueTeleop--;
                L2CoralValueTeleopView.setText(L2CoralValueTeleop + "");
            }
        });

        L2CoralIncButtonTeleop.setOnClickListener(v -> {
            L2CoralValueTeleop++;
            L2CoralValueTeleopView.setText(L2CoralValueTeleop + "");
        });

        L1CoralDecButtonTeleop.setOnClickListener(v -> {
            if (L1CoralValueTeleop > 0) {
                L1CoralValueTeleop--;
                L1CoralValueTeleopView.setText(L1CoralValueTeleop + "");
            }
        });

        L1CoralIncButtonTeleop.setOnClickListener(v -> {
            L1CoralValueTeleop++;
            L1CoralValueTeleopView.setText(L1CoralValueTeleop + "");
        });

        //Dropped Coral Teleop
        DroppedCoralDecButtonTeleop.setOnClickListener(v -> {
            if (DroppedCoralTeleop > 0) {
                DroppedCoralTeleop--;
                DroppedCoralValueTeleopView.setText(DroppedCoralTeleop + "");
            }
        });

        DroppedCoralIncButtonTeleop.setOnClickListener(v -> {
            DroppedCoralTeleop++;
            DroppedCoralValueTeleopView.setText(DroppedCoralTeleop + "");
        });

        //prosser
        ProcessorAlgaeDecButton.setOnClickListener(v -> {
            if (ProsserScored > 0) {
                ProsserScored--;
                ProcessorAlgaeValue.setText(ProsserScored + "");
            }
        });

        ProcessorAlgaeIncButton.setOnClickListener(v -> {
            ProsserScored++;
            ProcessorAlgaeValue.setText(ProsserScored + "");
        });

        //Barge
        BargeAlgaeDecButton.setOnClickListener(v -> {
            if (BargeScored > 0) {
                BargeScored--;
                BargeAlgaeValue.setText(BargeScored + "");
            }
        });

        BargeAlgaeIncButton.setOnClickListener(v -> {
            BargeScored++;
            BargeAlgaeValue.setText(BargeScored + "");
        });

        //Barge
        DereefedAlgaeDecButton.setOnClickListener(v -> {
            if (DereefedAlgae > 0) {
                DereefedAlgae--;
                DereefedAlgaeValue.setText(DereefedAlgae + "");
            }
        });

        DereefedAlgaeIncButton.setOnClickListener(v -> {
            DereefedAlgae++;
            DereefedAlgaeValue.setText(DereefedAlgae + "");
        });

        //Net missed alge
        NetMissedAlgaeDecButton.setOnClickListener(v -> {
            if (NetMissedAlgae > 0) {
                NetMissedAlgae--;
                NetMissedAlgaeValue.setText(NetMissedAlgae + "");
            }
        });

        NetMissedAlgaeIncButton.setOnClickListener(v -> {
            NetMissedAlgae++;
            NetMissedAlgaeValue.setText(NetMissedAlgae + "");
        });

        //Submit Buttion;
        SubmitButton.setOnClickListener(v -> {
            CsvBuilder.BuildCsv(this);
        });

    }
}
