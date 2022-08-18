class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : arr)
            count.put(i, count.getOrDefault(i, 0) + 1);
        
        ArrayList<Integer> countArray = new ArrayList<>(count.values());
        Collections.sort(countArray);
        Collections.reverse(countArray);
        
        int size = arr.length, res = 0, i = 0;
        while (i < countArray.size() && size > arr.length / 2) {
            res++;
            size -= countArray.get(i++);
        }
            
        return res;
    }
}