class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>(); //freq of all elements
        Map<Integer, Integer> tail = new HashMap<>(); //subseq ending at particular element
        
        for (int i : nums)
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        
        for (int i : nums) {
            if (freq.get(i) == 0)
                continue;
            freq.put(i, freq.get(i) - 1); //freq[i]--;
            
            if (tail.getOrDefault(i - 1, 0) > 0) {
                //tail now ends at i, instead of i - 1
                tail.put(i - 1, tail.getOrDefault(i - 1, 0) - 1); //tail[i - 1]--;
                tail.put(i, tail.getOrDefault(i, 0) + 1); //tail[i]++;
            }
            else if (freq.getOrDefault(i + 1, 0) > 0 && freq.getOrDefault(i + 2, 0) > 0) {
                //eg: if i = 4, then we need 5 and 6 in the array for subseq to be possible
                freq.put(i + 1, freq.get(i + 1) - 1); //freq[i + 1]--;
                freq.put(i + 2, freq.get(i + 2) - 1); //freq[i + 2]--;
                tail.put(i + 2, tail.getOrDefault(i + 2, 0) + 1); //tail[i + 2]++;
            }
            else {
                //No previous subseq with tail i - 1 exixts
                //No upcoming elements with value i + 1 and i + 2 exists
                //So, not possible
                return false;
            }
        }
        
        return true;
    }
}