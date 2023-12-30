/*
	https://leetcode.com/problems/maximum-depth-of-binary-tree/
	Time: O(n)
	Space: O(n)
	Algorithm:
		- The max depth of a tree at a node is the max of the max depth of its left and right subtrees + 1
		- Recurse down the tree and return the max depth of the left and right subtrees at each node

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
    fun maxDepth(root: TreeNode?): Int {
        root ?: return 0

        return 1 + max(
            maxDepth(root.right),
            maxDepth(root.left)
        )
    }
}