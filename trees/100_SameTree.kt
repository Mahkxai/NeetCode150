/*
	https://leetcode.com/problems/same-tree/description/
	Time: O(n)
	Space: O(1)
	Algorithm:
		- If the values of the nodes are not equal, return false
		- If both nodes are null, return true
		- Recursively call isSameTree on the left and right nodes
	
*/

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p?.`val` != q?.`val`) return false

        if (p == null || q == null) return true

        return (
            isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
        )
    }
}