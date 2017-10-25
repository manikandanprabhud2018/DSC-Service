package com.cargill.customerfacing.dscportal.domain;


import java.io.*;


import com.google.zxing.qrcode.encoder.QRCode;

public class CreateQrCodeVCard {

    public static void main(String... args){
        VCard vCard = new VCard();
        vCard.setName("memorynotfound.com");
        vCard.setAddress("street 1, xxxx address");
        vCard.setCompany("company Inc.");
        vCard.setPhoneNumber("+xx/xx.xx.xx");
        vCard.setTitle("title");
        vCard.setEmail("info@memorynotfound.com");
        vCard.setWebsite("http://memorynotfound.com");


    }
}