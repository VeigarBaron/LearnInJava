package algorithm算法.selectionsort;

/**
 * 简单选择排序
 * Created by HuoPing on 2019/1/2.
 */
public class Selection_sort {

    private static void selectionSort(int arr[]){
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {         // 外层循环
            int min = i;                            // 未排序的序列中最小元素的下标
            for (int j = i + 1; j < len; j++) {
                // 在未排序元素中继续寻找最小元素，并保存其下标
                min = arr[min] > arr[j] ? j : min;
            }
            if (min != i){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }
 
    public static void main(String[] args) {
        int [] arr = new int[]{1,3,5,2,80};
        selectionSort(arr);
    }
}
