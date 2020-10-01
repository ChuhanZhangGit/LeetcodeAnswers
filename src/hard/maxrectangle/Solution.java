package hard.maxrectangle;

class Solution {
    private class Rectangle {
        protected int w, h;
        public Rectangle(int width, int height) {
            w = width;
            h = height;
        }


    }
    public int maximalRectangle(char[][] matrix) {
        int R = matrix.length;
        if (R ==0 ) return 0;
        int C = matrix[0].length;
        Rectangle[][] dp = new Rectangle[R+1][C+1];
        for (int i = 0; i < R+1; i++) {
            for (int j =0; j < C+1; j++) {
                dp[i][j] = new Rectangle(0,0);
            }
        }
        int maxRect = 0;
        for (int i = 1; i < R+1; i++) {
            for (int j = 1; j < C+1; j++) {
                if (matrix[i-1][j-1] == '1') {
                    int minWidth = 1;
                    int minHeight = 1;
                    if (dp[i-1][j].w ==0) {
                        minWidth = dp[i][j-1].w +1;
                    }
                    else if (dp[i][j-1].w ==0 ) {
                        minHeight = dp[i-1][j].h +1;
                    }
                    else if (dp[i-1][j-1].w ==0) {
                        if (dp[i-1][j].h > dp[i][j-1].w) {
                            minHeight = dp[i-1][j].h+1;
                        } else {
                            minWidth = dp[i][j-1].w+1;
                        }
                    }
                    else {
                        minWidth = Math.min(Math.min(dp[i-1][j-1].w, dp[i][j-1].w),
                                Math.max(dp[i-1][j].w-1, 1))+1;
                        minHeight = Math.min(Math.min(dp[i-1][j-1].h, dp[i-1][j].h),
                                Math.max((dp[i][j-1]).h-1, 1)) +1;
                    }

                    maxRect = Math.max(maxRect, minWidth*minHeight);
                    dp[i][j] = new Rectangle(minWidth, minHeight);
                }
            }
        }
        return maxRect;
    }

    public static void main(String[] args) {
       Solution s = new Solution();
       char[][] matrix = new char[][]{
               {'0','1','1','0','1'},
               {'1','1','0','1','0'},
               {'0','1','1','1','0'},
               {'1','1','1','1','0'},
               {'1','1','1','1','1'},
               {'0','0','0','0','0'}};
        int n = s.maximalRectangle(matrix);
        System.out.println(n);
    }
}