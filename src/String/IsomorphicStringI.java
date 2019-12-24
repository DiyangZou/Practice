package String;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStringI {
    public boolean isomorphic(String source, String target) {
        // Write your solution here
        //   if(source.length() != target.length()){
        //     return false;
        //   }

        //   char[] s = source.toCharArray();
        //   char[] t = target.toCharArray();

        //   Map<Character, Character> map = new HashMap<>();
        //   for(int i = 0; i < s.length; i++){
        //     if(map.containsKey(s[i])){
        //       if(map.get(s[i]) != t[i]){
        //         return false;
        //       }
        //     }else{
        //       if(map.containsValue(t[i])){
        //         return false;
        //       }
        //     }
        //     map.put(s[i], t[i]);
        //   }
        //   return true;
        // }

        Map m = new HashMap();
        for (Integer i=0; i<source.length(); ++i) {
            Integer a = (Integer) m.put(source.charAt(i), i);
            Integer b = (Integer) m.put(target.charAt(i) + "", i);
            if (a != b)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicStringI s = new IsomorphicStringI();
        boolean result = s.isomorphic("abd", "xyx");
    }
}
