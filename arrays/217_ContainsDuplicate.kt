/*
	https://leetcode.com/problems/contains-duplicate/
	Time: O(n)
	Space: O(n)
	Algorithm: Create a set and add each element to it. If the element is already in the set, return true.
*/ 


class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val dummy = mutableSetOf<Int>()
        nums.forEach { n ->
            if (n in dummy) return true
            dummy.add(n)
        }
        return false
    }
}