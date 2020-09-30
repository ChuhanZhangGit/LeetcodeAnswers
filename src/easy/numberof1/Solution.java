package easy.numberof1;

import java.awt.SystemTray;

public class Solution {
  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    int count = 0;
    while (n != 0) {
      if (n %2 != 0) {
        count += 1;
      }
      n = n >> 1;
    }
    return count;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.hammingWeight(2));


  }
}