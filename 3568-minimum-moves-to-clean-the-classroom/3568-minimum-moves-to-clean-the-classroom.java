class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length, n = classroom[0].length();
        int sr = 0, sc = 0, cnt = 0;

        int[][] id = new int[m][n];

        for (int[] x : id)
            java.util.Arrays.fill(x, -1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);

                if (c == 'S') {
                    sr = i;
                    sc = j;
                }

                if (c == 'L')
                    id[i][j] = cnt++;
            }
        }

        int full = (1 << cnt) - 1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc, energy, 0, 0});

        boolean[][][][] seen =
            new boolean[m][n][energy + 1][1 << cnt];

        seen[sr][sc][energy][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] a = q.poll();

            int r = a[0];
            int c = a[1];
            int currEnergy = a[2];
            int mask = a[3];
            int moves = a[4];

            if (mask == full)
                return moves;

            if (currEnergy == 0)
                continue;

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n ||
                    classroom[nr].charAt(nc) == 'X')
                    continue;

                int newEnergy = currEnergy - 1;
                int newMask = mask;

                char x = classroom[nr].charAt(nc);

                // Recharge
                if (x == 'R')
                    newEnergy = energy;

                // Collect litter
                if (x == 'L')
                    newMask |= 1 << id[nr][nc];

                if (!seen[nr][nc][newEnergy][newMask]) {
                    seen[nr][nc][newEnergy][newMask] = true;

                    q.add(new int[]{
                        nr, nc, newEnergy, newMask, moves + 1
                    });
                }
            }
        }

        return -1;
    }
}