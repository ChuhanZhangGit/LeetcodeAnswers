package medium.FrequentK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
  public List<Integer> topKFrequent(int[] nums, int k) {

    Map<Integer, Integer> map = new HashMap();
    for (int num : nums) {
      map.put(num, map.getOrDefault((num),0) +1);

    }

    PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue<>(
            (a,b) -> b.getValue() - a.getValue());

    for (Map.Entry n : map.entrySet()) {
      maxHeap.add(n);
    }
    List<Integer> kFrequent = new ArrayList();
    while (kFrequent.size() < k) {
      kFrequent.add(maxHeap.poll().getKey());
    }

    return kFrequent;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.topKFrequent(new int[]{1,1,1,2,2,3}, 2));
  }
}