package com.example.cotcscouting  // Make sure this matches your manifest package

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.AdapterView
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