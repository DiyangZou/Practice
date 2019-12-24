package AlgSprint;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxWaterTrappedII {
    static int[][] directions = new int[][]{{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maxTrapped(int[][] matrix) {
        // Write your solution here
        int m = matrix.length;
        int n = matrix[0].length;

        if(m < 3 ||n < 3){
            return 0;
        }

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] e1, int[] e2){
                return matrix[e1[0]][e1[1]] - matrix[e2[0]][e2[1]];
            }
        });
        initMatrix(visited, m, n, queue);

        int result = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int[] dir: directions){
                int row = cur[0] + dir[0];
                int col = cur[1] + dir[1];
                if(row > 0 && row < m && col > 0 && col < n && !visited[row][col]){
                    visited[row][col] = true;
                    result += Math.max(0, matrix[cur[0]][cur[1]] - matrix[row][col]);
                    queue.offer(new int[]{row, col});
                }
            }
        }
        return result;
    }

    private void initMatrix(boolean[][] visited, int m, int n, Queue<int[]> queue){
        for(int i = 0; i < m; i++){
            visited[i][0] = true;
            visited[i][n-1] = true;
            queue.offer(new int[]{i, 0});
            queue.offer(new int[]{i, n-1});
        }
        for(int i = 0; i < n; i++){
            visited[0][i] = true;
            visited[m-1][i] = true;
            queue.offer(new int[]{0, i});
            queue.offer(new int[]{m-1, i});
        }
    }

    public static void main(String[] args) {
        MaxWaterTrappedII s = new MaxWaterTrappedII();
        int result = s.maxTrapped(new int[][]{{5,8,7,7},{5,2,1,5},{7,1,7,1},{8,9,6,9},{9,8,9,9}});
        System.out.print(result);
    }
}
