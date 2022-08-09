class Solution {
    private final int MOD = (int)1e9 + 7;
    
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        long[] dp = new long[n];
        long res = 0;
        Arrays.fill(dp, 1);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) 
            map.put(arr[i], i);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    //arr[j] is left
                    int right = arr[i] / arr[j];
                    if (map.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[map.get(right)]) % MOD;
                    }
                }
            }
            res = (res + dp[i]) % MOD;
        }
        
        return (int)res;
    }
}