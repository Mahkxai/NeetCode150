/*
	https://leetcode.com/problems/reverse-linked-list/
	Time: O(n)
	Space: O(1)
	Algorithm Description:
		- Iterate through the list
		- Use 3 pointers: prev, cur, next
		- While cur is not null, reverse the pointers for each node:
			- Store cur.next in next
			- Set cur.next to prev
			- Set prev to cur
			- Set cur to next
*/

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) return null

        var prev: ListNode? = null
        var cur = head

        while (cur != null) {
            val next = cur.next
            cur.next = prev
            prev = cur
            cur = next
        }

        return prev    
    }
}