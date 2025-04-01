package com.example.scoutingappv3.Dependences.CreateCSVFiles;

import com.example.scoutingappv3.Dependences.Config;
import com.example.scoutingappv3.Dependences.FileManagment.JavaFilesWriter;

public class CsvWriter {

    JavaFilesWriter LocalCsvWriter;
    public CsvWriter(){
        LocalCsvWriter = new JavaFilesWriter(Config.AppContext, Config.CsvFolder, Config.CsvFile);
    }

    public void AppendData(String data){
        LocalCsvWriter.AppedToFile(data);
        AppendDataToDownlodasCsv(data);
    }

    public void AppendDataLn(String data){
        LocalCsvWriter.AppedToFileLine(data);
        AppendDataToDownlodasLineCsv(data);
    }

    public void ResetFile(){
        LocalCsvWriter.ClearFile();
        LocalCsvWriter.ClearDowloadsFile(Config.CsvFile);
    }

    private void AppendDataToDownlodasCsv(String data){
        LocalCsvWriter.WriteDataToDownloadsAppend(Config.CsvFile,data);
    }

    private void AppendDataToDownlodasLineCsv(String data){
        LocalCsvWriter.WriteDataToDownloadsAppendLine(Config.CsvFile,data);
    }

    private void ClearDownloadsCsv(){
        LocalCsvWriter.ClearDowloadsFile(Config.CsvFile);
    }
}
