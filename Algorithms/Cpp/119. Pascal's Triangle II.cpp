class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<int> res;
        if(rowIndex < 0) return res;

        res.assign(rowIndex + 1, 0);
        for(int i = 0; i <= rowIndex; ++i) {
            if(i == 0) {
                res[0] = 1;
                continue;
            }
            for(int j = rowIndex; j >= 1; --j) {
                res[j] = res[j] + res[j - 1];
            }
        }
        return res;
    }
};
