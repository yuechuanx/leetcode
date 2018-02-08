class Solution {
public:
    bool judgeCircle(string moves) {
        int h = 0;
        int v = 0;
        for(char ch : moves) {
            switch(ch) {
                case 'U': v++; break;
                case 'D': v--; break;
                case 'L': h--; break;
                case 'R': h++; break;
            }
        }
        return v == 0 && h == 0;
    }
};
