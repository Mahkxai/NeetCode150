/*
	https://leetcode.com/problems/number-of-islands/description/
	Time: O(n)
	Space: O(n)
	Algorithm:
		- Iterate through the grid
		- If the current cell is 1 and has not been visited
			- DFS on the current cell and mark all connected cells as visited
			- Increment islands
		- Return islands
*/

class Solution {
    fun dfs(grid: Array<CharArray>, r: Int, c: Int, visited: Array<BooleanArray>) {
        if (
            r !in 0 until grid.size ||
            c !in 0 until grid[r].size ||
            visited[r][c] ||
            grid[r][c] == '0'
        ) {
            return
        }

        visited[r][c] = true

        val directions = arrayOf(
            Pair(0, -1), 
            Pair(1, 0), 
            Pair(0, 1), 
            Pair(-1, 0)
        )
        
        for ( (dr, dc) in directions) {
            dfs(grid, r+dr, c+dc, visited)
        }
    }

    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty()) return 0

        val ROWS = grid.size
        val COLS = grid[0].size
        val visited = Array(ROWS) { BooleanArray(COLS) }
        var islands = 0

        for (r in 0 until grid.size) {
            for (c in 0 until grid[r].size) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    this.dfs(grid, r, c, visited)
                    islands++
                }
            }
        }

        return islands
    }
}