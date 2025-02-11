package com.example.cotcscouting  // Make sure this matches your manifest package


import android.os.Environment
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.AdapterView
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import qrcode.QRCode
import qrcode.color.Colors
import qrcode.render.QRCodeGraphics


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

        fun generateQRCode(content: String): QRCodeGraphics {
            val helloWorld = QRCode.ofSquares()
                .withColor(Colors.DEEP_SKY_BLUE) // Default is Colors.BLACK
                .withSize(10) // Default is 25
                .build("Hello world!")

            // By default, QRCodes are rendered as PNGs.
            val pngBytes = helloWorld.render()

            return pngBytes
//    FileOutputStream("hello-world.png").use { it.write(pngBytes) }


        }

        fun saveFileToDownloads(fileName: String, content: String) {
            // Check if external storage is available
            if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
                val context = this  // Replace with your actual context

                // Get the Downloads directory
                val downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                val file = File(downloadsDir, fileName)

                try {
                    // Ensure the Downloads directory exists
                    if (!downloadsDir.exists()) {
                        downloadsDir.mkdirs()
                    }

                    // Write the content to the file
                    val fileOutputStream = FileOutputStream(file)
                    fileOutputStream.write(content.toByteArray())
                    fileOutputStream.close()

                    println("File saved successfully at: ${file.absolutePath}")
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            } else {
                println("External storage is not available")
            }
        }

        //is the is telop check box
        var IsTelop:CheckBox = findViewById(R.id.teleOpCheck)



        // prosser points
        val ProcessorDec: Button = findViewById(R.id.ProcessorDec)
        val ProcessorInc: Button = findViewById(R.id.ProcessorInc)
        val ProsserTextView: TextView = findViewById(R.id.ProcessorPoints)
        var AutoProsserPoints = 0
        var TelopProsserPoints = 0

        ProcessorDec.setOnClickListener {
            if (IsTelop.isChecked && TelopProsserPoints > 0){
                TelopProsserPoints--
                ProsserTextView.text = TelopProsserPoints.toString()
            }else if (AutoProsserPoints > 0){
                AutoProsserPoints--
                ProsserTextView.text = AutoProsserPoints.toString()
            }
        }

        ProcessorInc.setOnClickListener {
            if (IsTelop.isChecked){
                TelopProsserPoints++
                ProsserTextView.text = TelopProsserPoints.toString()
            }else{
                AutoProsserPoints++
                ProsserTextView.text = AutoProsserPoints.toString()
            }
        }

        // net points

        val NetDec: Button = findViewById(R.id.NetDec)
        val NetInc: Button = findViewById(R.id.NetInc)
        val NetTextView: TextView = findViewById(R.id.NetPoints)
        var AutoNetPoints = 0
        var TelopNetPoints = 0

        NetDec.setOnClickListener {
           if (IsTelop.isChecked && TelopNetPoints > 0){
               TelopNetPoints--
               NetTextView.text = TelopNetPoints.toString()
           }else if (AutoNetPoints > 0){
               AutoNetPoints--
               NetTextView.text = AutoNetPoints.toString()
           }

        }

        NetInc.setOnClickListener {
            if (IsTelop.isChecked){
                TelopNetPoints++
                NetTextView.text = TelopNetPoints.toString()
            }else{
                AutoNetPoints++
                NetTextView.text = AutoNetPoints.toString()
            }
        }

        //l1 points
        val L1Dec: Button = findViewById(R.id.L1CoralDec)
        val L1Inc: Button = findViewById(R.id.L1CoralInc)
        val L1TextView: TextView = findViewById(R.id.L1Points)
        var TelopL1Points = 0
        var AutoL1Points = 0
        //when the time come for diferenting between teleop you can add a nother var

        L1Dec.setOnClickListener {
            if (IsTelop.isChecked && TelopL1Points > 0){
                TelopL1Points--
                L1TextView.text = TelopL1Points.toString()
            }else if (AutoL1Points > 0){
                AutoL1Points--
                L1TextView.text = AutoL1Points.toString()
            }
        }

        L1Inc.setOnClickListener {
            if (IsTelop.isChecked){
                TelopL1Points++
                L1TextView.text = TelopL1Points.toString()
            }else{
                AutoL1Points++
                L1TextView.text = AutoL1Points.toString()
            }
        }

        //BargePoints
        val BargeDec: Button = findViewById(R.id.BargeDec)
        val BargeInc: Button = findViewById(R.id.BargeInc)
        val BargeTextView: TextView = findViewById(R.id.BargePoints)
        var BargePoints = 0
//        var AutoBargePoints = 0

        BargeDec.setOnClickListener {
            if (BargePoints > 0){
                BargePoints--
                BargeTextView.text = BargePoints.toString()
            }
        }

        BargeInc.setOnClickListener {
            BargePoints++
            BargeTextView.text = BargePoints.toString()
        }


        IsTelop.setOnCheckedChangeListener { compoundButton: CompoundButton, b: Boolean ->
            if (IsTelop.isChecked){
                ProsserTextView.text = TelopProsserPoints.toString()
                NetTextView.text = TelopNetPoints.toString()
//                BargeTextView.text = TelopBargePoints.toString()
                L1TextView.text = TelopL1Points.toString()
            }else{
//                ProsserTextView.text = AutoProsserPoints.toString()
                ProsserTextView.text = AutoProsserPoints.toString()
                NetTextView.text = AutoNetPoints.toString()
//                BargeTextView.text = AutoBargePoints.toString()
                L1TextView.text = AutoL1Points.toString()
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

        val SubmitButtion:Button = findViewById(R.id.SubmitButtion)

        SubmitButtion.setOnClickListener{
            saveFileToDownloads("test.csv","asd")
        }

    }
}