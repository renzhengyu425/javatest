package com.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> good = new HashSet<String>(Arrays.asList(words));
        for (String word : words) {
            for (int k = 1; k < word.length(); ++k) {
                good.remove(word.substring(k));
            }
        }

        int ans = 0;
        for (String word : good) {
            ans += word.length() + 1;
        }
        return ans;
    }

    public int leastBricks1(List<List<Integer>> wall) {
        List<List<Integer>> boundarys = new ArrayList<List<Integer>>();
        Map<Integer, Integer> times = new HashMap<Integer, Integer>();
        for (List<Integer> integers : wall) {
            List<Integer> boundary = new ArrayList<Integer>();
            int start = 0;
            for (int i = 0; i < integers.size() - 1; i++) {
                // 计算边界
                int bound = start + integers.get(i);
                boundary.add(bound);
                System.out.println(bound);
                if (times.containsKey(bound)) {
                    times.put(bound, times.get(bound) + 1);
                } else {
                    times.put(bound, 1);
                }
            }
            System.out.println("-------------------------");
            boundarys.add(boundary);
        }
        Integer maxKey = 0;
        Integer maxValue = 0;
        for (Integer time : times.keySet()) {
            if (times.get(time) > maxValue) {
                maxKey = time;
                maxValue = times.get(time);
            }
        }
        int num = 0;
        for (List<Integer> boundary : boundarys) {
            if (!boundary.contains(maxValue)) {
                num++;
            }
        }
        return num;
    }

    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (List<Integer> row : wall) {
            int sum = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                }
                else {
                    map.put(sum, 1);
                }
            }
        }
        int res = wall.size();
        for (int key : map.keySet()) {
            res = Math.min(res, wall.size() - map.get(key));
        }
        return res;
    }

    public int numIslands1(char[][] grid) {
        int count = 0;
        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[m].length; n++) {
                if (grid[m][n] == '0') {
                    continue;
                }
                System.out.println("m = " + m + ";" + "n = " + n);
                System.out.println("----------------------------------");
                // 临水边数量
                int nearWaterLine = 0;
                if (n - 1 < 0 || grid[m][n - 1] == '0') {
                    System.out.println("zuo");
                    nearWaterLine++;
                }
                if (m - 1 < 0 || grid[m - 1][n] == '0') {
                    System.out.println("shang");
                    nearWaterLine++;
                }
                if (n + 1 == grid[m].length || grid[m][n + 1] == '0') {
                    System.out.println("you");
                    nearWaterLine++;
                }
                if (m + 1 == grid.length || grid[m + 1][n] == '0') {
                    System.out.println("xia");
                    nearWaterLine++;
                }
                if (4 - nearWaterLine <= 1) {
                    count++;
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
                }
                System.out.println("*************************************");
            }
        }
        return count;
    }

    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }
        return num_islands;
    }

    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int strLen = s.length();
        int left = 0;
        int right = 0;
        int len = 1;
        int maxStart = 0;
        int maxLen = 0;

        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }
            while (left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)) {
                len = len + 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }

    public static void main(String[] args) {
//        String[] words = {"time", "me", "bell"};
        String[] words = {"me", "time"};
        List<List<Integer>> beick = new ArrayList<List<Integer>>();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(new Solution().numIslands(grid));

//        System.out.println(new Solution().minimumLengthEncoding(words));
//        System.out.println(new Solution().leastBricks(beick));
        System.out.println(new Solution().longestPalindrome1("babad"));
    }
}
