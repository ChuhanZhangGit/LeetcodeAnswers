package medium.holdwater;

class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length -1;
        int maxArea = 0;

        while (l < r) {
            maxArea = Math.max(maxArea, (r-l)*(Math.min(height[l], height[r])));
            if (!(height[l+1] > height[l] || height[r-1] > height[r])) {
                l++; r--;
            }
            if (height[l+1] > height[l]) l++;
            if (height[r-1] > height[r]) r--;

        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int a = s.maxArea(new int[]{2,3,10,5,7,8,9});
        System.out.println(a);
    }
}