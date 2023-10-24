class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        cnt = 0
        if len(nums) == 1 and nums[0] == k:
            return 1

        for left in range(len(nums)):
            sum = 0
            for right in range(left, len(nums)):
                sum += nums[right]
                if sum == k:
                    cnt += 1
        return cnt