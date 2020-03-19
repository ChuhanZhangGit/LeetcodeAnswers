package medium.findmin;

class JavaSolution {
  public int findMin(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    int left = 0, right = nums.length - 1;

    if (nums[right] > nums[0]) {
      return nums[0];
    }

    while (right >= left) {
      int mid = left + (right - left) / 2;

      if (nums[mid] > nums[mid + 1]) {
        return nums[mid + 1];
      }
      if (nums[mid - 1] > nums[mid]) {
        return nums[mid];
      }

      if (nums[mid] > nums[0]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }

  public int pivotFinder(int[] nums, int l, int r) {
    int len = nums.length;
    if (l > r) return -1;
    int mid = (l + r) / 2;
    if (nums[mid] > nums[mid + 1]) return mid + 1;

    if (nums[0] < nums[mid]) {
      return pivotFinder(nums, l, mid - 1);

    } else {
      return pivotFinder(nums, mid + 1, r);
    }
  }

  public static void main(String[] args) {
    JavaSolution solution = new JavaSolution();
    solution.findMin(new int[]{5,1});
    solution.pivotFinder(new int[]{5,1,3},0, 2);
  }
}
