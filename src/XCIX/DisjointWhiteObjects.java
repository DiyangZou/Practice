package XCIX;

import java.util.Deque;
import java.util.LinkedList;

public class DisjointWhiteObjects {
    public int whiteObjects(int[][] matrix) {
        // Write your solution here
    /*
    The given image is represented by a integer matrix and all the values in the matrix are 0 or 1
    The given matrix is not null
    */

        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] visited = new boolean[m][n];
        Deque<Node> current = new LinkedList<>();
        int result = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0 && !visited[i][j]){
                    current.offerFirst(new Node(i, j));
                    justify(matrix, visited, current);
                    result++;
                }
            }
        }

        return result;
    }

    private void justify(int[][] matrix, boolean[][] visited, Deque<Node> cur){
        while(!cur.isEmpty()){
            Node node = cur.pollFirst();
            int x = node.x;
            int y = node.y;
            if(x+1 < matrix.length && matrix[x+1][y]== 0 && !visited[x+1][y]){
                cur.offerFirst(new Node(x+1, y));
                visited[x+1][y] = true;
            }
            if(x-1 >=0 && matrix[x-1][y]== 0 && !visited[x-1][y]){
                cur.offerFirst(new Node(x-1, y));
                visited[x-1][y] = true;
            }
            if(y+1 < matrix[0].length && matrix[x][y+1]== 0 && !visited[x][y+1]){
                cur.offerFirst(new Node(x, y+1));
                visited[x][y+1] = true;
            }
            if(y-1 >=0 && matrix[x][y-1]== 0 && !visited[x][y-1]){
                cur.offerFirst(new Node(x, y-1));
                visited[x][y-1] = true;
            }
        }
    }
    class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        DisjointWhiteObjects s = new DisjointWhiteObjects();
        int result = s.whiteObjects(new int[][]{{1,0,1,0,0},{1,0,0,1,0},{0,0,1,0,0},{0,0,0,1,0},{0,1,0,0,0}});
        System.out.print(result);
    }
}
