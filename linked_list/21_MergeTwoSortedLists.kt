/*
	https://leetcode.com/problems/merge-two-sorted-lists/description/
	Time: O(n)
	Space: O(1)
	Algorithm: 
		- Create a dummy node and a pointer to it
		- While both lists are not null
			- If the value of list1 is greater than list2
				- Set the next node of the dummy node to list2
				- Set list2 to the next node of list2
			- Else
				- Set the next node of the dummy node to list1
				- Set list1 to the next node of list1		

			- Append the non-null list to the end of the dummy node
		- Return the next node of the dummy node
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
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var head1 = list1
        var head2 = list2
        var result = ListNode(0)
        var cur = result

        while (head1 != null && head2 != null) {
            if (head1.`val` > head2.`val`) {
                cur.next = head2
                head2 = head2.next
            } else {
                cur.next = head1
                head1 = head1.next
            }

            cur = cur.next
        }

        if (head1 != null) cur.next = head1
        else if (head2 != null) cur.next = head2

        return result.next
    }
}