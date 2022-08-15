class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.add(beginWord);
        if (!wordSet.contains(endWord))
            return 0;
        
        Set<String> visited = new HashSet<>();
        
        Queue<String> path = new LinkedList<>();
        path.offer(beginWord);
        
        int level = 1;
        
        while (!path.isEmpty()) {
            int size = path.size();
            
            while (size--> 0) {
                String word = path.poll();
                if (word.equals(endWord))
                    return level;
                
                for (int i = 0; i < word.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char[] curr = word.toCharArray();
                        curr[i] = c;
                        
                        String temp = new String(curr);
                        if (wordSet.contains(temp) && !visited.contains(temp)) {
                            path.offer(temp);
                            visited.add(temp);
                        }
                    }
                }
            }
            level++;
        }
        
        return 0;
    }
}