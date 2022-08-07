class Solution {
    private final int MOD = (int)1e9 + 7;
    
    public int countVowelPermutation(int n) {
        //dp[i][j] be the no. of strings of length i that ENDS with jth vowel
        ArrayList<Integer>[] vowel = new ArrayList[5];
        vowel[0] = new ArrayList<>(Arrays.asList(1, 2, 4));
        vowel[1] = new ArrayList<>(Arrays.asList(0, 2));
        vowel[2] = new ArrayList<>(Arrays.asList(1, 3));
        vowel[3] = new ArrayList<>(Arrays.asList(2));
        vowel[4] = new ArrayList<>(Arrays.asList(2, 3));
        
        int[][] dp = new int[n][5];
        for (int j = 0; j < 5; j++)
            dp[0][j] = 1;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                int curr = 0;
                for (int k = 0; k < vowel[j].size(); k++) {
                    curr = (curr + dp[i - 1][vowel[j].get(k)]) % MOD;
                }
                dp[i][j] = curr;
            }
        }
        int res = 0;
        for (int j = 0; j < 5; j++) 
            res = (res + dp[n - 1][j]) % MOD;
         
        return res;
    }
}

/*
a -> e
e -> a / i
i -> a / e / o / u  
o -> i / u
u -> a
*/