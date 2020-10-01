package medium.trieWord;

import java.util.ArrayDeque;
import java.util.Deque;

class WordDictionary {

    private Node root;

    static class Node {

        Node[] children = new Node[26];
        Boolean isEnd = false;
        int level = 0;
    }

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
        root.level = 0;
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int level = curr.level;
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
            curr.level = level+1;
        }
        curr.isEnd = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchNode(root, word, 0);

    }

    private boolean searchNode(Node curr, String word, int level) {
        if (level == word.length()) return curr.isEnd;

        if (word.charAt(level) == '.') {
            for (Node n : curr.children) {
                if (n != null && searchNode(n, word, level+1)) {
                    return true;
                }
            }
        } else {
            int index = word.charAt(level)-'a';
            if (curr.children[index] != null && searchNode(curr.children[index], word, level+1)) {
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        WordDictionary w = new WordDictionary();
        w.addWord("at");
        w.addWord("a");
        boolean b = w.search("atd");
        System.out.println(b);
    }
}