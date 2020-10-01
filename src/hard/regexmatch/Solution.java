package hard.regexmatch;

class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen= p.length();
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        dp[sLen][pLen] = true;

        for(int j = pLen -2; j >= 0; j -= 2) {
            if(p.charAt(j+1) == '*' && dp[sLen][j + 2]){
                dp[sLen][j] = true;
            }
        }

        for (int i = sLen-1; i >= 0; i--) {
            for (int j = pLen -1; j >= 0; j--) {
                boolean curr = charMatch(s.charAt(i), p.charAt(j));
                if (j + 1 < pLen &&  p.charAt(j+1) == '*' )  {
                    dp[i][j] = dp[i][j+2] || (dp[i+1][j] && curr);
                } else {
                    dp[i][j] = dp[i+1][j+1] && curr;
                }
            }
        }
        return dp[0][0];

    }
    private boolean charMatch(char s, char p) {
        return s == p || (p == '.');
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        boolean b = s.isMatch("aa", "a*");
        System.out.println(b);
    }

}