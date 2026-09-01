class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int startX = -1, startY = -1;
        int[][] litterId = new int[m][n];
        int numLitter = 0;
        
        // Find the start position and map each litter to a unique bit index
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                litterId[i][j] = -1;
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    startX = i;
                    startY = j;
                } else if (c == 'L') {
                    litterId[i][j] = numLitter++;
                }
            }
        }
        
        if (numLitter == 0) return 0;
        
        int fullMask = (1 << numLitter) - 1;
        
        // bestEnergy[x][y][mask] stores the maximum energy encountered for a specific state
        int[][][] bestEnergy = new int[m][n][1 << numLitter];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                java.util.Arrays.fill(bestEnergy[i][j], -1);
            }
        }
        
        java.util.Queue<int[]> q = new java.util.LinkedList<>();
        // Queue state: [x, y, bitmask, current_energy]
        q.offer(new int[]{startX, startY, 0, energy});
        bestEnergy[startX][startY][0] = energy;
        
        int[] dirs = {-1, 0, 1, 0, -1};
        int steps = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0], c = curr[1], mask = curr[2], e = curr[3];
                
                for (int d = 0; d < 4; d++) {
                    int nr = r + dirs[d];
                    int nc = c + dirs[d + 1];
                    
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        char nextCell = classroom[nr].charAt(nc);
                        if (nextCell == 'X') continue;
                        
                        int nextE = e - 1;
                        if (nextE < 0) continue; // Skip if we don't have enough energy to make the move
                        
                        if (nextCell == 'R') {
                            nextE = energy; // Reset to max capacity
                        }
                        
                        int nextMask = mask;
                        if (nextCell == 'L') {
                            nextMask |= (1 << litterId[nr][nc]);
                        }
                        
                        if (nextMask == fullMask) return steps + 1;
                        
                        // Only add to queue if we arrive at this state with strictly more energy
                        if (nextE > bestEnergy[nr][nc][nextMask]) {
                            bestEnergy[nr][nc][nextMask] = nextE;
                            q.offer(new int[]{nr, nc, nextMask, nextE});
                        }
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
}