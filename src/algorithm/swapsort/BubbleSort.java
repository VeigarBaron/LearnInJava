package algorithm.swapsort;

/**
 * @author VeigarBaron
 * @date 2020/8/7 10:38
 * @Description 冒泡排序
 */
public class BubbleSort {
    // 对冒泡排序常见的改进方法是加入标志性变量bChange，用于标志某一趟排序过程中是否有数据交换。
    public static void bubbleSort(int[] list) {
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
        }
    }
}
