package com.example.googleauth;

import com.google.zxing.WriterException;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

import static com.example.googleauth.Utils.getTOTPCode;

public class MainApplication {

    public static void main(String[] args) throws IOException, WriterException {
        new Layout();
    }
}
