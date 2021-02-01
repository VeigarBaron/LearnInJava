package algorithm算法.刷完的题目;

import java.util.*;

/**
 * @author VeigarBaron
 * @date 2021/2/1 15:37
 * @Description *
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int n : nums) {
            if (hashMap.get(n) != null) {
                hashMap.remove(n);
            } else {
                hashMap.put(n,n);
            }
        }
        Set<Integer> a = hashMap.keySet();
        Object[] object = a.toArray();
        return (int)object[0];
    }

    public int singleNumber2(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            count = count ^ nums[i];
        }
        System.out.println(count);
        return count;
    }


    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] nums = {2,6,3,5,2,3,4,8,6,5,8};
        singleNumber.singleNumber2(nums);
    }
}
