class Solution {
public:
    bool isPowerOfThree(int n) {
        int maxPowerOfThree = (int)log(INT_MAX) / log(3);
        int maxPower = (int)pow(3, maxPowerOfThree);
        return n > 0 && maxPower % n == 0;
    }
};