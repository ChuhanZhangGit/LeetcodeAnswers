package easy.buysellstock;

import java.util.Arrays;

class Solution {
  public int maxProfit(int[] prices) {
    if (prices.length < 2) return 0;
    int prevProfit = maxProfit(Arrays.copyOfRange(prices, 0, prices.length-1));
    int[] interval = new int[]{prevProfit, prevProfit  +  prices[prices.length-1] - prices[prices.length-2], 0};
    return Arrays.stream(interval).max().getAsInt();
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int ans = s.maxProfit(new int[]{7,1,5,4});
    System.out.println(ans);
  }

}