package medium.genParen;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        recur(ans, n, 0, 0, "");
        return ans;
    }

    private void recur(List<String> ans, int n, int count, int left, String s) {
        if (left < 0 || left > n || count > n) return;

        if (n*2 == s.length() && left == 0) {
            ans.add(s);
            return;
        }
        recur(ans, n, count+1,left+1, s+ "(");
        recur(ans, n, count,left-1, s + ")");

    }

    public static void main(String[] args) {
        Solution s = new Solution();

        List<String> a = s.generateParenthesis(3);
        char c = 'd';
        String e = IntStream.range(0, 3).mapToObj(i -> Character.toString(c)).collect(Collectors.joining());

    }
}