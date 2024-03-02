package Graph;

public class SurroundedOs {
    public static void dfs(int row, int col, int[][] vis, char[][] mat, int[] delRow, int[] delCol) {
        int n = mat.length;
        int m = mat[0].length;
        vis[row][col] = 1;

        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if ((nRow >= 0) && (nRow < n) && (nCol >= 0) && (nCol < m) && (vis[nRow][nCol] == 0) && (mat[nRow][nCol] == 'O')) {
                dfs(nRow, nCol, vis, mat, delRow, delCol);
            }
        }
    }

    public static void fill(int n, int m, char[][] mat) {
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};
        int[][] vis = new int[n][m];
        //traverse first and last row
        for (int j = 0; j < m; j++) {
            if (vis[0][j] == 0 && mat[0][j] == 'O') {
                dfs(0, j, vis, mat, delRow, delCol);
            }
            if (vis[n - 1][j] == 0 && mat[n - 1][j] == 'O') {
                dfs(n - 1, j, vis, mat, delRow, delCol);
            }
        }
        //traverse first and last col
        for (int j = 0; j < n; j++) {
            if (vis[j][0] == 0 && mat[j][0] == 'O') {
                dfs(j, 0, vis, mat, delRow, delCol);
            }
            if (vis[j][m-1] == 0 && mat[j][m-1] == 'O') {
                dfs(j, m - 1, vis, mat, delRow, delCol);
            }
        }
        //Convert the rest O to X
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && mat[i][j] == 'O') {
                    mat[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        char mat[][] = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};

        // n = 5, m = 4

        fill(4, 4, mat);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
