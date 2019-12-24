package AlgSprint;

public class EqualSumPartitionsLaiCode {

    public int getMinEqualSumPartition(int N, int[] X) {
        // Write your solution here
        int sum = 0;
        for(int num: X){
            sum += num;
        }

        System.out.println(sum);
        for(int i = N; i >= 1; i--){
            if(sum%i==0){
                int target = sum / i;
                if(helper(N, X, 0, target, 0)){
                    return sum / i;
                }
            }
        }
        return 0;
    }

    private boolean helper(int n, int[] x, int index, int target, int prev){
        if(index == n){
            if(prev == target){
                return true;
            }
            return false;
        }

        if(prev < target){
            prev += x[index];
            return helper(n, x, index+1, target, prev);
        }else if(prev == target) {
            return helper(n, x, index + 1, target, x[index]);
        }
        return false;
    }

    public static void main(String[] args) {
        EqualSumPartitionsLaiCode s = new EqualSumPartitionsLaiCode();
        int result = s.getMinEqualSumPartition(81, new int[]{1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9});
        System.out.println(result);
    }
}
