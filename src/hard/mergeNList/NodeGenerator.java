package hard.mergeNList;

public class NodeGenerator {
  public static ListNode[] genNode(int[][] lists) {
    ListNode[] nodeList = new ListNode[lists.length];
    for (int i = 0; i < lists.length; i++) {
      ListNode head = null;
      if (lists[i].length > 0) {
        head = new ListNode(lists[i][0]);
        ListNode curr = head;
        for (int j = 1; j < lists[i].length; j++) {
          curr.next = new ListNode(lists[i][j]);
          curr = curr.next;
        }
        curr.next = null;
      }


      nodeList[i] = head;
    }
    return nodeList;
  }
}
