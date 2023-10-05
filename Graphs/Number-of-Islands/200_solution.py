'''
    Appraoch 1:
        - BFS
        - Assign Island numbers
            if '0' do nothing
            if '1' check neighbors:
                if all neighbors '0', it's an island
                else bfs 
     
'''

class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """

        rows, cols = len(grid), len(grid[0])
        visited = set()
        islands = 0

        def bfs(r, c):
            q = collections.deque()
            visited.add((r,c))
            q.append((r,c))

            while q:   
                r, c = q.popleft()  # change to .pop() (stack) for dfs!
                directions = [[0, -1], [1, 0], [0, 1], [-1, 0]]

                for dr, dc in directions:
                    row, col = r+dr, c+dc

                    if (row in range(rows) and
                        col in range(cols) and
                        grid[row][col] == "1" and
                        (row, col) not in visited
                    ):
                        q.append((row, col))
                        visited.add((row, col))


        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == "1" and (r, c) not in visited:
                    bfs(r, c)
                    islands += 1

        return islands

