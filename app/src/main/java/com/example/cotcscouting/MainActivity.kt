package com.example.cotcscouting  // Make sure this matches your manifest package

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.AdapterView
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hex_tech_view_model)  // This uses the R class

        // Find the Spinner by its ID
        val planetsSpinner: Spinner = findViewById(R.id.parkDropDown)

        // Create an ArrayAdapter using the planets_array from resources
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.planets_array,  // Referencing array in strings.xml
            android.R.layout.simple_spinner_item
        )

        //is the is telop check box
        var IsTelop:CheckBox = findViewById(R.id.teleOpCheck)


        // prosser points
        val ProcessorDec: Button = findViewById(R.id.ProcessorDec)
        val ProcessorInc: Button = findViewById(R.id.ProcessorInc)
        val ProsserTextView: TextView = findViewById(R.id.ProcessorPoints)
        var AutoProsserPoints = 0
        var TelopProsserPoints = 0

        ProcessorDec.setOnClickListener {
            if (AutoProsserPoints > 0){
                if (IsTelop.isActivated){
                    AutoProsserPoints--
                    ProsserTextView.text = AutoProsserPoints.toString()
                }

            }
        }

        ProcessorInc.setOnClickListener {
            if (true){
                AutoProsserPoints++
                ProsserTextView.text = AutoProsserPoints.toString()
            }
        }

        // net points

        val NetDec: Button = findViewById(R.id.NetDec)
        val NetInc: Button = findViewById(R.id.NetInc)
        val NetTextView: TextView = findViewById(R.id.NetPoints)
        var NetPoints = 0

        NetDec.setOnClickListener {
            if (AutoProsserPoints > 0){
                NetPoints--
                NetTextView.text = NetPoints.toString()
            }
        }

        NetInc.setOnClickListener {
            if (true){
                NetPoints++
                NetTextView.text = NetPoints.toString()
            }
        }

        //l1 points
        val L1Dec: Button = findViewById(R.id.L1CoralDec)
        val L1Inc: Button = findViewById(R.id.L1CoralInc)
        val L1TextView: TextView = findViewById(R.id.L1Points)
        var L1Points = 0
        //when the time come for diferenting between teleop you can add a nother var

        L1Dec.setOnClickListener {
            if (L1Points > 0){
                L1Points--
                L1TextView.text = L1Points.toString()
            }
        }

        L1Inc.setOnClickListener {
            if (true){
                L1Points++
                L1TextView.text = L1Points.toString()
            }
        }

        //BargePoints
        val BargeDec: Button = findViewById(R.id.BargeDec)
        val BargeInc: Button = findViewById(R.id.BargeInc)
        val BargeTextView: TextView = findViewById(R.id.BargePoints)
        var BargePoints = 0

        BargeDec.setOnClickListener {
            if (BargePoints > 0){
                BargePoints--
                BargeTextView.text = BargePoints.toString()
            }
        }

        BargeInc.setOnClickListener {
            if (true){
                BargePoints++
                BargeTextView.text = BargePoints.toString()
            }
        }


        IsTelop.setOnCheckedChangeListener { compoundButton: CompoundButton, b: Boolean ->
            if (IsTelop.isChecked){
                ProsserTextView.text = TelopProsserPoints.toString()
            }else{
                ProsserTextView.text = AutoProsserPoints.toString()
            }
        }

        // Set the layout for the dropdown view of the Spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Set the adapter to the Spinner
        planetsSpinner.adapter = adapter

        // Set an item selected listener for the Spinner
        planetsSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View?, position: Int, id: Long) {
                val selectedPlanet = parent.getItemAtPosition(position).toString()
                println("Selected planet: $selectedPlanet")
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Handle case where no item is selected, if necessary
            }
        }


    }
}