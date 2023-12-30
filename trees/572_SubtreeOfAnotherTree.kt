/*
	https://leetcode.com/problems/subtree-of-another-tree/description/
	Time: O(n)
	Space: O(n)
	Algorithm:
		- If any of the following is true, return true:
			- The root is null
			- The left node is the same as the subtree
			- The right node is the same as the subtree
			- The current node is the same as the subtree
		- Else, return false
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

    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        root ?: return false

        return (
            isSubtree(root.left, subRoot) || 
            isSubtree(root.right, subRoot) || 
            isSameTree(root, subRoot)
        )
    }
}