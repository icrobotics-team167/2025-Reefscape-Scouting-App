package com.example.scoutingappv3.LoadScreens;

import android.annotation.SuppressLint;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.scoutingappv3.Main;
import com.example.scoutingappv3.R;
import com.google.android.material.slider.Slider;

import java.util.Random;

public class JokeLoader {

    //TODO: Remove THis is a joke Class


    @SuppressLint("SetTextI18n")
    public static void LoadJokeDataEntryOne(Main main){
        main.setContentView(R.layout.madsion_layout);

        SeekBar JokeSlider = main.findViewById(R.id.JokeSlider);
        SeekBar SignOut = main.findViewById(R.id.SignOut);

        TextView JokeTextView = main.findViewById(R.id.JokePoints);

        SignOut.setProgress(0);
        JokeTextView.setText("Points: 0");

        JokeSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Random rand = new Random();
                JokeTextView.setText("Score: " + rand.nextInt(1000));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SignOut.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress == 1){
                    main.SettingsLoader.LoadSettingsPage(main);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
