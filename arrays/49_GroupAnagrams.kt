/*
	https://leetcode.com/problems/group-anagrams/
	Time: O(n * m) where n is the number of strings and m is the length of the longest string
	Space: O(n * m) where n is the number of strings and m is the length of the longest string
	Algorithm:
		- Create a hashmap of string to list of strings
		- For each string in the array
			- Create an array of 26 ints
			- For each char in the string
				- Increment the count of the char in the array
			- Create a key using the count array
			- Add the string to the list of strings for the key
		- Return the values of the hashmap
*/

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val anagrams: HashMap<String, MutableList<String>> = hashMapOf()

        strs.forEach { str ->
            val count = IntArray(26)
            
            str.forEach { c -> count[ c - 'a' ]++ }   
            
            val key = count.joinToString()

            anagrams.getOrPut(key) { mutableListOf() }.add(str)
        }

        return anagrams.values.toList()
    }
}