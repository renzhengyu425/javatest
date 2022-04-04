package com.base;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
//        xiaoming();
        minNum();
    }

    private static void noHuiwen() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            int inputNum = Integer.parseInt(input);
            String inputStr = br.readLine();
            String[] nextArr = new String[inputNum];
            for (int i = 0; i < nextArr.length; i++) {
                String str = inputStr.substring(0, inputStr.length() - 2);
                nextArr[i] = str + (str.charAt(inputStr.length() - 1) + 1);
            }
        }
    }
    private static void minNum() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            String[] inputArr = input.split(",");
            Arrays.sort(inputArr);
            if (inputArr.length == 0) {
                return;
            }
            if (inputArr.length <= 3) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < inputArr.length; i++) {
                    sb.append(inputArr[i]);
                }
                System.out.println(sb.toString());
            } else {
                int min = 0;
                for (int i = 0; i < inputArr.length - 2; i++) {
                    for (int j = i + 1; j < inputArr.length - 1; j++) {
                        for (int k = j + 1; k < inputArr.length; k++) {
                            String numStr = inputArr[i] + inputArr[j] + inputArr[k];
                            if (min == 0) {
                                min = Integer.parseInt(numStr);
                            } else {
                                min = Math.min(min, Integer.parseInt(numStr));
                            }
                        }
                    }
                }
                System.out.println(min);
            }
        }
    }
    private static void xiaoming () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            int inputNum = Integer.parseInt(input);
            int add = 0;
            int end = 0;
            if (inputNum < 10) {
                add = 1;
            } else {
                while (inputNum / 10 != 0) {
                    end = inputNum % 10;
                    if (end > 4) {
                        add++;
                    }
                    if (inputNum % 10 == 0) {

                    }
                }
            }

            System.out.println(inputNum - add);
        }
    }
}