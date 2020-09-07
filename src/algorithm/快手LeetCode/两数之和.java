package algorithm.快手LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author VeigarBaron
 * @date 2020/9/7 13:46
 * @Description *
 */
public class 两数之和 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (hashMap.containsKey(temp)) {
                return new int[]{hashMap.get(temp), i};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }
}
