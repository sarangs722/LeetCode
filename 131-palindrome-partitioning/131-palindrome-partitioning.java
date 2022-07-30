class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(s, res, new ArrayList<String>(), 0);
        return res;
    }
    
    private void dfs(String s, List<List<String>> res, List<String> curr, int start) {
        if (start >= s.length()) 
            res.add(new ArrayList<String>(curr));
        
        for (int end = start; end < s.length(); end++) {
            if (palindromeCheck(s, start, end)) {
                curr.add(s.substring(start, end + 1));
                
                dfs(s, res, curr, end + 1);
                
                curr.remove(curr.size() - 1);
            }
            
        }
    }
    
    private boolean palindromeCheck(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}