class Solution {
    public boolean reorderedPowerOf2(int n) {
        /*
        count array that basically account for all permutations of that len
        checking with powers of 2
        
        61
        0 1 0 0 0 0 1 0 0 0 //61/16
        
        0 1 0 0 0 0 0 0 0 0 //1
        0 0 1 0 0 0 0 0 0 0 //2
        0 0 0 0 1 0 0 0 0 0 //4
        0 0 0 0 0 0 0 0 1 0 //8
        ....
        */
        
        int[] num = count(n);
        
        for (int i = 0; i < 31; i++) {
            if (Arrays.equals(num, count(1 << i)))
                return true;
        }
        return false;
    }
    
    private int[] count(int n) {
        int[] arr = new int[10];
        while (n > 0) {
            arr[n % 10]++;
            n /= 10;
        }
        return arr;
    }
}