/*
	https://leetcode.com/problems/invert-binary-tree/description/
	Time: O(n)
	Space: O(n)
	Algorithm:
		- Swap left and right child of each node
		- Recursively call invertTree on left and right child
		- Return root
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
    fun invertTree(root: TreeNode?): TreeNode? {
        root ?: return null

        val temp = root.left
        root.left = root.right
        root.right = temp

        invertTree(root.left)
        invertTree(root.right)
        return root
    }
}