package algorithm算法.力扣100题;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author VeigarBaron
 * @date 2021/1/27 16:13
 * @Description *
 */
public class TwoSum {
    public int[] twoSum (int num[], Integer target){

        HashMap<Integer,Integer> hashMap = new HashMap();
        for (int i = 0; i < num.length; i++){
            if (hashMap.get(target - num[i]) != null){
                return new int[]{hashMap.get(target - num[i]), i};
            } else {
                hashMap.put(num[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum twoSum =  new TwoSum();
        int[] num = {2,7,16,18,25,30};
        int target = 23;
        System.out.println(Arrays.toString(twoSum.twoSum(num,target)));
    }
}
