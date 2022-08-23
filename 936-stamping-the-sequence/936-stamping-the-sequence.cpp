class Solution {
public:
    vector<int> movesToStamp(string stamp, string target) {
        int stampLen = stamp.length(), targetLen = target.length();
        
        bool visited[targetLen];
        memset(visited, false, targetLen);
        vector<int> res;
        int stars = 0;
        
        while (stars < targetLen) {
            bool change = false;
            for (int i = 0; i <= targetLen - stampLen; i++) {
                if (!visited[i] && canReplace(stamp, target, i)) {
                    stars += doReplace(target, i, stampLen);
                    visited[i] = true;
                    change = true;
                    res.push_back(i);
                    
                    if (stars == targetLen) break;
                }
            }
            
            if (!change) 
                return vector<int>();
        }
        
        reverse(res.begin(), res.end());
        return res;
    }
    
    bool canReplace(string stamp, string target, int i) {
        for (int j = 0; j < stamp.length(); j++) {
            if (target[i + j] != '*' && target[i + j] != stamp[j])
                return false;
        }
        return true;
    }
    
    int doReplace(string &target, int i, int len) {
        int c = 0;
        for (int j = 0; j < len; j++) {
            if (target[i + j] != '*') {
                target[i + j] = '*';
                c++;
            }
        }
        return c;
    }
};