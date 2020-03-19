package medium.wordbreak;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    HashSet<String> set = new HashSet<>(wordDict);

    int len = s.length();

    boolean[] dp = new boolean[len];

    dp[0] = set.contains(s.substring(0,1));
    for (int i = 1; i < len; i++) {
      boolean inDict = false;
      for (int j = 0; j < i; j++) {
        if (dp[j] == true && set.contains(s.substring(j+1,i+1))) {
          inDict = true;
        }
      }
      dp[i] = inDict;
    }
    return dp[len-1];
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    List<String> l = new ArrayList<>();
    l.add("leet");
    l.add("code");
    s.wordBreak("leetcode", l);
  }
}