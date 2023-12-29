/*
	https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
	Time: O(n)
	Space: O(1)
	Algorithm:
		- Iterate through the array
		- Store the lowest price so far
		- If the current price is higher than the lowest price, calculate the profit
		- Return the maximum profit
*/

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        var lowest = prices[0]

        prices.forEach { 
            lowest = min(it, lowest)
            if (it >= lowest) profit = max(profit, it - lowest)
            // lowest = lowest.coerceAtMost(it)
            // profit = profit.coerceAtLeast(it - lowest)
        }

        return profit    
    }
}