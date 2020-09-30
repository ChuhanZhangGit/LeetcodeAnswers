package easy.debug;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
  public int[] twoSum(int[] nums, int target) {
    Integer[] idx = new Integer[nums.length];
    for (int i =0 ; i < nums.length; i++) idx[i] = i;


    Arrays.sort(idx, new Comparator<Integer>() {

      @Override
      public int compare(Integer a, Integer b) {
        return a.compareTo(b);
      }
    });
    // (a , b) -> nums[a]- nums[b]);



    int l, r;
    l = 0;
    r = nums.length-1;
    while (l < r) {
      int currSum = nums[idx[l]] + nums[idx[r]];

      if (currSum == target) {
        return new int[]{idx[l], idx[r]};
      }
      else if (currSum < target) {l++;}
      else {r--;}
    }
    return null;
  }
}