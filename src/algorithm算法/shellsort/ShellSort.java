package algorithm算法.shellsort;

import java.util.Arrays;

/**
 * @author VeigarBaron
 * @date 2020/10/12 14:37
 * @Description *
 */
public class ShellSort {
    public static void ShellSort(int[] array) {
        // 希尔排序的增量
        int d = array.length;
        while (d > 1){
            // 使用希尔增量的方式，即每次折半
            d = d/2;
            for (int x = 0; x < d; x++){
                for (int i = x + d; i < array.length; i = i + d){
                    int temp = array[i];
                    int j;
                    for (j = i - d; j >= 0 && array[j] > temp; j = j - d){
                        array[j + d] = array[j];
                    }
                    array[j + d] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] arr = new int[]{5,3,7,2,1,8,0,4,2};
        ShellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
