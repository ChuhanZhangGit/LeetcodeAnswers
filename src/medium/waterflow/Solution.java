package medium.waterflow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<List<Integer>> pacificAtlantic(int[][] matrix) {
    int r = matrix.length;

    if (r == 0) return null;

    int c = matrix[0].length;

    boolean[][] pacific = new boolean[r][c];
    boolean[][] atlantic = new boolean[r][c];

    for (int i = 0; i < r; i++) {
      dfs(matrix, pacific, i, 0);
      dfs(matrix, atlantic, i, c-1);
    }

    for (int i = 0; i < c; i++) {
      dfs(matrix, pacific, 0, i);
      dfs(matrix, atlantic, r-1, i);
    }


    List<List<Integer>> ans = new ArrayList<>();
    for (int i = 0; i < r; i ++) {
      for (int j = 0 ; j < c; j++) {
        if (pacific[i][j] && atlantic[i][j]){
          ans.add(Arrays.asList(new Integer[]{i, j}));
        }
      }
    }
    return ans;
  }

  private void dfs(int[][] matrix, boolean[][] ocean, int x, int y) {
    int[][] dir = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
    ocean[x][y] = true;

    for (int[] curDir : dir) {
      int nX = x + curDir[0];
      int nY = y + curDir[1];
      if ((0 <= nX && nX < matrix.length && 0<= nY && nY < matrix[0].length)
              && (matrix[nX][nY] >= matrix[x][y]) && (!ocean[nX][nY])){
        dfs(matrix, ocean, nX, nY);
      }
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] in = new int[][] {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
    List<List<Integer>> ans = s.pacificAtlantic(in);
    for (List<Integer> p : ans) {
      System.out.println(p.get(0) + ","+ p.get(1));
    }
  }
}
