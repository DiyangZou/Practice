package Easy;

public class Validpalindrome {
    public boolean valid(String input) {
        // Write your solution here
//        char[] in = input.toCharArray();
//        int left = 0, right = in.length - 1;
//        while(left < right){
//            while(left < right && !Character.isLetterOrDigit(in[left])){
//                left++;
//            }
//            while(left < right && !Character.isLetterOrDigit(in[right])){
//                right--;
//            }
//            if(Character.toLowerCase(in[left]) != Character.toLowerCase(in[right])){
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;

        String actual = input.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }

    public static void main(String[] args) {
        Validpalindrome s = new Validpalindrome();
        boolean result = s.valid("mnojkk5onm");
        System.out.print(result);
    }
}
