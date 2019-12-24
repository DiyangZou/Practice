package RecursionII;

import java.util.ArrayList;
import java.util.List;

public class SpiralPrintII {

    public List<Integer> spiral(int[][] matrix) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        helper(result, matrix, 0, matrix.length, matrix[0].length);
        return result;
    }

    private void helper(List<Integer> result, int[][] matrix, int offset, int sizeM, int sizeN) {
        if (sizeM <= 0 || sizeN <= 0) {
            return;
        }
        if (sizeM == 1 || sizeN == 1) {
            if (sizeM == 1) {
                for (int i = 0; i < sizeN; i++) {
                    result.add(matrix[offset][offset + i]);
                }
            } else {
                for (int i = 0; i < sizeM; i++) {
                    result.add(matrix[offset + i][offset]);
                }
            }
            return;
        }

        for(int i = 0; i < sizeN - 1; i++){
            result.add(matrix[offset][offset + i]);
        }
        for(int i = 0; i < sizeM - 1; i++){
            result.add(matrix[offset + i][offset + sizeN - 1]);
        }
        for(int i = sizeN - 1; i > 0; i--){
            result.add(matrix[offset + sizeM - 1][offset + i]);
        }
        for(int i = sizeM - 1; i > 0; i--){
            result.add(matrix[offset + i][offset]);
        }
        helper(result, matrix, offset + 1, sizeM - 2, sizeN - 2);
    }

    public static void main(String[] args) {
        SpiralPrintII s = new SpiralPrintII();
        List<Integer> res = s.spiral(new int[][]{{1, 2, 3},{4, 5, 6}});
        for(Integer i : res){
            System.out.print(i + " ");
        }
    }

}
