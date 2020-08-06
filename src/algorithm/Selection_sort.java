package algorithm;

/**
 * 简单选择排序
 * Created by HuoPing on 2019/1/2.
 */
public class Selection_sort {

    private static void selectionSort(){
        int [] arr = {6, 7, 9, 2, 8, 4, 1, 5, 3};
        int i, j, min, len = arr.length;
        for (i = 0; i < len - 1; i++) {         // 外层循环9次
            min = i;                            // 未排序的序列中最小元素的下标
            for (j = i + 1; j < len; j++) {
                // 在未排序元素中继续寻找最小元素，并保存其下标
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArr(int[] arr) {
        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }
    }

    private static void selectSort(int[] arr) {
        if (arr == null)
            return;
        int i, j, min, len = arr.length;
        for (i = 0; i < len - 1; i++) {
            min = i; // 未排序的序列中最小元素的下标
            for (j = i + 1; j < len; j++) {
                //在未排序元素中继续寻找最小元素，并保存其下标
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i)
                swap(arr, min, i);
        }
    }

    public static void main(String[] args) {
        /*int[] arr = {6, 4, 2, 1, 8, 3, 7, 9, 5};
        selectSort(arr);
        printArr(arr);*/
        selectionSort();
    }
}
