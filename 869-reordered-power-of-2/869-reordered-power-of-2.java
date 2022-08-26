class Solution {
    public boolean reorderedPowerOf2(int n) {
        if ((n & (n - 1)) == 0)
            return true;

        char[] num = String.valueOf(n).toCharArray();
        return reorder(num, 0);
    }
    
    private boolean reorder(char[] num, int i) {
        if (i == num.length - 1) {
            if (num[0] == '0') return false;
            int n = Integer.parseInt(new String(num));
            if ((n & (n - 1)) == 0)
                return true;
        }
        for (int j = i; j < num.length; j++) {
            swap(num, i, j);
            if (reorder(num, i + 1))
                return true;
            swap(num, j, i);
        }
        
        return false;
    }
    
    private void swap(char[] num, int i, int j) {
        char temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}