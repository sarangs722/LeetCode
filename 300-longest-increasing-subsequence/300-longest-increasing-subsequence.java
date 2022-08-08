class Solution {
    //O(N.logN)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> sub = new ArrayList();
        
        for (int curr : nums) {
            if (sub.isEmpty() || sub.get(sub.size() - 1) < curr)
                sub.add(curr);
            else {
                int idx = lowerBound(sub, curr);
                sub.set(idx, curr);
            } 
        }
        
        return sub.size();
    }
    
    static int lowerBound(ArrayList<Integer> a, int ele) {
        int low = 0, high = a.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (ele > a.get(mid)) 
                low = mid + 1;
            else 
                high = mid;
        }
        return low;
    }
}

/*
//O(n^2)
public int lengthOfLIS(int[] nums) {
        int n = nums.length, res = 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            }
            res = Math.max(dp[i], res);
        }
        
        return res;
    }
*/