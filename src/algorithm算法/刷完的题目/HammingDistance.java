package algorithm算法.刷完的题目;

/**
 * @author VeigarBaron
 * @date 2021/2/1 11:39
 * @Description *
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {

        // 异或的结果中，有多少个1，就是多少不同
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            distance += 1;
            // 去除最右侧的1
            xor = xor & (xor - 1);
        }
        return distance;
    }

}
