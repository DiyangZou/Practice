package Array;

import com.sun.jdi.connect.Connector;

public class RemoveAdjacentRepeatedCharactersII {

    public String deDup(String input) {
        if(input == null|| input.length() <= 2){
            return input;
        }
        int j = 0;
        int count = 1;

        char[] in = input.toCharArray();
        for(int i = 1; i < input.length(); i++){
            if(in[i-1] != in[i]){
                j++;
                in[j] = in[i];
                count = 1;
            }else{
                if(count < 2){
                    j++;
                    in[j] = in[i];
                    count++;
                }
            }
        }
        //String res = (String)in.toString().substring(0,j+1);
        String res = new String(in);
        return res.substring(0, j+1);
    }

    public static void main(String[] args){
        RemoveAdjacentRepeatedCharactersII s = new RemoveAdjacentRepeatedCharactersII();
        String res = s.deDup("aaaavvvvvbbbbbs");
        System.out.println(res);
    }
}
