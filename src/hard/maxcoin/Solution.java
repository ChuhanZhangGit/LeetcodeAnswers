package hard.maxcoin;

class Solution {
    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        int maxCoin = binary(nums, dp, 0, nums.length-1);
        return maxCoin;
    }

    private int binary(int[] nums, int[][] dp, int left, int right) {
        if (right < left) return 0;
        if (dp[left][right] > 0) return dp[left][right];

        int maxSum = 0;
        int before = left -1 < 0? 1 : nums[left -1];
        int after = right+1 > nums.length-1 ? 1 : nums[right+1];
        for (int i =left ; i <= right; i++) {
            int sum = nums[i] * before * after +
                    binary(nums, dp, left, i-1) + binary(nums, dp, i+1, right);
            maxSum = Math.max( sum, maxSum);
        }
        dp[left][right] = maxSum;
        return maxSum;
    }

    public int maxCoins2(int[] nums) {

        // reframe the problem
        int n = nums.length + 2;
        int[] new_nums = new int[n];

        for(int i = 0; i < nums.length; i++){
            new_nums[i+1] = nums[i];
        }

        new_nums[0] = new_nums[n - 1] = 1;

        // cache the results of dp
        int[][] memo = new int[n][n];

        // find the maximum number of coins obtained from adding all balloons from (0, len(nums) - 1)
        return dp(memo, new_nums, 0, n - 1);
    }

    public int dp(int[][] memo, int[] nums, int left, int right) {
        // no more balloons can be added
        if (left + 1 == right) return 0;

        // we've already seen this, return from cache
        if (memo[left][right] > 0) return memo[left][right];

        // add each balloon on the interval and return the maximum score
        int ans = 0;
        for (int i = left + 1; i < right; ++i)
            ans = Math.max(ans, nums[left] * nums[i] * nums[right]
                    + dp(memo, nums, left, i) + dp(memo, nums, i, right));
        // add to the cache
        memo[left][right] = ans;
        return ans;
    }

    public static void main(String[] args) {
        int[] iNums = new int[]{3,2,1};
        Solution s = new Solution();
        int d = s.maxCoins(iNums);
        System.out.println(d);
    }
}