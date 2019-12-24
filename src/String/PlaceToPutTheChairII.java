package String;

import java.util.*;

public class PlaceToPutTheChairII {

    private static final char EQUIP = 'E';
    public List<Integer> putChair(char[][] gym) {
        // Write your solution here
        int m = gym.length;
        int n = gym[0].length;

        int curMax = Integer.MAX_VALUE;
        List<Integer> result = null;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int cur = addCost(gym, i, j);
                if(result == null){
                    result = Arrays.asList(i, j);
                }else if(cur < curMax) {
                    result.set(0, i);
                    result.set(1, j);
                    curMax = Math.min(curMax, cur);
                }
            }
        }

        return result;
    }

    private int addCost(char[][] gym, int i, int j){
        boolean[][] visited = new boolean[gym.length][gym[0].length];
        int cost = 0;
        int path = 1;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i, j));
        visited[i][j] = true;

        while(!q.isEmpty()){
            int size = q.size();
            for(int l = 0; l < size; l++){
                Pair cur = q.poll();
                List<Pair> neis = getNei(gym, cur);
                for(Pair nei: neis){
                    if(!visited[nei.i][nei.j]){
                        visited[nei.i][nei.j] = true;
                        if(gym[nei.i][nei.j] == EQUIP){
                            cost += path;
                        }
                        q.offer(nei);
                    }
                }
            }
            path++;
        }
        return cost;
    }

    private List<Pair> getNei(char[][] gym, Pair cur){
        int x = cur.i;
        int y = cur.j;
        int m = gym.length;
        int n = gym[0].length;

        List<Pair> nei = new ArrayList<>();
        if(x + 1 < m){
            nei.add(new Pair(x + 1, y));
        }
        if(x - 1 >= 0){
            nei.add(new Pair(x - 1, y));
        }
        if(y + 1 < n){
            nei.add(new Pair(x, y + 1));
        }
        if(y - 1 >= 0){
            nei.add(new Pair(x, y - 1));
        }
        return nei;
    }

    class Pair{
        public int i;
        public int j;

        public Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        PlaceToPutTheChairII s = new PlaceToPutTheChairII();
        List<Integer> result = s.putChair(new char[][]{{'E', 'E', ' ', 'E', 'E'}, {'E', ' ', 'E', 'E', ' '}, {' ', 'E', ' ', ' ', 'E'}, {'E', ' ', ' ', 'E', ' '}, {'E', ' ', ' ', ' ', 'E'}});
        System.out.print(result);
    }
}
