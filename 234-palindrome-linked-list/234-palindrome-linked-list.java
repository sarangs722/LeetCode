/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        
        ListNode slow = head, fast = head, first = head, second = null;
        
        while (fast != null && fast.next != null) {
            // prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (fast == null)
            second = slow;
        else
            second = slow.next;
        
        if (second != null) 
            second = reverseLL(second);
        
        while (first != null && second != null) {
            if (first.val != second.val) return false;
            first = first.next;
            second = second.next;
        }
        
        return true;
    }
    
    private ListNode reverseLL(ListNode node) {
        ListNode prev = null, curr = node, temp = null;
        
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
}