// 四重循环，初始做法，待改进
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; ++i) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < n - 2; ++j) {
                if(j > i + 1 && nums[j] == nums[j-1]) continue;
                for (int k = j + 1; k < n -1; ++k) {
                    if(k > j + 1 && nums[k] == nums[k-1]) continue;
                    for (int l = k + 1; l < n; ++l) {
                        if(l > k + 1 && nums[l] == nums[l-1]) continue;
                        List<Integer> tmp = new ArrayList<>();
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            tmp.add(nums[i]);
                            tmp.add(nums[j]);
                            tmp.add(nums[k]);
                            tmp.add(nums[l]);
                            res.add(tmp);
                        }
                    }
                }
            }
        }
        
        return res;
    }
}

// time complexity: O(n^3)
public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if(num.length<4)return ans;
        Arrays.sort(num);
        for(int i=0; i<num.length-3; i++){
            if(num[i]+num[i+1]+num[i+2]+num[i+3]>target)break; //first candidate too large, search finished
            if(num[i]+num[num.length-1]+num[num.length-2]+num[num.length-3]<target)continue; //first candidate too small
            if(i>0&&num[i]==num[i-1])continue; //prevents duplicate result in ans list
            for(int j=i+1; j<num.length-2; j++){
                if(num[i]+num[j]+num[j+1]+num[j+2]>target)break; //second candidate too large
                if(num[i]+num[j]+num[num.length-1]+num[num.length-2]<target)continue; //second candidate too small
                if(j>i+1&&num[j]==num[j-1])continue; //prevents duplicate results in ans list
                int low=j+1, high=num.length-1;
                while(low<high){
                    int sum=num[i]+num[j]+num[low]+num[high];
                    if(sum==target){
                        ans.add(Arrays.asList(num[i], num[j], num[low], num[high]));
                        while(low<high&&num[low]==num[low+1])low++; //skipping over duplicate on low
                        while(low<high&&num[high]==num[high-1])high--; //skipping over duplicate on high
                        low++; 
                        high--;
                    }
                    //move window
                    else if(sum<target)low++; 
                    else high--;
                }
            }
        }
        return ans;
    }
    }