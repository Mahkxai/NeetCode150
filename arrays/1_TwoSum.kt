/*
	https://leetcode.com/problems/two-sum/submissions/1129147746/
	Time: O(n)
	Space: O(n)
	Algorithm:
		- Create a HashMap to store the complement of the current number and its index
		- Iterate through the array
		- Calculate the complement of the current number
		- If the complement is in the HashMap, return the current index and the index of the complement
		- Else, add the current number and its index to the HashMap
		- Return an empty array if no solution is found
*/

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val complement: HashMap<Int, Int> = HashMap()

        nums.forEachIndexed { i, n -> 
            val diff = target - n

            if (complement.contains(diff)) return intArrayOf(i, complement[diff]!!)
            
            complement[n] = i
        }

        return intArrayOf()
    }
}