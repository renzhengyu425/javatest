package com.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NiuKeWang {
//    public static void main(String[] args) {
////        new NiuKeWang().find1Time();
////        reverseNum();
//        int x = 3 + 2 * (1 + 2 * (-4 / (8 - 6) + 7));
//        System.out.println(x);
//    }

    public static void zimupaixu() throws IOException {
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

    public static void suoyinxiangtong(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int) st.nval;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            st.nextToken();
            int key = (int) st.nval;
            st.nextToken();
            int value = (int) st.nval;
            arr[key] = arr[key] + value;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                sb.append(i).append(" ").append(arr[i]).append("\n");
            }
        }
        System.out.println(sb.toString());

    }

    public static void zuidagongbeishu() {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        System.out.println(A * B / maxDivisor(A, B));
    }

    public static long shiliuzhuan10(String str) {
        return Long.parseLong(str, 16);
    }

    //求最大公约数
    public static int maxDivisor(int A, int B) {
        if (A == B) {
            return B;
        }
        if (A > B) {
            int differ = A - B;
            return maxDivisor(B, differ);
        } else {
            int differ = B - A;
            return maxDivisor(A, differ);
        }
    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String hex_num = in.nextLine();
//        long dec_num = Long.parseLong(hex_num, 16);
//        System.out.println(dec_num);
//    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String input;
//        StringBuilder sb = new StringBuilder();
//        while ((input = bf.readLine()) != null) {
//            long num = Long.parseLong(input, 16);
//            sb.append(num).append("\n");
//        }
//        System.out.println(sb.toString());
//    }

    public static void revers() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = br.readLine()) != null) {
            StringBuilder sb = new StringBuilder(str);
            String res = sb.reverse().toString();
            System.out.println(res);
        }
    }

    public static void dengchashulie() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder sb = new StringBuilder();
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum = sum + (3 * n - 1);
            }
            System.out.println(sum);
        }
    }

    /**
     * 获取路线数量
     *
     * @param n
     * @param m
     * @return
     */
    public static int getCount(int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    // 边上的每一个点的可能性都是1，因为走到边上，就只能顺着边往下走了，可能性只能是1
                    dp[i][j] = 1;
                } else {
                    // 往后每一个点，都是后面两个点的可能性之和，因为它可以选择任意一个点来走，可能性就是下两个点的可能性相加
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        // 最终加到最后一个点，可能性就是所有的路线数量
        return dp[n][m];
    }

    public static int totalMethod(int n, int m) {
        if (n == 0 && m == 0) {
            return 0;
        }
        if (n == 0 || m == 0) {
            return 1;
        }
        return totalMethod(n - 1, m) + totalMethod(n, m - 1);
    }

    public static void pwdDetermine() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder sb = new StringBuilder();
        while ((str = br.readLine()) != null) {
            String grade = "";
            List<Character> number = new ArrayList<>();
            List<Character> lowerCaseLetters = new ArrayList<>();
            List<Character> letters = new ArrayList<>();
            List<Character> symbol = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    number.add(ch);
                } else if (ch >= 'a' && ch <= 'z') {
                    lowerCaseLetters.add(ch);
                } else if (ch >= 'A' && ch <= 'Z') {
                    letters.add(ch);
                } else {
                    symbol.add(ch);
                }
            }
            int score = 0;
            int pwdLen = str.length();
            if (pwdLen <= 4) {
                score += 4;
            } else if (pwdLen >= 5 && pwdLen <= 7) {
                score += 10;
            } else {
                score += 25;
            }
            if (letters.size() + lowerCaseLetters.size() != 0) {
                if (letters.size() == 0 || lowerCaseLetters.size() == 0) {
                    score += 10;
                } else {
                    score += 20;
                }
            }
            if (number.size() != 0) {
                if (number.size() == 1) {
                    score += 10;
                } else {
                    score += 20;
                }
            }
            if (symbol.size() != 0) {
                if (symbol.size() == 1) {
                    score += 10;
                } else {
                    score += 25;
                }
            }


            if (number.size() != 0 && letters.size() != 0 && lowerCaseLetters.size() != 0 && symbol.size() != 0) {
                score += 5;
            } else if (number.size() != 0 && (letters.size() != 0 || lowerCaseLetters.size() != 0) && symbol.size() != 0) {
                score += 3;
            } else if (number.size() != 0 && (letters.size() != 0 || lowerCaseLetters.size() != 0)) {
                score += 2;
            }
            String des = "";
            if (score >= 90) {
                des = "VERY_SECURE";
            } else if (score >= 80) {
                des = "SECURE";
            } else if (score >= 70) {
                des = "VERY_STRONG";
            } else if (score >= 60) {
                des = "STRONG";
            } else if (score >= 50) {
                des = "AVERAGE";
            } else if (score >= 25) {
                des = "WEAK";
            } else {
                des = "VERY_WEAK";
            }
            sb.append(des).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void in1row() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder sb = new StringBuilder();
        while ((str = br.readLine()) != null) {
            String strBin = Integer.toBinaryString(Integer.parseInt(str));
            int maxLen = 0;
            String[] strAyy = strBin.split("0");
            for (String s : strAyy) {
                maxLen = Math.max(maxLen, s.length());
            }
            sb.append(maxLen).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int longestPalindrome2(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        int length = str.length();
        int maxLen = 0;
        for (int i = 0; i < length - 1; i++) {
            int lenOdd = extended(str, i, i);
            int lenEven = extended(str, i, i + 1);
            maxLen = Math.max(maxLen, Math.max(lenOdd, lenEven));
        }
        return maxLen;
    }

    public static String longestPalindrome1(String str) {
        if (str == null || str.length() < 1) {
            return "";
        }
        int length = str.length();
        int maxLen = 0;
        int start = 0, end = 0;
        for (int i = 0; i < length - 1; i++) {
            int lenOdd = extended(str, i, i);
            int lenEven = extended(str, i, i + 1);
            maxLen = Math.max(lenOdd, lenEven);
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return str.substring(start, end + 1);
    }

    private static int extended(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }

    public static void capital() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder sb = new StringBuilder();
        while ((str = br.readLine()) != null) {
            int count = 0;
            for (int i = 0; i < str.length(); i++)
                if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
                    count++;
                }
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void Nikotches() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = "";
        while ((str1 = br.readLine()) != null) {
            int num = Integer.parseInt(str1);
            List<String> numbList = new ArrayList<>();
            int center = num * num;
            int start = 0;
            if (num % 2 != 0) {
                start = center - (num / 2 + 1) * 2;
            } else {
                start = (center - 1) - (num / 2 - 1) * 2;
            }
            for (int i = 0; i < num; i++) {
                numbList.add(String.valueOf(start + 2 * i));
            }
            System.out.println(String.join("+", numbList));
        }
    }

    public static void compareStR() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = "";
        String str2 = "";
        while ((str1 = br.readLine()) != null && (str2 = br.readLine()) != null) {
            char[] ch1 = str1.toCharArray();
            char[] ch2 = str2.toCharArray();
            System.out.println(Chaozhao(ch1, ch2));
        }
    }

    public static int Chaozhao(char[] ch1, char[] ch2) {
        int max = 0;
        for (int i = 0; i < ch1.length; i++) {
            for (int j = 0; j < ch2.length; j++) {
                int t1 = i;
                int count = 0;
                int t2 = j;
                while (ch1[t1] == ch2[t2]) {
                    count++;
                    t1++;
                    t2++;
                    if (count > max) {
                        max = count;
                    }
                    if (t1 == ch1.length || t2 == ch2.length) {
                        break;
                    }
                }
            }
        }
        return max;
    }

    public static void spltParams1() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = " ";
        while ((str = br.readLine()) != null) {
            List<String> params = new ArrayList<>();
            int length = str.length();
            for (int i = 0; i < length; i++) {
                if (str.charAt(i) == '"') {

                }
            }
        }
    }

    public static void spltParams() throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = buffer.readLine()) != null) {
            char[] cha = str.toCharArray();
            StringBuffer bu = new StringBuffer();
            int flag = 0;
            int count = 1;
            for (int i = 0; i < cha.length; i++) {
                if (cha[i] == '\"') {
                    flag++;
                    continue;
                }
                if (cha[i] != ' ') {
                    bu.append(cha[i]);
                }
                if (cha[i] == ' ' && flag % 2 != 0) {
                    bu.append(cha[i]);
                }
                if (cha[i] == ' ' && flag % 2 == 0) {
                    bu.append("\n");
                    count++;
                }
            }
            System.out.println(count + "\n" + bu.toString());
        }
    }

    /*
     * 递归算法
     * 问题分析：递归算法
        分为两种状况，m为苹果数；n为盘子数
        第一种情况：当苹果的数量小于盘子的数量时，即 m<n 时，问题就是转化为将 m 个苹果放到 m 个盘子中；
        第二种情况：当苹果数大于盘子数量时，即 m>=n 时，要分析：
        （1）将至少其中一个盘子不放，那就是 m 个苹果放到 （n-1） 个盘子中的方法
        （2）每个盘子放一个，然后就是（m-n）个放在 n 个盘子的方法
     * */
    public static int solve(int m, int n) {
        if (n == 1 || m == 1 || m == 0) {
            return 1;
        }
        if (m < n) { // 苹果数量小于盘子数量
            return solve(m, m);
        } else {
            return solve(m, n - 1) + solve(m - n, n);
        }
    }

    public static void placeApple1(String[] args) {
        int m = 7; //7个苹果
        int n = 3; //3个盘子
        int result = solve(m, n);
        System.out.println("result = " + result);
    }

    public static void placeApple(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = " ";
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            int m = Integer.parseInt(s[0]);
            int n = Integer.parseInt(s[1]);
            System.out.println(countApp(m, n));
        }
    }

    public static int countApp(int m, int n) {
        if (n == 1 || m == 0) {
            return 1;
        } else if (n > m) {
            return countApp(m, m);
        } else {
            return countApp(m, n - 1) + countApp(m - n, n);
        }
    }

    public static void perfectNumber(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = br.readLine()) != null) {
            System.out.println(count(Integer.valueOf(str)));
        }
    }

    public static int count(int n) {
        int result = 0;
        for (int i = 1; i < n; i++) {
            int sum = 0;
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }
            if (sum == i) {
                result++;
            }
        }
        return result;
    }

    public static void printComNum(int n) {
        //需要计算100以内的完数 范围就是<n
        //把i看做预订的完美数
        for (int i = 1; i < n; i++) {
            //用于存储完美数因子的和
            int sum = 0;
            //所有完美数的因子都有1 肯定不能为0 所以从1开始
            //范围是<i 完美数定义:除它本身外的所有因子之和等于它本身
            //所以循环到小于它的前一个数循环就结束了
            for (int j = 1; j < i; j++) {
                //如果数对j取余等于0 说明j是它的因数
                if (i % j == 0) {
                    //是i的因数的话 sum+j
                    sum += j;
                }
            }
            //上一个循环结束后 sum存储了i的所有因子的和
            //如果i=sum 那么说明它是完美数
            if (i == sum) {
                System.out.println(i);
            }
        }
    }

    public static int run(int x) {
        if (x <= 2) {//前两行直接返回-1
            return -1;
        } else if (x % 2 == 1) {//奇数行第一个出现偶数为2
            return 2;
        }
        return x / 2 % 2 + 3;
    }

    public static void calculator() throws IOException {
        InputStream in = System.in;
        System.out.println(new ExprDemo().expr(in));
    }

    public static class ExprDemo {
        public char lastsign1 = 0, lastsign2 = 0;
        public int temp1 = 0, temp2 = 0;
        private static final char TEMPCHAR = 0;

        public int expr(InputStream in) throws IOException {
            int result = 0;
            char c;
            a:
            while ((c = (char) in.read()) != '\n') {
                switch (c) {
                    case ')':
                    case ']':
                    case '}':
                        break a;
                    case '(':
                    case '[':
                    case '{':
                        temp2 = new ExprDemo().expr(in);
                        break;
                    case '+':
                    case '-':
                        jisuan1(TEMPCHAR);
                        result = jisuan2(c, result);
                        break;
                    case '*':
                    case '/':
                        jisuan1(c);
                        break;
                    default:
                        temp2 = temp2 * 10 + c - '0';
                        break;
                }
            }
            jisuan1(TEMPCHAR);
            result = jisuan2(TEMPCHAR, result);
            return result;
        }

        private void jisuan1(char c) {
            switch (lastsign2) {
                case 0:
                    temp1 = temp2;
                    break;
                case '*':
                    temp1 *= temp2;
                    break;
                case '/':
                    temp1 /= temp2;
                    break;
                default:
                    break;
            }
            temp2 = 0;
            lastsign2 = c;
        }

        private int jisuan2(char c, int result) {
            switch (lastsign1) {
                case 0:
                    result = temp1;
                    break;
                case '-':
                    result -= temp1;
                    break;
                case '+':
                    result += temp1;
                    break;
                default:
                    break;
            }
            temp1 = 0;
            lastsign1 = c;
            return result;
        }
    }

    public static void rabbit1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(getTotalCount(n));
        }
    }

    public static int getTotalCount(int monthCount) {
        if (monthCount < 3) {
            return 1;
        }
        return getTotalCount(monthCount - 2) + getTotalCount(monthCount - 1);
    }

    public static void rabbit() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null) {
            int monthCount = Integer.parseInt(line);
            System.out.println(getTotalCount1(monthCount));
        }
    }

    public static int getTotalCount1(int monthCount) {
        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 2; i < monthCount; ++i) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void reverseNum() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(num));
            String resStr = stringBuilder.reverse().toString();
            System.out.println(resStr);
        }
    }

    public void find1Time() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            //java API中有方法可以直接十进制转二进制
            String a = Integer.toBinaryString(num);
            int count = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == '1') {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
