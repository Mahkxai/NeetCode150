
'''
	find lowest from the left
	find highest from the right
	until pointers meet
	return highest - lowest
'''
        

class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """

        smallest, max_profit, profit = prices[0], 0, 0

        for i in range(len(prices)):
            if (prices[i] < smallest): smallest = prices[i]
            else:
                profit = prices[i] - smallest
                if (profit > max_profit): max_profit = profit
        
        return max_profit