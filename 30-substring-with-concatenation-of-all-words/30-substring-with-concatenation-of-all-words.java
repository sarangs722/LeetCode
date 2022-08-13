class Solution {
    private HashMap<String, Integer> wordCount;
    private int n, wordLength, substringSize, k;
    
    public List<Integer> findSubstring(String s, String[] words) {
        wordCount = new HashMap<>();
        n = s.length();
        k = words.length;
        wordLength = words[0].length();
        substringSize = wordLength * k;
        
        for (String word : words) 
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        
        List<Integer> res = new ArrayList<>();
        //iterating for wordLength, to account for starting at each index, then index + wordLength
        //s = "xyfoobar", words = ["foo","bar"]
        //iterate for i = 0 < 3
        
        for (int i = 0; i < wordLength; i++)
            slidingWindow(i, s, res);
        
        return res;
    }
    
    private void slidingWindow(int left, String s, List<Integer> res) {
        HashMap<String, Integer> wordsFound = new HashMap<>();
        int wordsUsed = 0;
        boolean excessWord = false;
        
        for (int right = left; right <= n - wordLength; right += wordLength) {
            String sub = s.substring(right, right + wordLength);
            if (!wordCount.containsKey(sub)) {
                //Word not there
                wordsFound.clear();
                wordsUsed = 0;
                excessWord = false;
                left = right + wordLength;
            }
            else {
                //if reach maxWindowSize or excessWord is there
                while (right - left == substringSize || excessWord) {
                    String leftmostWord = s.substring(left, left + wordLength);
                    left += wordLength;
                    wordsFound.put(leftmostWord, wordsFound.get(leftmostWord) - 1);
                    if (wordsFound.get(leftmostWord) >= wordCount.get(leftmostWord))
                        //word was excess word, not fixed
                        excessWord = false;
                    else
                        //we need it in future
                        wordsUsed--;
                }
                
                //keeping track of word
                wordsFound.put(sub, wordsFound.getOrDefault(sub, 0) + 1);
                if (wordsFound.get(sub) <= wordCount.get(sub)) 
                    wordsUsed++;
                else
                    excessWord = true;
                
                if (wordsUsed == k && !excessWord)
                    res.add(left);
            }
        }
    }
}