/*
	https://leetcode.com/problems/pacific-atlantic-water-flow/
	Time: O(n*m)
	Space: O(n*m)
	Algorithm:
		- Create 2 arrays to store whether a cell is reachable from the Pacific and Atlantic
		- Iterate through the edges of the grid and perform DFS on each cell
			- For the top and left edges, perform DFS with the Pacific array, marking all reachable cells as true
			- For the bottom and right edges, perform DFS with the Atlantic array, marking all reachable cells as true
		- Iterate through the grid and add the cells that are reachable from both oceans to the result
*/

class Solution {
	val directions = arrayOf(
		   Pair(0, -1), 
		   Pair(1, 0), 
		   Pair(0, 1), 
		   Pair(-1, 0)
	   )

   fun dfs(r: Int, c: Int, heights: Array<IntArray>, visited: Array<BooleanArray>, prevHeight: Int = Int.MIN_VALUE) {
	   if (
		   r !in 0 until heights.size ||
		   c !in 0 until heights[r].size ||
		   visited[r][c] ||
		   heights[r][c] < prevHeight
	   ) {
		   return
	   }

	   visited[r][c] = true

	   directions.forEach { (dr, dc) ->
		   dfs(r + dr, c + dc, heights, visited, heights[r][c])
	   }

   }

   fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
	   if (heights.isEmpty()) return emptyList()

	   val ROWS = heights.size
	   val COLS = heights[0].size
	   val pacificReachable = Array(ROWS) { BooleanArray(COLS) }
	   val atlanticReachable = Array(ROWS) { BooleanArray(COLS) }
	   val result: MutableList<List<Int>> = mutableListOf()

	   for (r in 0 until ROWS) {
		   dfs(r, 0, heights, pacificReachable)
		   dfs(r, COLS - 1, heights, atlanticReachable)
	   }

	   for (c in 0 until COLS) {
		   dfs(0, c, heights, pacificReachable)
		   dfs(ROWS-1, c, heights, atlanticReachable)
	   }

	   for (r in 0 until ROWS) {
		   for (c in 0 until COLS) {
			   if (pacificReachable[r][c] && atlanticReachable[r][c]) {
				   result.add(listOf(r,c))
			   }
		   }
	   }

	   return result
   }
}