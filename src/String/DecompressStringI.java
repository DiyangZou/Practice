package String;

public class DecompressStringI {

    public String decompress(String input) {
        // Write your solution here
        if(input.length() == 0) return input;
        char[] in = input.toCharArray();
        int newLen = getLen(in);
        char[] res = new char[newLen];

        int i = in.length-1;
        int j = newLen-1;

        while(j >= 0){
            if(Character.isDigit(in[i])){
                int count = Integer.parseInt(String.valueOf(in[i]));
                while(count > 0){
                    res[j] = in[i-1];
                    j--;
                    count--;
                }
                i -= 2;
            }else{
                res[j] = in[i];
                i--;
                j--;
            }
        }
        return String.valueOf(res);

    }

    private int getLen(char[] in){
        int len = 0;
        for(int i = in.length-1; i>=0; i--){
            if(Character.isDigit(in[i])){
                len += Integer.parseInt(String.valueOf(in[i]));
                i--;
            }else{
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args){
        DecompressStringI s = new DecompressStringI();
        String res = s.decompress("ap2lec3n");
        System.out.println(res);
    }

}
