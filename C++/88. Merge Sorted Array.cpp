class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        if(m <= 0 && n <= 0) return ;
        int res[m + n];
        int p = 0, q = 0;
        for(int i = 0; i < m + n; ++i) {
            if(p < m && q < n) {
                if(nums1[p] < nums2[q]) {
                    res[i] = nums1[p];
                    p++;
                } else {
                    res[i] = nums2[q];
                    q++;
                }
            } else if (p < m && q >= n) {
                res[i] = nums1[p];
                p++;
            } else if(p >=m && q < n) {
                res[i] = nums2[q];
                q++;
            } else return;
        }
        for (int i = 0; i < m + n; ++i) nums1[i] = res[i];
    }
};
