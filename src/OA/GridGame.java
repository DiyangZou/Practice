package OA;

import java.util.*;

public class GridGame {

    public static List<List<Integer>> gridGame(List<List<Integer>> grid, int k, List<String> rules) {
        // Write your code here
        if(grid == null || grid.size() == 0 || grid.get(0).size() == 0){
            return grid;
        }
        Set<Integer> ruleSet = new HashSet<>();
        for(int i = 0; i < rules.size(); i++){
            if(rules.get(i) == "alive"){
                ruleSet.add(i);
            }
        }
        System.out.println(ruleSet);
        int rows = grid.size();
        int cols = grid.get(0).size();

        int[][] dircts = new int[][]{{0,1}, {1,0},{0,-1},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        for(int time = 0; time < k; time++){
            List<List<Integer>> result = new ArrayList<>();
            for(int row = 0; row < rows; row++){
                List<Integer> curResult = new ArrayList<>();
                for(int col = 0; col < cols; col++){
                    int nei = 0;
                    for(int[] dirct :dircts){
                        int curRow = row + dirct[0];
                        int curCol = col + dirct[1];
                        if(curRow >= 0 && curRow < rows && curCol >= 0 && curCol < cols && grid.get(curRow).get(curCol) != 0){
                            nei++;
                        }
                    }
                    curResult.add(nei);
                }
                result.add(curResult);
                for(Integer i: curResult){
                    System.out.print(i);
                }
                System.out.println(" ");
            }
            for(int row = 0; row < rows; row++){
                for(int col = 0; col < cols; col++){
                    if(ruleSet.contains(result.get(row).get(col))){
                        grid.get(row).set(col, 1);
                    }else{
                        grid.get(row).set(col, 0);
                    }
                }
            }
        }
        return grid;
    }


    public static void main(String[] args) {
        GridGame s = new GridGame();
        String[] rules = new String[]{"dead","dead","dead","alive","dead","alive","dead","dead","dead"};
        List<String> rr = new ArrayList<>();
        for(String str: rules){
            rr.add(str);
        }
        List<List<Integer>> sample = new ArrayList<>();
        Integer[][] matrix = new Integer[][]{{0,1,1,0},{1,1,0,0}};
        for(Integer[] m: matrix) {
            sample.add(Arrays.asList(m));
        }
        List<List<Integer>> r = s.gridGame(sample, 2, rr);
        for(List<Integer> cur: r) {
            System.out.print(Arrays.asList(cur.toArray()));
        }
    }

}
