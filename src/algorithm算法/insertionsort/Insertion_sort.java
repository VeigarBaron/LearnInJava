package algorithm算法.insertionsort;

/**
 * 插入排序 ： 当对位置 i 处的元素进行排序时，数组[0,i-1]上的元素一定是已经有序的了。
 * Created by HuoPing on 2019/1/2.
 */
public class Insertion_sort {

    private static void printArr(int[] arr) {
        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }
    }

    private static void insertionSort(int[] arr) {
        int j, temp;
        for (int i = 1; i < arr.length; i++) {
            // 设置哨兵，拿出待插入的值
            temp = arr[i];
            j = i - 1;
            // 然后寻找正确插入的位置
            for (;j >= 0 && arr[j] > temp; j--){
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 4, 2, 1, 8, 3, 7, 9, 5};
        insertionSort(arr);
        printArr(arr);
    }
}
