package algorithm.bubbleSort;

/**
 * 冒泡排序
 * Created by HuoPing on 2019/1/2.
 */
public class Bubble_sort {

    // by myself
    private static void BubbleSort() {
        int[] list = {1,2,3,4,5,6,7,8,9};
        for (int i = 0; i < list.length-1; i++){
            //  从前向后依次的比较相邻两个数的大小，遍历一次后，把数组中第i小的数放在第i个位置上
            for (int j = 1; j < list.length - i; j++){
                // 比较相邻的元素，如果前面的数大于后面的数，则交换
                if (list[j - 1] > list[j]) {
                    int temp = list[j - 1]; // temp :用来交换的临时数
                    list[j - 1] = list[j];
                    list[j] = temp;
                }
            }
            System.out.print("第 " + i + " 趟" + ":");
            for (int anArr : list) {
                System.out.print(anArr + " ");
            }
        }
    }

    // 优化冒泡排序
    // 对冒泡排序常见的改进方法是加入标志性变量exchange，用于标志某一趟排序过程中是否有数据交换。
    private static void BubbleSortmore() {
        int[] list = {1,2,3,4,5,6,7,8,9};
        boolean bChange;    //交换标志
        for (int i = 0; i < list.length-1; i++){
            bChange = false;
            //  从前向后依次的比较相邻两个数的大小，遍历一次后，把数组中第i小的数放在第i个位置上
            for (int j = 1; j < list.length - i; j++){
                // 比较相邻的元素，如果前面的数大于后面的数，则交换
                if (list[j - 1] > list[j]) {
                    int temp = list[j - 1]; // temp :用来交换的临时数
                    list[j - 1] = list[j];
                    list[j] = temp;
                    bChange = true;
                }
            }
            if (!bChange)
                break;
            System.out.print("第 " + i + " 趟" + ":");
            for (int anArr : list) {
                System.out.print(anArr + " ");
            }
        }
        System.out.print("最终：");
        for (int anArr : list) {
            System.out.print( anArr + " ");
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

    private static void bubbleSort(int[] arr) {
        if (arr == null)
            return;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        /*int[] arr = {6, 4, 2, 1, 8, 3, 7, 9, 5};
        bubbleSort(arr);
        printArr(arr);*/
//        BubbleSort();        // 基本写法
        BubbleSortmore();       // 优化后写法
    }
}
