package algorithm算法.leetcode力扣;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: VeigarBaron
 * @Date: Create in 2020/6/29  9:08
 * @Description:
 *  给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *  你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *  示例:
 *  给定 nums = [2, 7, 11, 15], target = 9
 *  因为 nums[0] + nums[1] = 2 + 7 = 9
 *  所以返回 [0, 1]
 */
public class 两数之和1 {
    /** 思路
     *  快排，筛掉大于target的，
     *  由首加尾，直到加出target或大于target，循环直至目标值1的值大于target/2
     */

    // 题解：
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}