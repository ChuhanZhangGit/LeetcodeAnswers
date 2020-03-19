package medium.findmin;

class Solution {
  public int findMin(int[] nums) {

    if (nums.length == 1) return nums[0];

    if (nums[0] < nums[nums.length-1]) return nums[0];

    return helper(nums, 0, nums.length-1);

  }
  public int helper(int[] nums, int start, int end) {
    if (start == end) return start;
    if (start == end -1) {
      if (nums[start] < nums[end]) return start;
      else return end;
    }
    int mid = (start+end)/2;
    if (nums[mid] > nums[start]) {
      return helper(nums, mid, end);
    }
    else {
      return helper(nums, start, mid);
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.findMin(new int[]{3,4,5,1,2}));
  }
}
