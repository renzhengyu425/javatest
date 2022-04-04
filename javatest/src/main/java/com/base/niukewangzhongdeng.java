package com.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class niukewangzhongdeng {

    public static void main(String[] args) {
        CubicRoot();
//        System.out.println(getCube(216));
    }

    public static void Hj14zifuchuanpaixu(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        String[] result = new String[count];
        for (int i = 0; i < count; i++) {
            result[i] = bf.readLine();
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(result);
        for (String w : result) {
            sb.append(w).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void Hj26zifuchuanpaixu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            char[] ch = s.toCharArray();
            char[] chars = new char[ch.length];
            int flag = 'A', j = 0;
            while (flag <= 'Z') {
                for (int i = 0; i < ch.length; i++) {
                    if ((ch[i] >= 'A' && ch[i] <= 'Z') || (ch[i] >= 'a' && ch[i] <= 'z')) {
                        if (ch[i] == flag || ch[i] == flag + 32) {
                            chars[j] = ch[i];
                            j++;
                        }
                    }
                }
                flag++;
            }
            j = 0;
            for (int i = 0; i < ch.length; i++) {
                if ((ch[i] >= 'A' && ch[i] <= 'Z') || (ch[i] >= 'a' && ch[i] <= 'z')) {
                    ch[i] = chars[j];
                    j++;
                }
            }
            System.out.println(String.valueOf(ch));
        }
    }

    public static void panduanipv4() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = bf.readLine()) != null) {
            String[] subIP = str.split("\\.");
            for (int i = 0; i < subIP.length; i++) {
                Integer intIP = Integer.valueOf(subIP[i]);
                if (intIP >= 0 && intIP <= 255) {
                    if (i == subIP.length - 1) {
                        System.out.println("YES");
                    }
                    continue;
                } else {
                    System.out.println("NO");
                    break;
                }
            }
        }
    }

    public static void geisuoyoushuzijiaxing() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < str.length()) {
                char ch = str.charAt(i);
                if ('0' <= ch && ch <= '9') {
                    sb.append('*');
                    sb.append(ch);
                    while (++i < str.length() && '0' <= (ch = str.charAt(i)) && ch <= '9') {
                        sb.append(ch);
                    }
                    sb.append('*');
                } else {
                    sb.append(ch);
                    i++;
                }
            }
            System.out.println(sb.toString());
        }
    }

    public static void zishoushu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int input = Integer.parseInt(str);
            int count = 0;
            for (int i = 0; i <= input; i++) {
                if (String.valueOf(input * input).endsWith(String.valueOf(input))) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static void xiangTongZiFu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            char[] chArr = str.toCharArray();
            int[] temp = new int[150];
            for (int i = 0; i < chArr.length; i++) {
                temp[chArr[i]]++;
            }
            int max = 0;
            for (int j = 0; j < temp.length; j++) {
//                if (max < temp[j]) {
//                    max = temp[j];
//                }
                max = Math.max(max, temp[j]);
            }
            StringBuilder sbf = new StringBuilder();
            while (max != 0) {
                for (int j = 0; j < temp.length; j++) {
                    if (temp[j] == max) {
                        sbf.append((char) j);
                    }
                }
                max--;
            }
            System.out.println(sbf.toString());
        }
    }

    public static void CubicRoot() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double num = scanner.nextInt();
            if (num == 0) {
                System.out.println(0);
            }
            double x = num;
            double y = (2 * x) / 3 + num / (3 * x * x);
            while (Math.abs(x - y) > 0.000000001) {
                x = y;
                y = (2 * x) / 3 + num / (3 * x * x);
            }
            System.out.println(String.format("%.1f", y));
        }
    }

    public static double getCube(double input) {
        double x = 1;
        double x1 = x - (x * x * x - input) / (3 * x * x);
        while (x - x1 > 0.000000001 || x - x1 < -0.000000001) {        //判断精度
            x = x1;
            x1 = x - (x * x * x - input) / (3 * x * x);
        }
        return x1;
    }
}
