package easy.missingnumber;

class Solution {
  public int missingNumber(int[] nums) {
    int remain = nums.length;
    for (int i = 0; i < nums.length; i++) {
      remain = remain ^ i ^ nums[i];
    }
    return remain;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.missingNumber(new int[]{
            3,0,1}));
  }
}