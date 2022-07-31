class NumArray {
    int[] segment;
    int[] arr;
    
    public NumArray(int[] nums) {
        int n = nums.length;
        arr = nums;
        segment = new int[4 * n];
        buildSegment(nums, 0, n - 1, 0);
    }
    
    private int buildSegment(int[] nums, int start, int end, int index) {
        if (start == end) {
            segment[index] = nums[start];
            return segment[index];
        }
        
        int mid = start + (end - start) / 2;
        segment[index] = buildSegment(nums, start, mid, 2 * index + 1) + 
                        buildSegment(nums, mid + 1, end, 2 * index + 2);
        return segment[index];
    }
    
    public void update(int i, int val) {
        int diff = val - arr[i];
        arr[i] = val;
        update(0, arr.length - 1, 0, i, diff);
    }
    
    private void update(int start, int end, int index, int i, int diff) {
        if (i < start || end < i)
            return;
        segment[index] += diff;
        
        if (start < end) {
            int mid = start + (end - start) / 2;
            update(start, mid, 2 * index + 1, i, diff);
            update(mid + 1, end, 2 * index + 2, i, diff);
        }
    }
    
    public int sumRange(int left, int right) {
        return range(left, right, 0, arr.length - 1, 0);
    }
    
    private int range(int left, int right, int start, int end, int index) {
        if (left > end || right < start)
            return 0;
        if (start >= left && end <= right)
            return segment[index];
        int mid = start + (end - start) / 2;
        return range(left, right, start, mid, 2 * index + 1) +
            range(left, right, mid + 1, end, 2 * index + 2);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */