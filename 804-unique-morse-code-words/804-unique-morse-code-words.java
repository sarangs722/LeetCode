class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-", "..-","...-",".--","-..-","-.--","--.."};
        
        Set<String> transformations = new HashSet<>();
        
        for (String word : words) {
            StringBuilder curr = new StringBuilder("");
            for (char c : word.toCharArray()) 
                curr.append(morse[c - 'a']);
            
            transformations.add(curr.toString());
        }
        
        return transformations.size();
    }
}