class Solution:
    def maxArea(self, height: List[int]) -> int:
        max_area = -1
        left, right = 0, len(height) - 1
        while left < right:
            area = min(height[left], height[right]) * (right - left)
            max_area = max(max_area, area)
            if height[left] == height[right]:
                left += 1
            elif height[left] > height[right]:
                right -= 1
            else:
                left += 1

        return max_area