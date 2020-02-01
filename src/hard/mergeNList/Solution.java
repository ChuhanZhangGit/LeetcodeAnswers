package hard.mergeNList;


import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    LinkedList<Integer> combined = new LinkedList();
    for (ListNode n : lists){
      while (n != null) {
        combined.add(n.val);
        n = n.next;
      }
    }
    if (combined.size() == 0) {
      return null;
    }
    Collections.sort(combined);
    ListNode ans = new ListNode(combined.get(0));
    ListNode curr = ans;
    for (int i = 1; i < combined.size(); i++) {
      curr.next = new ListNode(combined.get(i));
      curr = curr.next;
    }
    curr.next = null;
    return ans;

  }

  public static void main(String[] args) {
    RecursiveSolution s = new RecursiveSolution();
    ListNode[] nodeLists = NodeGenerator.genNode(new int[][] {
            {1,4,5},{1,3,4},{2,6}
    });
    ListNode head =     s.mergeKLists(nodeLists);
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
  }
}

class RecursiveSolution {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) return null;
    if (lists.length == 1) return lists[0];
    int mid = lists.length/2;
    ListNode left = mergeKLists(Arrays.copyOfRange(lists, 0, mid));
    ListNode right = mergeKLists(Arrays.copyOfRange(lists, mid , lists.length));
    return merge(left, right);


  }

  public ListNode merge(ListNode first, ListNode second) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    while (first != null && second != null) {
      if (first.val < second.val) {
        curr.next= first;
        first = first.next;
      } else {
        curr.next = second;
        second = second.next;
      }
      curr = curr.next;
    }
    if (first != null) {
      curr.next = first;
    }
    if (second != null) {
      curr.next = second;
    }
    return dummy.next;
  }
}


