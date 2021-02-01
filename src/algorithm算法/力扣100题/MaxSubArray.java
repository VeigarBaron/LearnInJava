package algorithm算法.力扣100题;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author VeigarBaron
 * @date 2021/1/29 15:28
 * @Description *
 */
public class MaxSubArray {
    // 判断条件不足
    public int maxSubArray(int[] nums) {
        int sum = 0,stackNum = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i <nums.length; i++){
            int temp = nums[i];
            if (i == 0 && stackNum == 0){
                sum = stackNum = temp;
                continue;
            }
            // 如果待加入的值大于栈中的总值，大于添加后的栈总值，大于目前的总的sum --- 清空栈
            if (temp > stackNum && temp > temp + stackNum && (temp > sum && sum > 0) ){
                stack.clear();
                sum = stackNum = temp;
                stack.push(temp);
            } else {
                stackNum = stackNum + temp;
                if (stackNum > sum)
                    sum = stackNum;
                stack.push(temp);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = {8,-19,5,-4,20};
        int result = maxSubArray.maxSubArray(nums);
        System.out.println("result:" + result);
    }
}
