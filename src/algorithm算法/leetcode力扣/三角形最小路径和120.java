package algorithm算法.leetcode力扣;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: VeigarBaron
 * @Date: Create in 2020/7/14  11:59
 * @Description:
 */
public class 三角形最小路径和120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[n - 1][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }
        return minTotal;
    }
    public static void main(String[] args) {
        三角形最小路径和120 test = new 三角形最小路径和120();
        List list = new ArrayList();
        List list1 = new ArrayList();
        list1.add(-1);
        List list2 = new ArrayList();
        list2.add(2);
        list2.add(3);
        List list3 = new ArrayList();
        list3.add(1);
        list3.add(-1);
        list3.add(-3);
        list.add(list1);
        list.add(list2);
        list.add(list3);
        int sum = test.minimumTotal(list);
        System.out.println("sum : " + sum );
    }
}
