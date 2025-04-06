package com.example.scoutingappv3.LoadScreens;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.AndroidException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scoutingappv3.Dependences.Config;
import com.example.scoutingappv3.Dependences.CreateCSVFiles.CsvBuilder;
import com.example.scoutingappv3.Dependences.MatchReader.MatchReader;
import com.example.scoutingappv3.Main;
import com.example.scoutingappv3.R;
import com.google.android.material.snackbar.Snackbar;

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
    Button SignOutButton;

    Button SkipButton;

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
    TextView ScoutNamePlaceholderText;
    TextView TeamNumberPlaceholderText;
    TextView MatchNumberPlaceholderText;

    //For confermation
    Snackbar SubmitConfermation;

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


    @SuppressLint("SetTextI18n")
    public void LoadDataScreen(Main main){
        main.setContentView(R.layout.data_entry_layout_v3);

        SubmitConfermation = Snackbar.make(main.findViewById(android.R.id.content), "Are you sure you want to submit?", Snackbar.LENGTH_LONG);

        //l4 Coral Auto
        L4CoralDecButtonAuto = main.findViewById(R.id.L4CoralDecButtonAuto);
        L4CoralIncButtonAuto = main.findViewById(R.id.L4CoralIncButtonAuto);
        L4CoralValueAutoView = main.findViewById(R.id.L4CoralValueAuto);

        //l3 Coral Auto
        L3CoralDecButtonAuto = main.findViewById(R.id.L3CoralDecButtonAuto);
        L3CoralIncButtonAuto = main.findViewById(R.id.L3CoralIncButtonAuto);
        L3CoralValueAutoView = main.findViewById(R.id.L3CoralValueAuto);

        //l2 Coral Auto
        L2CoralDecButtonAuto = main.findViewById(R.id.L2CoralDecButtonAuto);
        L2CoralIncButtonAuto = main.findViewById(R.id.L2CoralIncButtonAuto);
        L2CoralValueAutoView = main.findViewById(R.id.L2CoralValueAuto);

        //l1 Coral Auto
        L1CoralDecButtonAuto = main.findViewById(R.id.L1CoralDecButtonAuto);
        L1CoralIncButtonAuto = main.findViewById(R.id.L1CoralIncButtonAuto);
        L1CoralValueAutoView = main.findViewById(R.id.L1CoralValueAuto);

        //Droped coral in auto
        DroppedCoralDecButtonAuto = main.findViewById(R.id.DroppedCoralDecButtonAuto);
        DroppedCoralIncButtonAuto = main.findViewById(R.id.DroppedCoralIncButtonAuto);
        DroppedCoralValueAutoView = main.findViewById(R.id.DroppedCoralValueAuto);

        //l4 Coral Teleop
        L4CoralDecButtonTeleop = main.findViewById(R.id.L4CoralDecButtonTeleop);
        L4CoralIncButtonTeleop = main.findViewById(R.id.L4CoralIncButtonTeleop);
        L4CoralValueTeleopView = main.findViewById(R.id.L4CoralValueTeleop);

        // L3 Coral Teleop
        L3CoralDecButtonTeleop = main.findViewById(R.id.L3CoralDecButtonTeleop);
        L3CoralIncButtonTeleop = main.findViewById(R.id.L3CoralIncButtonTeleop);
        L3CoralValueTeleopView = main.findViewById(R.id.L3CoralValueTeleop);

        // L2 Coral Teleop
        L2CoralDecButtonTeleop = main.findViewById(R.id.L2CoralDecButtonTeleop);
        L2CoralIncButtonTeleop = main.findViewById(R.id.L2CoralIncButtonTeleop);
        L2CoralValueTeleopView = main.findViewById(R.id.L2CoralValueTeleop);

        // L1 Coral Teleop
        L1CoralDecButtonTeleop = main.findViewById(R.id.L1CoralDecButtonTeleop);
        L1CoralIncButtonTeleop = main.findViewById(R.id.L1CoralIncButtonTeleop);
        L1CoralValueTeleopView = main.findViewById(R.id.L1CoralValueTeleop);

        //Droped coral in auto
        DroppedCoralDecButtonTeleop = main.findViewById(R.id.DroppedCoralDecButtonTeleop);
        DroppedCoralIncButtonTeleop = main.findViewById(R.id.DroppedCoralIncButtonTeleop);
        DroppedCoralValueTeleopView = main.findViewById(R.id.DroppedCoralValueTeleop);

        //Prosser
        ProcessorAlgaeDecButton = main.findViewById(R.id.ProcessorAlgaeDecButton);
        ProcessorAlgaeIncButton = main.findViewById(R.id.ProcessorAlgaeIncButton);
        ProcessorAlgaeValue = main.findViewById(R.id.ProcessorAlgaeValue);

        //Barge
        BargeAlgaeDecButton = main.findViewById(R.id.BargeAlgaeDecButton);
        BargeAlgaeIncButton = main.findViewById(R.id.BargeAlgaeIncButton);
        BargeAlgaeValue = main.findViewById(R.id.BargeAlgaeValue);

        //Dereef
        DereefedAlgaeDecButton = main.findViewById(R.id.DereefedAlgaeDecButton);
        DereefedAlgaeIncButton = main.findViewById(R.id.DereefedAlgaeIncButton);
        DereefedAlgaeValue = main.findViewById(R.id.DereefedAlgaeValue);

        //Net Missed Alge
        NetMissedAlgaeDecButton = main.findViewById(R.id.NetMissedAlgaeDecButton);
        NetMissedAlgaeIncButton = main.findViewById(R.id.NetMissedAlgaeIncButton);
        NetMissedAlgaeValue = main.findViewById(R.id.NetMissedAlgaeValue);

        //Notes
        Notes = main.findViewById(R.id.NotesTextBox);

        //Submit Button
        SubmitButton = main.findViewById(R.id.SubmitButton);
        //Logout Buttion
        SignOutButton = main.findViewById(R.id.SignOutButton);

        SkipButton = main.findViewById(R.id.SkipButton);

        //played Defense
        PlayedDefense = main.findViewById(R.id.DefenseCheckBox);

        //Moved past go
        MoveCheckBox = main.findViewById(R.id.MoveCheckBox);

        ScoutNamePlaceholderText = main.findViewById(R.id.ScoutNamePlaceholderText);
        TeamNumberPlaceholderText = main.findViewById(R.id.TeamNumberPlaceholderText);
        MatchNumberPlaceholderText = main.findViewById(R.id.MatchNumberPlaceholderText);

        //to start with a clean slate
        resetData();



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

        SubmitConfermation.setAction("Yes (Swipe Down To Ignore)", v -> {
            Config.MatchNumber++;
            MatchNumberPlaceholderText.setText("Match " + Config.MatchNumber);
            Config.TeamNumber = MatchReader.getValueFromFile(Config.MatchNumber,Config.BotTracked);
            TeamNumberPlaceholderText.setText("Track " + MatchReader.getValueFromFile(Config.MatchNumber,Config.BotTracked));


            CsvBuilder.BuildCsv(this);
            resetData();
            Toast.makeText(Config.AppContext,"Saving Data",Toast.LENGTH_LONG).show();
        });

        //Submit Buttion;
        SubmitButton.setOnClickListener(v -> {
            SubmitConfermation.show();
        });

        //SignOutButton Buttion
        SignOutButton.setOnClickListener(v -> {
            main.SettingsLoader.LoadSettingsPage(main);
        });

        SkipButton.setOnClickListener(v -> {
            Config.MatchNumber++;
            MatchNumberPlaceholderText.setText("Match " + Config.MatchNumber);
            Config.TeamNumber = MatchReader.getValueFromFile(Config.MatchNumber,Config.BotTracked);
            TeamNumberPlaceholderText.setText("Track " + MatchReader.getValueFromFile(Config.MatchNumber,Config.BotTracked));

        });

        ScoutNamePlaceholderText.setText("Hello " + Config.UserName + "!");
        TeamNumberPlaceholderText.setText("Track " + MatchReader.getValueFromFile(Config.MatchNumber,Config.BotTracked));
        MatchNumberPlaceholderText.setText("Match " + Config.MatchNumber);


    }

    // Method to reset all values and text views to their initial state
    public void resetData() {
        // Reset all integer values
        L4CoralValueAuto = 0;
        L3CoralValueAuto = 0;
        L2CoralValueAuto = 0;
        L1CoralValueAuto = 0;
        DroppedCoralAuto = 0;

        L4CoralValueTeleop = 0;
        L3CoralValueTeleop = 0;
        L2CoralValueTeleop = 0;
        L1CoralValueTeleop = 0;
        DroppedCoralTeleop = 0;
        ProsserScored = 0;
        BargeScored = 0;
        DereefedAlgae = 0;
        NetMissedAlgae = 0;

        // Reset all text views to reflect the reset values
        L4CoralValueAutoView.setText("0");
        L3CoralValueAutoView.setText("0");
        L2CoralValueAutoView.setText("0");
        L1CoralValueAutoView.setText("0");
        DroppedCoralValueAutoView.setText("0");

        L4CoralValueTeleopView.setText("0");
        L3CoralValueTeleopView.setText("0");
        L2CoralValueTeleopView.setText("0");
        L1CoralValueTeleopView.setText("0");
        DroppedCoralValueTeleopView.setText("0");

        ProcessorAlgaeValue.setText("0");
        BargeAlgaeValue.setText("0");
        DereefedAlgaeValue.setText("0");
        NetMissedAlgaeValue.setText("0");

        // Reset any other relevant values
        Notes.setText(""); // Clear the notes input
        PlayedDefense.setChecked(false); // Uncheck the defense checkbox
        MoveCheckBox.setChecked(false); // Uncheck the move checkbox

        // Optionally, reset placeholder texts if needed
        ScoutNamePlaceholderText.setText("Hello " + Config.UserName + "!");
        TeamNumberPlaceholderText.setText("Track " + MatchReader.getValueFromFile(Config.MatchNumber,Config.BotTracked));
        MatchNumberPlaceholderText.setText("Match " + Config.MatchNumber);
    }

}
