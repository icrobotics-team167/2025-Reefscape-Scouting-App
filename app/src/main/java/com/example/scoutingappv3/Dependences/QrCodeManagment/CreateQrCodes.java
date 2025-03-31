package com.example.scoutingappv3.Dependences.QrCodeManagment;

import android.content.Context;

import com.example.scoutingappv3.Dependences.Config;
import com.example.scoutingappv3.Dependences.FileManagment.JavaFilesReader;

public class CreateQrCodes {


    public static void CreateCodes(Context context){
        JavaFilesReader QrCodesTxt = new JavaFilesReader(context, Config.CsvFolder);

        for (int i = 0; i < QrCodesTxt.GetSize(Config.CsvFile); i++) {
            QRCodeUtils.CreateQRCode(context,QrCodesTxt.ReadLine(Config.CsvFile,i),"QrCode" + i);
        }
    }
}
