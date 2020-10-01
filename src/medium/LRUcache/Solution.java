package medium.LRUcache;



import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


class LRUCache {

    private Map<Integer, Node> map;
    private Node start;
    private Node end;
    private Node dummy = new Node(0,0);
    private int storage, capacity;



    static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int k, int val) {
            key = k;
            value = val;
        }
    }

    public LRUCache(int capacity) {
        map = new HashMap<>();
        storage = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        Node copy = new Node(node.key, node.value);
        moveToEnd(node);

        return copy.value;
    }

    private void append(Node node){
        if (dummy.next == null) {
            dummy.next = node;
            node.prev = dummy;
            start = dummy.next;
            end = dummy.next;
        } else {
            end.next = node;
            node.prev = end;
            end = node;
        }
        map.put(node.key, node);
    }

    private void moveToEnd(Node node) {
        if (node.next == null) return;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        end.next = node;
        node.prev = end;
        end = node;
        end.next = null;
        start = dummy.next;

    }

    private void removeFirst() {
        map.remove(start.key);
        dummy.next = start.next;
        if (dummy.next != null) {
            dummy.next.prev = dummy;
        } else {
            end =null;
        }
        start = dummy.next;
    }


    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        Node targetNode = map.get(key);
        if (targetNode == null) {
            if (storage == capacity) {
                removeFirst();
            } else storage++;
            append(newNode);

        } else {
            moveToEnd(targetNode);
            targetNode.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache s = new LRUCache(2);
        s.put(9,12);
        s.put(4,30);
        s.put(9,3);

        s.get(9);
        s.put(12,24);
        s.put(5,18);
        s.put(7,23);



        int k = s.get(12);
    }
}

