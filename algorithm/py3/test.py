def guess(lo: int , hi: int) -> int:
        print(f'call guess({lo}, {hi})')
        if lo >= hi:
            return 0
        minres = 2 ** 16
        for i in range(lo, hi+1):
            res = i + max(guess(i + 1, hi), guess(lo, i - 1)) 
            minres = min(minres, res)
        print(f'call guess({lo}, {hi}), result is {minres}')
        return minres


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def getMoneyAmount(self, n: int) -> int:
        dp = [[0] * (n + 1) for _ in range(n+1)]
        for lo in range(n, 0, -1):      # lo: n to 1
            for hi in range(lo+1, n+1): # hi: lo+1 to n
                dp[lo][hi] = 2 ** 16
                for x in range(lo, hi):   
                    # 最优解下的最坏情况
                    dp[lo][hi] = min(x + max(dp[lo][x-1], dp[x+1][hi]), dp[lo][hi])
                print(dp)
        return dp[1][n]

    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        fast = slow = head
        for _ in range(k): # fast - slow = k 
            fast = fast.next
        # reverse from slow to fast - 1
        rhead, rlast = self.reverseList(slow, fast)
        newhead = rhead
        curr_last = rlast
        slow = fast
        while fast:
            for _ in range(k): # fast - slow = k 
                if fast:
                    fast = fast.next
                else:
                    curr_last.next = slow
                    return newhead
            # reverse from slow to fast - 1
            rhead, rlast = self.reverseList(slow, fast)
            curr_last.next = rhead
            curr_last = rlast
            slow = fast
        else:
            curr_last.next = slow
            return newhead

    def reverseList(self, head: ListNode, guard: ListNode) -> ListNode:
        if not head or not head.next:
            return head
        rhead = rlast = head
        curr = head.next
        rlast.next = None
        while curr is not guard:
            next = curr.next
            curr.next = rhead
            rhead = curr
            curr = next
        return rhead, rlast

    def partition(self, head: ListNode, x: int) -> ListNode:
        # check boarder condition
        minor_start = minor_end = major_start = major_end = None
        curr = head
        while curr:
            next = curr.next
            curr.next = None
            if curr.val < x:
                if not minor_start:
                    minor_start = minor_end = curr
                else:
                    minor_end.next = curr
                    minor_end = minor_end.next
            else:
                if not major_start:
                    major_start = major_end = curr
                else:
                    major_end.next = curr
                    major_end = major_end.next
            curr = next
        minor_end.next = major_start
        return minor_start

    def insertionSortList(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head
        dummy = ListNode()
        curr = head
        while curr:
            next = curr.next
            curr.next = None  # take out node
            prev = dummy      # find and insert
            while prev.next:
                if curr.val > prev.next.val:
                    prev = prev.next
                else:
                    # insert before
                    curr.next = prev.next
                    prev.next = curr
                    break
            else:
                # prev is the last node
                prev.next = curr
            curr = next
        return dummy.next

    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head or not head.next:
            return head
        slow = fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        mid = self.reverseList(slow.next)
        slow.next = None
        # reverse mid to last
        curr = head
        while curr and mid:
            next = mid.next
            mid.next = curr.next
            curr.next = mid
            curr = curr.next.next
            mid = next
        else:
            return 

    def reverseList(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head
        curr = head.next
        rhead = head
        rhead.next = None
        while curr:
            next = curr.next
            curr.next = rhead
            rhead = curr
            curr = next
        return rhead

    def isHappy(self, n: int) -> bool:
        if n == 1:
            return n
        nums = [n]
        sum = 0
        while sum != 1:
            while n > 0:
                n, last = divmod(n, 10)
                sum += last ** 2
            if sum == 1:
                return True
            if sum in nums:
                return False
            nums.append(sum)
            n = sum
            sum = 0

    def detectCycle(self, head: ListNode) -> ListNode:
        if not head or head.next is head:
            return head
        curr = head
        if not self.hasCycle(head):
            return None
        while curr.next:
            next = curr.next
            curr.next = None
            if self.hasCycle(next):
                curr = next
            else:
                return curr
    
    def hasCycle(self, head: ListNode) -> bool:
        slow = fast = head
        while fast and fast.next and fast.next.next:
            fast = fast.next.next
            slow = slow.next
            if fast == slow:
                return True
        else:
            return False

if __name__ == "__main__":
    sol = Solution()
    # rst = sol.getMoneyAmount(4)
    
    curr = dummy = ListNode()
    for i in range(1, 6):
        curr.next = ListNode(i)
        curr = curr.next

    # rhead = sol.reverseKGroup(dummy.next, 2)
    # while rhead:
    #     print(rhead.val)
    #     rhead = rhead.next

    # l = [1, 4, 3, 2, 5, 2]
    # curr = dummy = ListNode()
    # for i in l:
    #     curr.next = ListNode(i)
    #     curr = curr.next
    
    # sol.reorderList(dummy.next)
    # p = dummy.next
    # while p:
    #     print(p.val)
    #     p = p.next

    # print(sol.isHappy(19))

    node1 = ListNode(3)
    node2 = ListNode(2)
    node3 = ListNode(0)
    node4 = ListNode(4)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node2

    res = sol.detectCycle(node1)
    print(res.val)

    