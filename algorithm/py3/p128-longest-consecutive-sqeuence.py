class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:
            return 0

        nums = sorted(nums)
        maxlen = currlen = 1

        for i in range(len(nums)-1):
            if nums[i] == nums[i+1]:
                continue
            if nums[i+1] - nums[i] == 1:
                currlen += 1
                # XXX must here, becasuse may not reset
                maxlen = max(maxlen, currlen)
            else:
                currlen = 1

        return maxlen