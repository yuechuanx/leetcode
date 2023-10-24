#include<iostream>
#include<vector>

using namespace std;

// 待修正
class Solution {
public:
    
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
    int m = nums1.size(), n = nums2.size();
    int media = (m + n) / 2;
    bool isOdd = ((m + n) % 2 == 0) ? false : true;

    // assume nums1 and nums2 cannot be both empty
    if (nums1.empty() || nums2.empty()) {
        if (nums1.empty()) {
            if (isOdd) {
                return (double)(nums2[media] + nums2[media + 1])/2;
            } else {
                return (double)nums2[media];
            }
        } else {
            if (m % 2 == 0) {
                return (double)(nums1[media] + nums1[media + 1])/2;
            } else {
                return (double)nums1[media];
            }
        }
    }

    // nums1, nums2 both not be empty
    int count = 0, i = 0, j = 0, curr = -1;
    for ( ; i < m, j < n; ) {
        if (nums1[i] > nums2[j]) {
            curr = nums2[j];
            j++;
            count++;
        } else {
            curr = nums1[i];
            i++;
            count++;
        }
        if (count == media) {
            if (isOdd) {
                return (double)curr;
            } else {
                return nums1[i] > nums2[j] ? (double)(curr + nums2[j]) / 2 : (double)(curr + nums1[i]) / 2;
            }
        }
    }
}

    int main(int argc, char const *argv[])
    {
        vector<int> nums1 = {1, 3, 5, 7, 9};
        vector<int> nums2 = {2, 4, 6, 8, 10};
        cout << findMedianSortedArrays(nums1, nums2) << endl;
        return 0;
    }
    
};


class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int m = nums1.size(), n = nums2.size();
        // make sure size of first > size of second
        if (m < n) return findMedianSortedArrays(nums2, nums1);
        if (n == 0) return ((double)nums1[(m - 1) / 2] + (double)nums1[m / 2]) / 2.0;
        
        int left = 0, right = n * 2; // right = 2
        while (left <= right) {
            int mid2 = (left + right) / 2; // mid2 = 1
            int mid1 = m + n - mid2; // mid1 = 2
            double l1 = mid1 == 0 ? INT_MIN : nums1[(mid1 - 1) / 2];  // l1 = nums1[0] = 1
            double l2 = mid2 == 0 ? INT_MIN : nums2[(mid2 - 1) / 2];  // l2 = nums2[0] = 2
            double r1 = mid1 == m * 2 ? INT_MAX : nums1[mid1 / 2];  // r1 = nums1[1] = 3
            double r2 = mid2 == n * 2 ? INT_MAX : nums2[mid2 / 2];  // r2 = nums2[0] = 2
            if (l1 > r2) left = mid2 + 1; 
            else if (l2 > r1) right = mid2 - 1;
            else return (max(l1, l2) + min(r1, r2)) / 2; 
        }
        return -1;
    }
};


class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        const int m = nums1.size();
        const int n = nums2.size();
        int total = m + n;
        if (total & 0x1) {
            return find_kth(nums1.begin(), m, nums2.begin(), n, total / 2 + 1);
        } else {
            return (find_kth(nums1.begin(), m, nums2.begin(), n, total / 2) 
                + find_kth(nums1.begin(), m, nums2.begin(), n, total / 2 + 1)) / 2.0;
        }
    }
    
private:
    static int find_kth(std::vector<int>::const_iterator A, int m,
                       std::vector<int>::const_iterator B, int n, int k) {
        // make sure m <= n
        if (m > n) return find_kth(B, n, A, m, k);
        if (m == 0) return *(B + k - 1);
        if (k == 1) return min(*A, *B);
        
        int ia = min(k / 2, m), ib = k - ia;
        if ((*A + ia -1) < *(B + ib -1))
            // 缩小范围，可以排除A[0] 到 A[ia]之间的数
            return find_kth(A + ia, m - ia, B, n, k -ia);
        else if (*(A + ia - 1)> *(B + ib -1))
            return find_kth(A, m, B + ib, n - ib, k - ib);
        else 
            return A[ia - 1];
    }
};