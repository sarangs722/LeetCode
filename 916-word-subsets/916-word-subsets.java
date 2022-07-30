class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] freq = new int[26];
        List<String> res = new ArrayList<String>();
        
        for (String word : words2) {
            int[] local = new int[26];
            for (char c : word.toCharArray()) {
                local[c - 'a']++;
                freq[c - 'a'] = Math.max(local[c - 'a'], freq[c - 'a']);
            }
        }
        
        for (String word : words1) {
            int[] local = new int[26];
            for (char c : word.toCharArray()) {
                local[c - 'a']++;
            }
            int i;
            for (i = 0; i < 26; i++) {
                if (local[i] < freq[i])
                    break;
            }
            if (i == 26)
                res.add(word);
        }
        
        return res;
    }
}