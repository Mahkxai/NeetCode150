/*
	https://leetcode.com/problems/container-with-most-water/description/
	Time: O(N)
	Space: O(1)
	Algorithm:
		- Use two pointers, one at the start and one at the end
		- Calculate the area between the two pointers
		- Move the pointer with the smaller height inwards
		- Repeat until the two pointers meet
		- Return the maximum area
*/

class Solution {
    fun maxArea(height: IntArray): Int {
        val N = height.size
        var left = 0
        var right = N - 1
        var area = 0

        while (left < right) {
            val effectiveHeight = min(height[left], height[right])
            val width = right - left
            area = max(area, effectiveHeight * width)

            when {
                height[left] > height[right] -> right--
                else -> left++
            }
        }        

        return area
    }
}