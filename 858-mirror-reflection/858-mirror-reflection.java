class Solution {
    public int mirrorReflection(int p, int q) {
        //m * p = n * q
        //observe test cases, and derive
        //extend the mirror m times instead of bouncing and finding appropriate points of reflection (easier)
        
        int m = q, n = p;
        while (m % 2 == 0 && n % 2 == 0) {
            m /= 2; 
            n /= 2;
        }
        
        //even, odd
        if (m % 2 == 0 && n % 2 != 0) return 0;
        //odd, odd
        if (m % 2 != 0 && n % 2 != 0) return 1;
        //odd, even
        if (m % 2 != 0 && n % 2 == 0) return 2;
        
        return -1;
    }
}