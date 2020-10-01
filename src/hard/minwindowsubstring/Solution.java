package hard.minwindowsubstring;

import java.util.HashMap;

class Solution {
  public String minWindow(String s, String t) {
    HashMap<Character, Integer> map = new HashMap<>();

    for (char c : t.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0)+1);
    }

    HashMap<Character, Integer> windowMap = new HashMap<>();
    for (char c : map.keySet()) {
      windowMap.put(c, 0);
    }

    int count = 0;
    int l = 0;
    int minL = 0;
    int minR = s.length()+1;
    for (int r = 0; r < s.length(); r++) {
      char rC = s.charAt(r);
      if (map.containsKey(rC) && map.get(rC) > windowMap.get(rC)) {
        count++;
        windowMap.put(rC, windowMap.get(rC) + 1);
      }
      while (count == t.length()) {
        char lC = s.charAt(l);
        if (map.containsKey(lC)) {
          windowMap.put(lC, windowMap.get(lC) - 1);
          count--;
        }
        if (minR - minL > r - l) {
          minL = l;
          minR = r;
        }
        l++;
      }
    }

    if (minR > s.length()) {
      return "";
    }
    return s.substring(minL, minR+1);

  }

  public static void main(String[] args) {
    Solution s = new Solution();
    String n = s.minWindow("ADOBECODEBANC"
            ,"ABC");
    System.out.println(n);
  }
}