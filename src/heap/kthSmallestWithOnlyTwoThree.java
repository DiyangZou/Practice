package heap;

import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.PriorityQueue;

public class kthSmallestWithOnlyTwoThree {
    public int kth(int k){
        Queue<Integer> minHeap = new PriorityQueue<>();
        Set<Integer> seen = new HashSet<>();

        minHeap.offer(1);
        seen.add(1);

        while(k > 1){
            int cur = minHeap.poll();
            if(!seen.contains(cur * 2)){
                minHeap.offer(cur *2);
                seen.add(cur*2);
            }
            if(!seen.contains(cur * 3)){
                minHeap.offer(cur * 3);
                seen.add(cur * 3);
            }
            k--;
        }
        return minHeap.peek();
    }

    public static void main(String[] args){
        kthSmallestWithOnlyTwoThree s = new kthSmallestWithOnlyTwoThree();
        int res = s.kth(3);
        System.out.println(res);
    }
}

