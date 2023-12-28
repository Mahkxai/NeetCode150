/*
	https://leetcode.com/problems/top-k-frequent-elements/
	Time: O(n)
	Space: O(n)
	Algorithm:
		- Create a counter map to count the frequency of each number
		- Create a frequency map to store the number with the same frequency
		- Iterate through the frequency map from the end to the beginning
		- Add the number to the result array until result size is equal to k
		- Return the result array
 */

class Solution {
	fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val counter = hashMapOf<Int, Int>()
        val frequency = List(nums.size + 1) { mutableListOf<Int>() }
        val result = mutableListOf<Int>()

        nums.forEach { n -> 
            counter[n] = counter.getOrDefault(n, 0) + 1
        }

        counter.forEach { (num, count) -> 
            frequency[count].add(num)
        }

        for (i in frequency.size - 1 downTo 0) {
            frequency[i].forEach {
                result.add(it)
                if (result.size == k) return result.toIntArray()
            }
        }

        return result.toIntArray()
    }
}