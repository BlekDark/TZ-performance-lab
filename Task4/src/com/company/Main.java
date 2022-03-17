package com.company;

import java.io.File;
import java.io.FileNotFoundException;
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


        str = str.substring(1, str.length() - 1);
        String[] strArray = str.split(", ");
        int[] nums = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            nums[i] = Integer.valueOf(strArray[i]);
        }

        int result = 0;
        while (true) {
            int mid = ampl(nums);
            if (mid == Integer.MAX_VALUE) break;

            int lessMid = 0;
            int moreMid = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > mid) {
                    moreMid++;
                } else {
                    lessMid++;
                }
            }
            if (lessMid > moreMid) {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] > mid) {
                        result += nums[i] - mid;
                        nums[i] = mid;
                    }
                }
            } else if (lessMid < moreMid) {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] <= mid) {
                        result += mid - nums[i] + 1;
                        nums[i] = mid + 1;
                    }
                }
            } else {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] > mid) {
                        result += nums[i] - mid;
                        nums[i] = mid;
                    } else {
                        result += mid - nums[i];
                        nums[i] = mid;
                    }
                }
            }
        }
        System.out.println(result);
    }

    public static int ampl(int[] nums) {

        int minElem = nums[0];
        int maxElem = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (minElem > nums[i]) {
                minElem = nums[i];
            }
            if (maxElem < nums[i]) {
                maxElem = nums[i];
            }
        }
        if (minElem == maxElem) {
            return Integer.MAX_VALUE;
        } else {
            return (maxElem + minElem) / 2;
        }
    }


}
