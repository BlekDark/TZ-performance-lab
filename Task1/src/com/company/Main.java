package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        String fileName;
        if (args.length == 0) {
            fileName = "txt.txt";
        } else {
            fileName = args[0];
        }
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        String str = scanner.nextLine();

        String[] strNAndM = str.split(", ");


//        int n = new Scanner(System.in).nextInt();
//        int m = new Scanner(System.in).nextInt();

        int n = Integer.parseInt(strNAndM[0].substring(4));
        int m = Integer.parseInt(strNAndM[1].substring(4));
        int k = m;
        System.out.print(1);
        while (k % n != 1) {
            if (k % n == 0) {
                System.out.print(n);
            } else System.out.print(k % n);
            k += m - 1;


        }

    }
}