package Graph;

import java.util.Deque;
import java.util.LinkedList;

public class DepthOfForest {
    public int depth(int[] forest) {
        // Write your solution here
        Deque<Integer> stack = new LinkedList<>();

        for(int i = 0; i < forest.length; i++){
            if(forest[i] == -1){
                stack.offerFirst(i);
            }
        }
        if(stack.isEmpty()) return -1;

        int trees = forest.length;
        int result = 0;
        while(!stack.isEmpty()){
            int size = stack.size();
            result++;
            for(int i = 0; i < size; i++){
                int cur = stack.pollLast();
                trees--;
                for(int j = 0; j < forest.length; j++){
                    if(forest[j] == cur){
                        stack.offerFirst(j);
                    }
                }
            }
        }
        System.out.println(result);
        System.out.println(trees);
        return trees == 0 ? result:-1;
    }

    public static void main(String[] args) {
        DepthOfForest s = new DepthOfForest();
        int result = s.depth(new int[]{2,2,-1,5,5,-1,3});
        System.out.print(result);
    }
}
