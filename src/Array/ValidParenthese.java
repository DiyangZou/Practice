package Array;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidParenthese {
    public boolean isValid(String input) {
        // Write your solution here
        Map<Character, Character> edge = new HashMap<>();
        edge.put('(', ')');
        edge.put('{', '}');
        edge.put('[', ']');

        Deque<Character> stack = new LinkedList<>();
        for(int i = 0; i < input.length(); i++){
            char cur = input.charAt(i);
            if(edge.containsKey(cur)){
                stack.offerFirst(cur);
            }else{
                if(stack.isEmpty()){
                    return false;
                }else if(edge.get(stack.peekFirst())==cur){
                    stack.pollFirst();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String in = ")}{({))[{{[}";
        ValidParenthese s = new ValidParenthese();
        boolean result = s.isValid(in);
        System.out.print(result);
    }
}
