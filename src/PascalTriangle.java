import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static List<List<Integer>> generatePascal(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1; i <=n; i++){
            ans.add((generateRow(i)));
        }
        return ans;
    }

    public static List<Integer> generateRow(int row){
        List<Integer> ansRow = new ArrayList<>();
        int ans = 1;
        ansRow.add(ans);
        for(int col = 1; col<row; col++){
            ans = ans * (row-col);
            ans = ans / col;
            ansRow.add(ans);
        }
        return  ansRow;
    }

    public static void main(String[] args) {
        System.out.println(generatePascal(5));
    }

}
