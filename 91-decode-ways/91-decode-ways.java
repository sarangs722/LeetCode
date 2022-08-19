class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        return s.isEmpty() ? 0 : decode(s, 0, memo);
    }
    
    private int decode(String s, int i, int[] memo) {
        if (memo[i] != -1)
            return memo[i];
        
        int n = s.length();
        if (i == n)
            return 1;
        if (s.charAt(i) == '0')
            return 0;
       
        int d = decode(s, i + 1, memo);
        if (i < n - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) 
            d += decode(s, i + 2, memo);
        
        return memo[i] = d;
    }
}