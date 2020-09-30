package test;


import java.util.List;

import java.util.*;
import java.io.*;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner("2 3 4 5 6 7 8\n");
    int[] count = new int[4];
    int total = 0;
    int profit = 0;
    int[] comb = new int[3];
    List<Integer> pending = new LinkedList<>();

    for (int i = 0; i < 4; i++) {
      count[i] = sc.nextInt();
      total += count[i];
    }
    for (int i = 0; i < 3; i++) {
      comb[i] = sc.nextInt();
      pending.add(i);
    }
    while (total > 0 && !pending.isEmpty()) {
      int maxIdx  = pending.get(0);

      for (int i = 0; i < 3; i++) {
        if (pending.contains(i)) {
          if (comb[maxIdx] < comb[i]) {
            maxIdx = i;
          }
        }
      }
      int each = Math.min(count[maxIdx], count[3]);
      profit += comb[maxIdx] * each;
      count[maxIdx] -= each;
      count[3] -= each;
      pending.remove(pending.indexOf(maxIdx));
      total -= each * 2;
    }
    System.out.print(profit);


  }
}