package Graph;

public class FloodFill {
    public static void dfs(int row, int col, int[][] ans, int[][] images, int newColor, int[] delRow, int[] delCol, int iniColor) {
        ans[row][col] = newColor;
        int n = images.length;
        int m = images[0].length;
        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && ans[nrow][ncol] != newColor && images[nrow][ncol] == iniColor) { // doesnot have new color and not visted and changed previously
                dfs(nrow, ncol, ans, images, newColor, delRow, delCol, iniColor);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // get initial color
        int iniColor = image[sr][sc];
        int[][] ans = image;
        // delta row and delta column for neighbours
        int delRow[] = {-1, 0, +1, 0};
        int delCol[] = {0, +1, 0, -1};
        dfs(sr, sc, ans, image, newColor, delRow, delCol, iniColor);
        return ans;
    }
    public static void main(String[] args)
    {
        int[][] image =  {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };

        // sr = 1, sc = 1, newColor = 2
        //Solution obj = new Solution();
        //int[][] ans = obj.floodFill(image, 1, 1, 2);
        //for(int i = 0; i < ans.length; i++){
          //  for(int j = 0; j < ans[i].length; j++)
            //    System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }

