class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1, maxArea = 0;
        
        while (left < right) {
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, w * h);
            if (height[left] >= height[right]) {
                right--;
            } else {
                left++;
            } 
        }
        
        return maxArea;
    }
}

// clean code
class Solution {
	public int maxArea(int[] height) {
		 int maxArea = 0;
        
		 for(int left = 0, right = height.length - 1; left < right; ){
			 int h = (height[left] < height[right]) ? height[left++] : height[right--];
			 maxArea = Math.max(maxArea, (right-left+1) * h);
		 }
		 
        return maxArea;
	 }
}