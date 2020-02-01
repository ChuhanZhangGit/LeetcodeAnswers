//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//
//public class CloneGraph {
//  public static void main(String[] args) {
//    Node n1 = new Node(1,new ArrayList<>());
//    Node n2 = new Node(2, new ArrayList<>());
//    Node n3 = new Node(3,new ArrayList<>());
//    n1.neighbors.add(n2);
//    n1.neighbors.add(n3);
//    n2.neighbors.add(n1);
//    n2.neighbors.add(n3);
//    n3.neighbors.add(n1);
//    n3.neighbors.add(n2);
//    Solution sol = new Solution();
//    Node clone = sol.cloneGraph(n1);
//    System.out.println((clone.val));
//
//  }
//
//}
//
//
//class Node {
//    public int val;
//    public List<Node> neighbors;
//
//    public Node() {
//        val = 0;
//        neighbors = new ArrayList<Node>();
//    }
//
//    public Node(int _val) {
//        val = _val;
//        neighbors = new ArrayList<Node>();
//    }
//
//    public Node(int _val, ArrayList<Node> _neighbors) {
//        val = _val;
//        neighbors = _neighbors;
//    }
//}
//
//class Solution0 {
//  private HashSet visited = new HashSet<>();
//  public Node cloneGraph(Node node) {
//    Node clone = new Node();
//    dfs(node, clone);
//    return clone;
//  }
//
//  public void dfs(Node node, Node clone) {
//    if (visited.contains(node.val)) return;
//
//    visited.add(node.val);
//    clone.val = node.val;
//    clone.neighbors = new ArrayList();
//
//    for (int i = 0; i < node.neighbors.size(); i++) {
//      Node newNode = new Node();
//      clone.neighbors.add(newNode);
//      dfs(node.neighbors.get(i), newNode);
//    }
//  }
//
//}
//
///*
//// Definition for a Node.
//class Node {
//    public int val;
//    public List<Node> neighbors;
//
//    public Node() {
//        val = 0;
//        neighbors = new ArrayList<Node>();
//    }
//
//    public Node(int _val) {
//        val = _val;
//        neighbors = new ArrayList<Node>();
//    }
//
//    public Node(int _val, ArrayList<Node> _neighbors) {
//        val = _val;
//        neighbors = _neighbors;
//    }
//}
//*/
//class Solution {
//  private HashMap<Integer, Node> map = new HashMap();
//
//  public Node cloneGraph(Node node) {
//    if (map.containsKey(node.val)) {
//      return map.get(node.val);
//    }
//    Node clone = new Node(node.val, new ArrayList());
//    map.put(node.val, clone);
//
//    for (Node neighbor : node.neighbors) {
//      clone.neighbors.add(cloneGraph(neighbor));
//    }
//    return null;
//  }
//
//}
//
