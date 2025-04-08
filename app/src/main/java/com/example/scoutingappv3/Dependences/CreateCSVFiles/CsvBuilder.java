package com.example.scoutingappv3.Dependences.CreateCSVFiles;

import android.util.Log;

import com.example.scoutingappv3.Dependences.Config;
import com.example.scoutingappv3.Dependences.MatchReader.MatchReader;
import com.example.scoutingappv3.LoadScreens.DataEntryScreen;

public class CsvBuilder {
    public static void BuildCsv(DataEntryScreen dataEntry){
        StringBuilder CsvData = new StringBuilder();
        StringBuilder CsvHeader = new StringBuilder();

        char[] NotesChars = dataEntry.Notes.getText().toString().toCharArray();
        if (NotesChars.length > 0) {
            for (int i = 0; i < NotesChars.length; i++) {
                if (NotesChars[i] == '\n' || NotesChars[i] == ',') {
                    NotesChars[i] = ' ';
                }
            }
        }else {
            NotesChars = "No Notes".toCharArray();
        }

        CsvHeader.append("Notes,");
        CsvData.append(NotesChars);
        CsvData.append(",");

        CsvHeader.append("Name,");
        CsvData.append(Config.UserName);
        CsvData.append(",");

        CsvHeader.append("Match Number,");
        CsvData.append(Config.MatchNumber);
        CsvData.append(",");

        CsvHeader.append("Driver Score,");
        CsvData.append(Config.DriverScore);
        CsvData.append(",");

        CsvHeader.append("Parking Place");
        CsvData.append(Config.ParkingPlace);
        CsvData.append(",");


        CsvHeader.append("Bot Number,");
        CsvData.append(MatchReader.getValueFromFile(Config.MatchNumber,Config.BotTracked));
        CsvData.append(",");

        CsvHeader.append("L4 Scored In Auto,");
        CsvData.append(dataEntry.L4CoralValueAuto);
        CsvData.append(",");

        CsvHeader.append("L3 Scored In Auto,");
        CsvData.append(dataEntry.L3CoralValueAuto);
        CsvData.append(",");

        CsvHeader.append("L2 Scored In Auto,");
        CsvData.append(dataEntry.L2CoralValueAuto);
        CsvData.append(",");

        CsvHeader.append("L1 Scored In Auto,");
        CsvData.append(dataEntry.L1CoralValueAuto);
        CsvData.append(",");

        CsvHeader.append("Barge Scored in autp,");
        CsvData.append(dataEntry.BargeScoredInAuto);
        CsvData.append(",");

        CsvHeader.append("L4 Scored In Telop,");
        CsvData.append(dataEntry.L4CoralValueTeleop);
        CsvData.append(",");

        CsvHeader.append("L3 Scored In Telop,");
        CsvData.append(dataEntry.L3CoralValueTeleop);
        CsvData.append(",");

        CsvHeader.append("L2 Scored In Telop,");
        CsvData.append(dataEntry.L2CoralValueTeleop);
        CsvData.append(",");

        CsvHeader.append("L1 Scored In Telop,");
        CsvData.append(dataEntry.L1CoralValueTeleop);
        CsvData.append(",");

        CsvHeader.append("L1 Scored In Telop,");
        CsvData.append(dataEntry.L1CoralValueTeleop);
        CsvData.append(",");

        CsvHeader.append("Prosser Scored In Auto");
        CsvData.append(dataEntry.ProsserScoredInAuto);
        CsvData.append(",");

        CsvHeader.append("Barge Scored In Teleop,");
        CsvData.append(dataEntry.BargeScoredInTeleop);
        CsvData.append(",");

        CsvHeader.append("Processor Algae In Teleop,");
        CsvData.append(dataEntry.ProcessorAlgaeInTeleop);
        CsvData.append(",");

        CsvHeader.append("Dereefed Algae,");
        CsvData.append(dataEntry.DereefedAlgae);
        CsvData.append(",");

        CsvHeader.append("NetMissedAlgae,");
        CsvData.append(dataEntry.NetMissedAlgae);
        CsvData.append(",");

        CsvHeader.append("Played Defense,");
        CsvData.append(dataEntry.PlayedDefense.isChecked());
        CsvData.append(",");

        CsvHeader.append("Moved Past Go,");
        CsvData.append(dataEntry.MoveCheckBox.isChecked());
        CsvData.append(",");

        new CsvWriter().AppendDataLn(CsvData.toString());
        Log.d("Header", CsvHeader.toString());

    }
}
