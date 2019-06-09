class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {} 
        for i, num in enumerate (nums):
            if target - num in map:
                return [i, map[target-num]]
            map[num] = i
            
        return []
        
        
        