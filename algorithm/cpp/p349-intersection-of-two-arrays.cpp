class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        set<int> s(nums1.begin(), nums1.end()), res;
        for(auto a : nums2) {
            if(s.count(a)) res.insert(a);
        }
        return vector<int>(res.begin(), res.end());
    }
};
