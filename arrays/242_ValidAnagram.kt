/*
	https://leetcode.com/problems/valid-anagram/description/
	Time:
	Space:
	Algorithm:
*/

class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val charCount = IntArray(26)

        s.forEachIndexed { i, _ ->
            charCount[ s[i] - 'a' ]++
            charCount[ t[i] - 'a' ]--
        }

        return charCount.all { count -> count == 0 }
    }
}