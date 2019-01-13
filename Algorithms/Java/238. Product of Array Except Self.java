class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        int[] res = new int[n];
        
        for (int i = 0; i < n; ++i) {
            int product = 1;
            int tmp = nums[i];
            nums[i] = 1;
            for (int j = 0; j < n; ++j) {
                product *= nums[j];
            }
            res[i] = product; 
            nums[i] = tmp;
         }
        
        return res;
    }
}


class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int firstZeroIdx = -1, cntZero = 0;
        
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0 && firstZeroIdx == -1) {
                cntZero++;
                firstZeroIdx = i;
            }
        }
        
        int product = 1;
        if (cntZero == 0) {
            for (int i = 0; i < n; ++i) {
                product *= nums[i];
            }
            for (int i = 0; i < n; ++i) {
                nums[i] = product / nums[i];
            }
            return nums;
        } else if (cntZero == 1) {
            nums[firstZeroIdx] = 1;
            for (int i = 0; i < n; ++i) {
                product *= nums[i];
            }
            int[] res = new int[n];
            res[firstZeroIdx] = product;
            return res;
        } else {
            int[] res = new int[n];
            return res;
        }
]  
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}