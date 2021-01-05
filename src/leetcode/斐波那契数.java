package leetcode;

/**
 *
 * @author VeigarBaron
 * @date 2021/1/5 15:42
 * @Description 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。
 *  该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。
 *  F(0) = 0，F(1) = 1
 *  F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 */
public class 斐波那契数 {

    public int fib(int n) {
        // 滚动数组
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
