package com.company;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        String strTest;
        String strValues;
        if (args.length == 0) {
            strTest = scanConvert("tests.json");
            strValues = scanConvert("values.json");
        } else {
            strTest = scanConvert(args[0]);
            strValues = scanConvert(args[1]);
        }


        JSONObject joValues = new JSONObject(strValues);
        Values values = new Values(joValues);



        JSONObject joTest = new JSONObject(strTest);
        Test[] arrayTests = new Test[joTest.getJSONArray("tests").length()];
        for (int i = 0; i < joTest.getJSONArray("tests").length(); i++) {
            arrayTests[i] = new Test(joTest.getJSONArray("tests").getJSONObject(i));
        }


        JSONObject result = new JSONObject();

        JSONArray valuesArray = new JSONArray();
        for (Test t : arrayTests) {
            valuesArray.put(t.getJo());
        }
        result.put("report", valuesArray);

        PrintWriter writer = new PrintWriter("report.json", "UTF-8");
        writer.println(result);
        writer.close();


//        joTest.put("tests", arrayTests);
//        System.out.println(joTest);



    }




    public static String scanConvert(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        String str = "";
        while (scanner.hasNextLine()) {
            str += scanner.nextLine();
        }
        return str;

    }
}
