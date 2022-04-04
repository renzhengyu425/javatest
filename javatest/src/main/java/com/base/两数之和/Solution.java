package com.base.两数之和;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * 提示：
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 *
 * Related Topics
 * 数组
 * 哈希表
 *
 * 👍 14008
 * 👎 0
 */
class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        if (length < 2 || length > 104) {
            return null;
        }
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum1(int[] nums, int target) {
        int length = nums.length;
        if (length < 2 || length > 104) {
            return null;
        }
        // 哈希表
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target -nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
