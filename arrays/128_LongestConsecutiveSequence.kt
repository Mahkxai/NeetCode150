/*
	https://leetcode.com/problems/longest-consecutive-sequence/description/
	Time: O(n)
	Space: O(n)
	Idea:
		Use a set to identify if a number is the start of a sequence and check if the next number exists in the list
	Algorithm:
		- Convert the array to a set
		- Iterate through the array
		- If the current number - 1 is not in the set, then it is the start of a sequence
		- Iterate through the set from the current number + 1 until the number is not in the set
		- Return the max of the current count and the max count
*/

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val numsSet = nums.toSet()
        var count = 0

        nums.forEach { n -> 
            if (n-1 !in numsSet) {
                var curCount = 1
                while(n + curCount in numsSet) curCount++
                count = max(curCount, count)
            }
        }    

        return count
    }
}