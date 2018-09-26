/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode quick = dummy, slow = dummy;
        
        // 让快指针往后移动n+1个位置
        for (int i = 0; i < n + 1; ++i) {
            quick = quick.next;
        }
        // 当快指针移动到null时，慢指针移动到所删除节点的前置节点
        while (quick != null) {
            quick = quick.next;
            slow = slow.next;
        } 
        // 删除节点操作
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}