package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName1;
        if (args.length == 0) {
            fileName1 = "file1.txt";
        } else {
            fileName1 = args[0];
        }
        File file1 = new File(fileName1);
        Scanner scanner1 = new Scanner(file1);
        float cordXCircle = scanner1.nextFloat();
        float cordYCircle = scanner1.nextFloat();
        float radius = scanner1.nextFloat();

        String fileName2;
        if (args.length == 0) {
            fileName2 = "file2.txt";
        } else {
            fileName2 = args[1];
        }
        File file2 = new File(fileName2);
        Scanner scanner2 = new Scanner(file2);
        while (scanner2.hasNextInt() == true) {

            System.out.println(hitChek(radius,cordXCircle,cordYCircle, scanner2.nextFloat(), scanner2.nextFloat()));
        }


    }

    public static int hitChek (float radius, float cordXCircle, float cordYCircle, float cordXDot, float cordYDot) {
        float cordX = cordXDot - cordXCircle;
        float cordY = cordYDot - cordYCircle;
        if (Math.sqrt(cordX * cordX + cordY * cordY) == radius){
            return 0;
        } else if (Math.sqrt(cordX * cordX + cordY * cordY) > radius) {
            return 2;
        } else  {
            return 1;
        }
    }
}
