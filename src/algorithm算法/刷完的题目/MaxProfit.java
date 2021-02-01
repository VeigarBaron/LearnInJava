package algorithm算法.刷完的题目;

/**
 * @author VeigarBaron
 * @date 2021/2/1 16:13
 * @Description *
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] nums2 = {10,1,8,9,4,2,6,2};
        int[] nums = {2,4,1};
    }
}
