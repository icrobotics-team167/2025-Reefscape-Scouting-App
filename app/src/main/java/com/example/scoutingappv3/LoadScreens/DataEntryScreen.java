package com.example.scoutingappv3.LoadScreens;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

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
    Button BargeAlgaeDecButtonAuto;
    Button BargeAlgaeIncButtonAuto;


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
    Button ProcessorAlgaeIncButtonAuto;
    Button BargeAlgaeDecButtonTeleop;
    Button BargeAlgaeIncButtonTeleop;
    Button ProcessorAlgaeDecButtonTeleop;
    Button ProcessorAlgaeIncButtonTeleop;
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
    TextView BargeAlgaeValueAuto;
    TextView L4CoralValueTeleopView;
    TextView L3CoralValueTeleopView;
    TextView L2CoralValueTeleopView;
    TextView L1CoralValueTeleopView;
    TextView ProcessorAlgaeValueAuto;
    TextView BargeAlgaeValueTeleop;
    TextView ProcessorAlgaeValueTeleop;
    TextView ScoutNamePlaceholderText;
    TextView TeamNumberPlaceholderText;
    TextView MatchNumberPlaceholderText;

    //For confermation
    Snackbar SubmitConfermation;
    Snackbar SkipConfermation;


    public RatingBar DriverRating;
    //int vals

    public int L4CoralValueAuto = 0;
    public int L3CoralValueAuto = 0;
    public int L2CoralValueAuto = 0;
    public int L1CoralValueAuto = 0;

    public int BargeScoredInAuto = 0;

    public int L4CoralValueTeleop = 0;
    public int L3CoralValueTeleop = 0;
    public int L2CoralValueTeleop = 0;
    public int L1CoralValueTeleop = 0;
    public int ProsserScoredInAuto = 0;
    public int BargeScoredInTeleop = 0;
    public int ProcessorAlgaeInTeleop = 0;
    public int DereefedAlgae = 0;
    public int NetMissedAlgae = 0;


    //recyler
    Spinner WhereParkerd;
    //Notes
    public EditText Notes;

    //
    public String ParkingPlace = "";





    Activity LocalActivity;


    @SuppressLint("SetTextI18n")
    public void LoadDataScreen(Main main){
        main.setContentView(R.layout.data_entry_layout_v3);

        SubmitConfermation = Snackbar.make(main.findViewById(android.R.id.content), "Submit?", Snackbar.LENGTH_LONG);
        SkipConfermation = Snackbar.make(main.findViewById(android.R.id.content), "Skip Match?", Snackbar.LENGTH_LONG);

        WhereParkerd = main.findViewById(R.id.WhereParkerd);
        ArrayAdapter<String> ParkingPlaces = new ArrayAdapter<>(main,android.R.layout.simple_spinner_item,Config.ParkingSpots);


        //Driver Rating
        DriverRating = main.findViewById(R.id.ratingBar);

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

        //Droped coral in auto TODO; Fix var storage
        BargeAlgaeDecButtonAuto = main.findViewById(R.id.BargeAlgaeDecButtonAuto);
        BargeAlgaeIncButtonAuto = main.findViewById(R.id.BargeAlgaeIncButtonAuto);
        BargeAlgaeValueAuto = main.findViewById(R.id.BargeAlgaeValueAuto);

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
        DroppedCoralDecButtonTeleop = main.findViewById(R.id.ProcessorAlgaeDecButtonAuto);
        ProcessorAlgaeIncButtonAuto = main.findViewById(R.id.ProcessorAlgaeIncButtonAuto);
        ProcessorAlgaeValueAuto = main.findViewById(R.id.ProcessorAlgaeValueAuto);

        //Prosser
        BargeAlgaeDecButtonTeleop = main.findViewById(R.id.BargeAlgaeDecButtonTeleop);
        BargeAlgaeIncButtonTeleop = main.findViewById(R.id.BargeAlgaeIncButtonTeleop);
        BargeAlgaeValueTeleop = main.findViewById(R.id.BargeAlgaeValueTeleop);

        //Barge
        ProcessorAlgaeDecButtonTeleop = main.findViewById(R.id.ProcessorAlgaeDecButtonTeleop);
        ProcessorAlgaeIncButtonTeleop = main.findViewById(R.id.ProcessorAlgaeIncButtonTeleop);
        ProcessorAlgaeValueTeleop = main.findViewById(R.id.ProcessorAlgaeValueTeleop);

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

        //to start with a clean slate all code should go below this
        resetData();


        WhereParkerd.setAdapter(ParkingPlaces);

        WhereParkerd.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Config.ParkingPlace = Config.ParkingSpots[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        DriverRating.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            Config.DriverScore = (int) ((rating * 2) + 0.5);
            LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();

            // Filled stars (progress)
            stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);

            // Half-filled stars (secondary progress)
            stars.getDrawable(1).setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC_ATOP);

            // Empty stars (background)
            stars.getDrawable(0).setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_ATOP);

            DriverRating.setRating(Config.DriverScore / 2f);
        });


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
        BargeAlgaeDecButtonAuto.setOnClickListener(v -> {
            if (BargeScoredInAuto > 0) {
                BargeScoredInAuto--;
                BargeAlgaeValueAuto.setText(BargeScoredInAuto + "");
            }
        });

        BargeAlgaeIncButtonAuto.setOnClickListener(v -> {
            BargeScoredInAuto++;
            BargeAlgaeValueAuto.setText(BargeScoredInAuto + "");
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
            if (ProsserScoredInAuto > 0) {
                ProsserScoredInAuto--;
                ProcessorAlgaeValueAuto.setText(ProsserScoredInAuto + "");
            }
        });

        ProcessorAlgaeIncButtonAuto.setOnClickListener(v -> {
            ProsserScoredInAuto++;
            ProcessorAlgaeValueAuto.setText(ProsserScoredInAuto + "");
        });

        //prosser
        BargeAlgaeDecButtonTeleop.setOnClickListener(v -> {
            if (BargeScoredInTeleop > 0) {
                BargeScoredInTeleop--;
                BargeAlgaeValueTeleop.setText(BargeScoredInTeleop + "");
            }
        });

        BargeAlgaeIncButtonTeleop.setOnClickListener(v -> {
            BargeScoredInTeleop++;
            BargeAlgaeValueTeleop.setText(BargeScoredInTeleop + "");
        });

        //Barge
        ProcessorAlgaeDecButtonTeleop.setOnClickListener(v -> {
            if (ProcessorAlgaeInTeleop > 0) {
                ProcessorAlgaeInTeleop--;
                ProcessorAlgaeValueTeleop.setText(ProcessorAlgaeInTeleop + "");
            }
        });

        ProcessorAlgaeIncButtonTeleop.setOnClickListener(v -> {
            ProcessorAlgaeInTeleop++;
            ProcessorAlgaeValueTeleop.setText(ProcessorAlgaeInTeleop + "");
        });

        //Submit Confermation
        SubmitConfermation.setAction("Yes", v -> {
            MatchNumberPlaceholderText.setText("Match " + Config.MatchNumber);
            Config.TeamNumber = MatchReader.getValueFromFile(Config.MatchNumber,Config.BotTracked);
            TeamNumberPlaceholderText.setText("Track " + MatchReader.getValueFromFile(Config.MatchNumber,Config.BotTracked));


            CsvBuilder.BuildCsv(this);
            resetData();
            Toast.makeText(Config.AppContext,"Saving Data",Toast.LENGTH_LONG).show();

            Config.MatchNumber++;

            main.MatchIntroductionLoader.LoadIntroduction(main);
        });

        SubmitConfermation.setBackgroundTint(Color.GRAY);

        SkipConfermation.setAction("Yes", v -> {
            Config.MatchNumber++;
            MatchNumberPlaceholderText.setText("Match " + Config.MatchNumber);
            Config.TeamNumber = MatchReader.getValueFromFile(Config.MatchNumber,Config.BotTracked);
            TeamNumberPlaceholderText.setText("Track " + MatchReader.getValueFromFile(Config.MatchNumber,Config.BotTracked));
        });

        SkipConfermation.setBackgroundTint(Color.GRAY);


        //Submit Buttion;
        SubmitButton.setOnClickListener(v -> {
            SubmitConfermation.show();
        });

        //SignOutButton Buttion
        SignOutButton.setOnClickListener(v -> {
            main.SettingsLoader.LoadSettingsPage(main);
        });

        SkipButton.setOnClickListener(v -> {
            SkipConfermation.show();
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
        BargeScoredInAuto = 0;

        L4CoralValueTeleop = 0;
        L3CoralValueTeleop = 0;
        L2CoralValueTeleop = 0;
        L1CoralValueTeleop = 0;
        ProsserScoredInAuto = 0;
        BargeScoredInTeleop = 0;
        ProcessorAlgaeInTeleop = 0;
        DereefedAlgae = 0;
        NetMissedAlgae = 0;

        // Reset all text views to reflect the reset values
        L4CoralValueAutoView.setText("0");
        L3CoralValueAutoView.setText("0");
        L2CoralValueAutoView.setText("0");
        L1CoralValueAutoView.setText("0");
        BargeAlgaeValueAuto.setText("0");

        L4CoralValueTeleopView.setText("0");
        L3CoralValueTeleopView.setText("0");
        L2CoralValueTeleopView.setText("0");
        L1CoralValueTeleopView.setText("0");
        ProcessorAlgaeValueAuto.setText("0");

        BargeAlgaeValueTeleop.setText("0");
        ProcessorAlgaeValueTeleop.setText("0");
        BargeAlgaeValueAuto.setText("0");
        ProcessorAlgaeValueAuto.setText("0");
        BargeAlgaeValueTeleop.setText("0");
        ProcessorAlgaeValueTeleop.setText("0");

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
