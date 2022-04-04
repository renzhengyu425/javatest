package com.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SulutionTest {

    public static void main(String[] args) throws Exception {
        inputContent();
    }

    public static void inputContent() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            System.out.println(Integer.parseInt(str, 16));
        }
    }
}
