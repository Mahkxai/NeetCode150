/*
	https://leetcode.com/problems/valid-parentheses/description/
	Time: O(n)
	Space: O(n)
	Algorithm:
		- Use a stack to keep track of the opening parentheses
		- Iterate through the string
			- If we encounter an opening paren, push it onto the stack
			- If we encounter a closing paren and the stack is empty, return false
			- If we encounter a closing paren, check if the top of the stack is the complement
				- If it is, pop it off the stack
				- If it isn't, return false
		- If we reach the end of the string and the stack is not empty, return false
*/

class Solution {
    fun isValid(s: String): Boolean {
        if (s.length % 2 != 0) return false

        val parenMap = hashMapOf(
            ')' to '(',
            '}' to '{',
            ']' to '['
        )
        val stack = Stack<Char>()

        for (c in s) {
            if (!parenMap.containsKey(c)) { 
                stack.push(c) 
                continue
            }

            if (stack.isEmpty()) return false

            val prevParen = stack.pop() 
            val curParenComplement = parenMap[c]
            if (curParenComplement != prevParen) return false
        }

        return stack.isEmpty()
    }
}