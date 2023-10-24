class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # corner case: all zeros
        if not any(nums):
            return

        n = len(nums)
        left = right = 0
        while right < n:
            if nums[right]:
                nums[left], nums[right] = nums[right], nums[left]
                left += 1
            right += 1
