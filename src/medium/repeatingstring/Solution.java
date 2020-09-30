package medium.repeatingstring;

public class Solution {
  public int characterReplacement(String s, int k) {

    int l = 0, r = 0;
    int maxLen = 0;
    int maxCount = 0;

    int[] count = new int[26];

    while (r < s.length()) {
        do {
          maxCount = Math.max(++count[s.charAt(r)-'A'], maxCount);
          r++;
        }
        while ((r-l+1-maxCount <= k) && (r < s.length()));

      maxLen = Math.max(r-l, maxLen);

      count[s.charAt(l)-'A']--;
      l++;

    }
    return maxLen;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.characterReplacement("AABABBA", 1));
  }
}
