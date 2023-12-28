/*
	https://leetcode.com/problems/valid-palindrome/description/
	Time: O(n)
	Space: O(1)
	Algorithm:
		- Filter the string to only contain alphanumeric characters and convert it to lowercase
		- Create a left pointer and a right pointer
		- Iterate through the string until the two pointers meet
		- If at any point the characters at the two pointers are not equal, return false
		- If the two pointers meet, string is a palindrome, return true
*/

class Solution {
    fun isPalindrome(s: String): Boolean {        
        val filteredS =  s.filter { char -> char.isLetterOrDigit() }.lowercase()
        var left = 0
        var right = filteredS.length - 1

        while (right > left) {
            if (filteredS[left] != filteredS[right]) return false
            left++
            right--
        }

        return true
    }
}