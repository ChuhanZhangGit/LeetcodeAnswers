package medium.reorderList;


class ListNode {
     int val;
      ListNode next;
     ListNode(int x) { val = x; }
  }

public class Solution {
  public void reorderList(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }


    ListNode curr = slow.next;
    slow.next = null;

    ListNode pre = null;

    while (curr != null) {
      ListNode temp = curr.next;
      curr.next = pre;
      pre = curr;
      curr = temp;
    }
    ListNode mid = pre;
    curr = head;

    while (curr != null && mid != null) {
      ListNode currNext = curr.next;
      ListNode midNext = mid.next;

      curr.next = mid;
      mid.next= currNext;

      curr = currNext;
      mid = midNext;
    }
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode h2 = new ListNode(2);
    ListNode h3 = new ListNode(3);
    ListNode h4 = new ListNode(4);
    ListNode h5 = new ListNode(5);

    head.next =h2;
    h2.next = h3;
    h3.next =h4;
//    h4.next =h5;

    Solution s = new Solution();
    s.reorderList(head);
  }
}