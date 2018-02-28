// O(nlogn) incorrect!!!
class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        for(int i = 0; i < numbers.size(); ++i) {
            int t = target - numbers[i], left = i + 1, right = numbers.size() - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if(numbers[mid] == t) return {i + 1, mid + 1}; // +1 因为index相比下标增1
                else if(numbers[mid] < t) left = mid + 1;
                else right = mid - 1;
            }
        }
        return {}; // 这标明使用函数返参类型进行默认构造
    }
};

// O(n)
class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int l = 0, r = numbers.size() - 1;
        while(l < r) {
            int sum = numbers[l] + numbers[r];
            if(sum == target) return {l + 1, r + 1};
            else if(sum < target) ++l;
            else --r;
        }
        return {};
    }
};
