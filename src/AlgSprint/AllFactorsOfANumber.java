package AlgSprint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllFactorsOfANumber {

    public List<List<Integer>> factors(int n) {
        // Write your solution here
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        helper(result, res, n, 2);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> res, int n, int start){
        if(n <= 1){
            result.add(new ArrayList<>(res));
            return;
        }

        for(int i = start; i <= n; i++){
            if(n % i == 0){
                res.add(i);
                helper(result, res, n/i, i);
                res.remove(res.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        AllFactorsOfANumber s = new AllFactorsOfANumber();
        List<List<Integer>> result = s.factors(10);
        System.out.print(Arrays.toString(result.toArray()));
    }
}
