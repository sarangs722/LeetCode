class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] countMag = new int[26];
        
        for (char c : magazine.toCharArray())
            countMag[c - 'a']++;
        
        for (char c : ransomNote.toCharArray()) {
            countMag[c - 'a']--;
            if (countMag[c - 'a'] < 0)
                return false;
        }
        
        return true;
    }
}