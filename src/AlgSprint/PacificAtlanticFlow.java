package AlgSprint;

import java.util.*;

public class PacificAtlanticFlow {

    public static int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        // Write your solution here
        List<List<Integer>> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<Node> pQ = new LinkedList<>();
        Queue<Node> aQ = new LinkedList<>();

        boolean[][] p = new boolean[m][n];
        boolean[][] a = new boolean[m][n];

        for(int i = 0; i < m; i++){
            pQ.offer(new Node(i, 0));
            aQ.offer(new Node(i, n-1));
            p[i][0] = true;
            a[i][n-1] = true;
        }
        for(int i = 0; i < n; i++){
            pQ.offer(new Node(0, i));
            aQ.offer(new Node(m-1, i));
            p[0][i] = true;
            a[m-1][i] = true;
        }

        bfs(matrix, pQ, p);
        bfs(matrix, aQ, a);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(p[i][j] && a[i][j]){
                    List<Integer> res = new ArrayList<>();
                    res.add(i);
                    res.add(j);
                    result.add(res);
                }
            }
        }
        return result;
    }

    private void bfs(int[][] matrix, Queue<Node> q, boolean[][] visited){
        int m = matrix.length;
        int n = matrix[0].length;

        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int[] dir: dirs){
                int row = cur.row + dir[0];
                int col = cur.col + dir[1];
                if(row <0 || row >= m || col < 0 || col >= n || visited[row][col] || matrix[cur.row][cur.col] > matrix[row][col]){
                    continue;
                }
                visited[row][col] = true;
                q.offer(new Node(row, col));
            }
        }
    }

    class Node{
        int row;
        int col;

        public Node(int row, int col){
            this.row = row;
            this.col = col;
        }
    }


    public static void main(String[] args) {
        PacificAtlanticFlow s = new PacificAtlanticFlow();
        List<List<Integer>> result = s.pacificAtlantic(new int[][]{{1,2,2,3},{3,2,3,4},{2,4,5,3},{6,7,1,4}});
        System.out.print(Arrays.toString(result.toArray()));
    }

}
//[0,3],[1,3],[2,2],[3,0],[3,1]
