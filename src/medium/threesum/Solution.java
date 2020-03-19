package medium.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sound.midi.Soundbank;

public class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    // Set<Integer> set = new HashSet(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    // for (Integer firstNum: set) {
    //     for (Integer secondNum: set) {
    //         if ((secondNum > firstNum) && (set.contains(-firstNum - secondNum)) && (-firstNum - secondNum > secondNum)) {
    //             ans.add(Arrays.asList(new Integer[]{firstNum, secondNum, -firstNum-secondNum}));
    //         }
    //     }
    // }
    List<List<Integer>> ans = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      int l = i + 1, r = nums.length-1;
      Integer prevL = nums[0]-1, prevR = nums[0]-1; // initialize preL, prevR to value that impossible for nums[l], num[r]
      while (l < r) {
        int sum = nums[l] + nums[r] + nums[i];
        if (sum == 0 && nums[l] != prevL && nums[r] != prevR) {
          ans.add(Arrays.asList(new Integer[]{nums[i], nums[l],  nums[r]}));
          prevL = nums[l];
          prevR = nums[r];
        }
        else if (sum > 0) {
          r--;
        } else {
          l++;
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.threeSum(new int[]{-1,0,1,2,-1,-4});
  }
}
