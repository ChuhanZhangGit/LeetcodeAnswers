package medium.searchrotatearray;

public class Solution {
  public int search(int[] nums, int target) {
    int len = nums.length;
    if (len == 0) return -1;
    if (len == 1) {
      if (nums[0] == target) return 0;
      else return -1;
    }
    if (nums[0] < nums[len-1]) {
      return binarySearch(nums, 0, len-1, target);
    }
    int pivot = pivotFinder(nums, 0, len-1);
    if (target >= nums[0])
      return binarySearch(nums, 0, pivot, target);
    else{
      return binarySearch(nums, pivot, len-1, target);
    }

  }
  public int pivotFinder(int[] nums, int l, int r) {
    if (l == r) {
      if (nums[l-1] > nums[l]) {
        return l;
      } else {
        return -1;
      }
    }
    int mid = (l+r)/2;

    if (nums[0] > nums[mid]) {
      return pivotFinder(nums, l, mid);
    }
    else {
      return pivotFinder(nums, mid+1, r);
    }

  }
  public int binarySearch(int[] nums, int l, int r, int target) {
    while (l <= r) {
      int mid = (l+r)/2;
      if (nums[mid] == target) return mid;
      else if (nums[mid] > target) r = mid-1;
      else l = mid+1;
    }
    return -1;
  }

  public static void main(String[] args) {
    Solution s= new Solution();
    s.search(new int[]{5,1,2}, 2);
  }
}
