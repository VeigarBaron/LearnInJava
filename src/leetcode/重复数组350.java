package leetcode;

import java.util.*;

/**
 * @Author: VeigarBaron
 * @Date: Create in 2020/7/13  14:38
 * @Description:
 * 给定两个数组，编写一个函数来计算它们的交集。
示例 1：   输入：nums1 = [1,2,2,1], nums2 = [2,2]
           输出：[2,2]
示例 2:   输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
          输出：[4,9]

说明：  输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
        我们可以不考虑输出结果的顺序。
进阶：  如果给定的数组已经排好序呢？你将如何优化你的算法？
        如果 nums1 的大小比 nums2 小很多，哪种方法更优？
        如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class 重复数组350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 把nums1放入hashmap
        HashMap hashMap = new HashMap();
        for (int i = 0; i < nums1.length; i++){
            int offset;
            if (hashMap.get(nums1[i]) == null){
                offset = 1;
            }else{
                offset = Integer.valueOf(hashMap.get(nums1[i]).toString()) + 1;
            }
            hashMap.put(nums1[i],offset);
        }
        List list = new ArrayList();
        for (int j = 0; j <nums2.length; j++){
            if (hashMap.get(nums2[j]) != null){
                int temp = Integer.valueOf(hashMap.get(nums2[j]).toString());
                if ( temp > 0){
                    list.add(nums2[j]);
                    hashMap.put(nums2[j],temp - 1);
                }
            }
        }
        //创建数组
        int[] arr = new int[list.size()];
        for(int i = 0 ;i < arr.length ; i++){
            arr[i] = Integer.valueOf(list.get(i).toString());
        }
        return arr;
    }

    public static void main(String[] args) {
        重复数组350 test = new 重复数组350();
        int nums1[] ={1,2,2,1};
        int nums2[] ={2,2};
        int a[] = test.intersect(nums1,nums2);
        System.out.println(Arrays.toString(a));
    }
}
