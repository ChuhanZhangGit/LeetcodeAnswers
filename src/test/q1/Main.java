package test.q1;

import java.util.*;
import java.io.*;

public class Main {
    private static class Shelf {
        boolean[] isLocked;
        int[] bookRow;
        boolean[] isBorrowed;


        public Shelf(int N, int M) {
            isLocked = new boolean[N];
            bookRow = new int[M];
            Arrays.fill(bookRow, -1);
            isBorrowed = new boolean[M];
        }

        public void insert(int bookId, int row) {
            if (bookId >= bookRow.length) return;
            if (bookRow[bookId] == -1) {
                if (isBorrowed[bookId]) return;

                bookRow[bookId] = row;
            } else {
                if (isLocked[bookRow[bookId]] || isBorrowed[bookId]) return;
                bookRow[bookId] = row;
            }
        }

        public void lock(int row) {
            if (row >= isLocked.length) return;
            isLocked[row] = true;
        }

        public void unlock(int row) {
            if (row >= isLocked.length) return;
            isLocked[row] = false;
        }

        public int borrow(int bookId) {
            if (bookId >= bookRow.length || isLocked[bookRow[bookId]] || isBorrowed[bookId])
                return -1;
            return bookRow[bookId];
        }

        public void returnBk(int bookId) {
            if (bookId >= bookRow.length) return;
            isBorrowed[bookId] = false;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner("5 5 10\n" +
                "1 1 4\n" +
                "1 2 3\n" +
                "1 3 1\n" +
                "2 1\n" +
                "4 1\n" +
                "5 2\n" +
                "4 3\n" +
                "4 5\n" +
                "3 1\n" +
                "4 2");
        int N = sc.nextInt();
        int M = sc.nextInt();
        int Q = sc.nextInt();
        Shelf shelf = new Shelf(N, M);
        while (Q-- > 0) {
            sc.nextLine();
            int command = sc.nextInt();
            if (command == 1) {
                shelf.insert(sc.nextInt(), sc.nextInt());
            } else if (command == 2) {
                shelf.lock(sc.nextInt());
            } else if (command == 3) {
                shelf.unlock((sc.nextInt()));
            } else if (command == 4) {
                System.out.println(shelf.borrow(sc.nextInt()));
            } else {
                shelf.returnBk(sc.nextInt());
            }
        }
    }
}
