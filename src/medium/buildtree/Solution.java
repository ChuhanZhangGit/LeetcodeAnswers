package medium.buildtree;

import java.util.Arrays;

class Solution {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length ==0 ) return null;
    TreeNode root = new TreeNode(preorder[0]);
    buildTreeRecur(root, preorder, inorder, 0);
    return root;
  }

  public void buildTreeRecur(TreeNode root, int[] preorder, int[] inorder, int currPreIndex) {
    if (root == null) return;
    int rootIdx = -1;
    for (int i = 0; i < inorder.length; i++) {
      if (inorder[i] == preorder[currPreIndex]) {
        rootIdx = i;
      };
    }
    int left_count = rootIdx;
    int right_count = inorder.length-1 - rootIdx;
    if (left_count != 0) {
      root.left = new TreeNode(preorder[currPreIndex +1]);
    }
    if (right_count != 0) {
      root.right = new TreeNode(preorder[currPreIndex + left_count + 1]);
    }
    buildTreeRecur(root.left, preorder, Arrays.copyOfRange(inorder, 0, rootIdx), currPreIndex +1);
    buildTreeRecur(root.right, preorder, Arrays.copyOfRange(inorder, rootIdx+1, inorder.length), currPreIndex + left_count + 1);

  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
  }
}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
