class Solution {
    public int uniquePaths(int m, int n) {
        int i = m - 1 + n - 1, j = 1;
        long res = 1;
        //number of different ways to choose m-1 down-moves and n-1 right-moves from a total of m+n-2 moves
        while (i >= (Math.max(m, n))) {
            res = (res * i) / j;
            i--; j++;
        }
        
        return (int)res;
    }
}