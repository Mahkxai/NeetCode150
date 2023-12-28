/*
	https://leetcode.com/problems/product-of-array-except-self/description/
	Time: O(n)
	Space: O(n)
	Algorithm:
		- Create a result array
		- Create a prefix variable to store the product of all numbers before the current number
		- Create a postfix variable to store the product of all numbers after the current number
		- Iterate through the array and store the prefix product of each number in the result array
		- Iterate through the array from the end to the beginning and store the postfix product of each number in the result array
		- Return the result array
*/


class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        var prefix = 1
        var postfix = 1

        nums.forEachIndexed { i, n ->
            result[i] = prefix
            prefix *= n
        }

        for (i in nums.size -1 downTo 0 ) {
            result[i] *= postfix
            postfix *= nums[i]
        }

        return result
    }
}