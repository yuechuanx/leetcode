class Solution:
    def reverse(self, x: 'int') -> 'int':
        negative = (x < 0)
        x = abs(x)

        if x < 10 and x > -10:
            return x
        
        res = 0
        while x != 0:
            digit = x % 10
            x //= 10
            res = (10 * res) + digit
            
        if res > 2**31 - 1:
            return 0
        
        return res if not negative else -res
            