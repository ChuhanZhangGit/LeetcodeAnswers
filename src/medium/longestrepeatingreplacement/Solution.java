package medium.longestrepeatingreplacement;

class Solution {
  public int characterReplacement(String s, int k) {
    if (s.length() <= k) {
      return s.length();
    }
    int l = 0, r = 0;
    int maxLen = 0;
    int maxCount = 0;
    int[] count = new int[26];

    while (l < s.length()) {

      while ((r < s.length()) && (r - l <= k + maxCount)) {
        int currCharCount = ++count[s.charAt(r)-'A'];
        if (currCharCount > maxCount) {
          maxCount = currCharCount;
        } else if (r - l == k+maxCount) {
          count[s.charAt(r)-'A']--;
          break;
        }
        r++;
      }
      maxLen = Math.max(r-l, maxLen);
      count[s.charAt(l)-'A']--;
      l++;
    }
    return maxLen;
  }

  public int characterReplacement2(String s, int k) {
    if (s.length() <= k) {
      return s.length();
    }
    int l = 0, r = 0;
    int maxLen = 0;
    int maxCount = 0;
    int[] count = new int[26];

    while (r < s.length()) {
      maxCount = Math.max(++count[s.charAt(r)-'A'], maxCount);

      while ((r - l + 1 > k + maxCount) && (r < s.length())) {
        count[s.charAt(l) - 'A']--;
        l++;
      }

      maxLen = Math.max(maxLen, r - l + 1);
      r++;
    }

    return maxLen;
  }


  public static void main(String[] args) {
    Solution s = new Solution();
    int n = s.characterReplacement2("AABABBA", 1);
    System.out.println(n);
  }
}
