package algorithm算法.leetcode力扣;

/**
 * @Author: VeigarBaron
 * @Date: Create in 2020/7/13  16:05
 * @Description:
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 *   示例 1:   输入: [5,7]                示例 2:   输入: [0,1]
 *               输出: 4                            输出: 0
 */
public class 数字范围按位与201 {
    // 取最高位相同
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            // turn off rightmost 1-bit
            n = n & (n - 1);
        }
        return m & n;
    }
}
