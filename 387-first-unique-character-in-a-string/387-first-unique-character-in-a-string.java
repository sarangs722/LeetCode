class Solution {
    public int firstUniqChar(String s) {
        int index = -1;
        HashMap<Character, Integer> repeat = new HashMap<Character, Integer>();
        
        for (char c : s.toCharArray()) 
            repeat.put(c, repeat.getOrDefault(c, 0) + 1);
        
        for (int i = 0; i < s.length(); i++) {
            if (repeat.get(s.charAt(i)) == 1)
                return i;
        }
        
        return -1;
    }
}