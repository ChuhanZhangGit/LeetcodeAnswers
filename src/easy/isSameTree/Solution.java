package easy.isSameTree;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if ((p == null && q !=null) || (p != null && q == null)) return false;

    if (p.val != q.val) return false;
    return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    TreeNode b2 = new TreeNode(3);
    TreeNode b1 = new TreeNode(2);
    TreeNode a = new TreeNode(1);
    a.left = b1;
    a.right = b2;
    b1.left = null; b1.right = null;
    b2.left =null; b2.right = null;
    TreeNode d2 = new TreeNode(3);
    TreeNode d1 = new TreeNode(2);
    TreeNode c = new TreeNode(1);
    c.left = d1;
    c.right = d2;
    d1.left = null; d1.right = null;
    d2.left =null; d2.right = null;
    System.out.println(s.isSameTree(a,c));
  }
}