class Solution {
    private List<List<String>> res;
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        res = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap<>();
        for (String word : wordList)
            graph.put(word, new ArrayList<>());
        
        //beginword not in graph, then add
        if (!graph.containsKey(beginWord)) {
            wordList.add(beginWord);
            graph.put(beginWord, new ArrayList<>());
        }
        
        for (String s : wordList) {
            for (int i = 0; i < s.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    String temp = s.substring(0, i) + c + s.substring(i + 1);
                    if (graph.containsKey(temp) && !s.equals(temp)) {
                        List<String> curr = graph.get(s);
                        curr.add(temp);
                        graph.put(s, curr);
                    }
                }
            }
        }
        
        HashSet<String> visited = new HashSet<>(wordList.size());
        Map<String, Integer> distanceStart = new HashMap<>();
        
        int shortestLength = bfs(beginWord, endWord, graph, visited, distanceStart);
        if (shortestLength == 0) return res;
        
        reverseDFS(endWord, beginWord, new ArrayList<>(), graph, distanceStart);
        
        return res;
    }
    
    private int bfs(String src, String des, Map<String, List<String>> graph, 
                    HashSet<String> visited, Map<String, Integer> distanceStart) {
        
        Queue<String> queue = new LinkedList<>();
        queue.add(src);
        visited.add(src);
        
        int level = 0;
        distanceStart.put(src, 0);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String curr = queue.remove();
                if (curr.equals(des))
                    return level;
                
                for (String n : graph.get(curr)) {
                    if (!visited.contains(n)) {
                        visited.add(n);
                        queue.add(n);
                        distanceStart.put(n, distanceStart.get(curr) + 1);
                    }
                }
            }
            level++;
        }
        return 0;
    }
    
    private void reverseDFS(String src, String des, List<String> path, Map<String, List<String>> graph, Map<String , Integer> distanceStart) {
        
        if (src.equals(des)) {
            path.add(des);
            List<String> list = new ArrayList<>(path);
            Collections.reverse(list);
            
            res.add(list);
            path.remove(path.size() - 1);
            return;
        }
        path.add(src);
        
        for (String next : graph.get(src)) {
            if(distanceStart.containsKey(next) && distanceStart.get(next) + 1 == distanceStart.get(src)) {
                reverseDFS(next, des, path, graph, distanceStart);
            }
        }
        
        path.remove(path.size() - 1);
    }
}