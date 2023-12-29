/*
	https://leetcode.com/problems/3sum/
	Time: O(n^2)
	Space: O(n)
	Algorithm:
		- Sort the array
		- Iterate through the array
			- If the current number is greater than 0, break
			- If the current number is the same as the previous number, continue to avoid duplicates
			- For each number in the array
				- Set the left pointer to the current index + 1 and the right pointer to the end of the array
				- While left is less than right
					- Calculate sum of the current number, left number, and right number
					- If the sum is greater than 0, we need a smaller number so decrement right
					- If the sum is less than 0, we need a larger number so increment left
					- If the sum is equal to 0
						- Add the three numbers to the result
						- While left is less than right and the left number is the same as the next left number, increment left to avoid duplicates
						- While left is less than right and the right number is the same as the next right number, decrement right to avoid duplicates
						- Increment left
						- Decrement right
		- Return the result
*/

class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val sortedNums = nums.sorted()
        val result: MutableList<List<Int>> = mutableListOf()

        for ( i in 0 until sortedNums.size ) { 
            if (sortedNums[i] > 0) break
            
            if (i > 0 && sortedNums[i] == sortedNums[i-1]) continue
            
            var left = i+1
            var right = sortedNums.size - 1

            while (left < right) {
                val sum = sortedNums[left] + sortedNums[i] + sortedNums[right]

                when {
                    sum > 0 -> right--
                    sum < 0 -> left++
                    else -> {
                        result.add(listOf(sortedNums[i], sortedNums[left], sortedNums[right]))
                        while (left < right && sortedNums[left] == sortedNums[left + 1]) left++
                        while (left < right && sortedNums[right] == sortedNums[right - 1]) right--
                        left++
                        right--
                    }
                }
            }
        }

        return result
    }
}