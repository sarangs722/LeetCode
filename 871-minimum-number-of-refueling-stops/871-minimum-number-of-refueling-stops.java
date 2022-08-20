class Solution {
    //Heap
    //O(N.log(N))
    public int minRefuelStops(int target, int tank, int[][] stations) {
        //maxheap
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        
        int minStops = 0, prev = 0;
        for (int[] station : stations) {
            int pos = station[0];
            int cap = station[1];
            tank -= (pos - prev);
            
            while (!pq.isEmpty() && tank < 0) {
                tank += pq.poll();
                minStops++;
            }
            
            //not possible
            if (tank < 0)
                return -1;
            pq.offer(cap);
            prev = pos;
        }
        
        //for target
        tank -= target - prev;
        
        while (!pq.isEmpty() && tank < 0) {
            tank += pq.poll();
            minStops++;
        }
        if (tank < 0) return -1;
        
        return minStops;
    }
}

/*

//DP
    //O(N^2)
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        long[] dp = new long[n + 1];
        dp[0] = startFuel;
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (dp[j] >= stations[i][0])
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + (long)(stations[i][1]));
            }
        }
        
        for (int i = 0; i <= n; i++)
            if (dp[i] >= target)
                return i;
        return -1;
    }

*/