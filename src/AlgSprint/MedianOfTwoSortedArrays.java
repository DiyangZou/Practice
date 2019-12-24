package AlgSprint;

public class MedianOfTwoSortedArrays {
    public double median(int[] a, int[] b) {
        // Write your solution here
        // The two given array are not null and at least one of them is not empty
        // The two given array are guaranteed to be sorted

        int m = a.length, n = b.length;
        int mid1 = (m + n + 1)/2, mid2 = (m + n + 2)/2;
        return (helper(a, b, 0, 0, mid1) + helper(a, b, 0, 0, mid2))/2.0;
    }

    private int helper(int[] a, int[] b, int aIdx, int bIdx, int k){
        if(aIdx >= a.length){
            return b[bIdx + k - 1];
        }
        if(bIdx >= b.length){
            return a[aIdx + k - 1];
        }
        if(k == 1){
            return Math.min(a[aIdx], b[bIdx]);
        }
        int aMid = aIdx + k/2 - 1 > a.length ? Integer.MAX_VALUE:a[aIdx + k/2 - 1];
        int bMid = bIdx + k/2 - 1 > b.length ? Integer.MAX_VALUE:b[bIdx + k/2 - 1];
        if(aMid < bMid){
            return helper(a, b, aIdx + k/2, bIdx, k - k/2);
        }else{
            return helper(a, b, aIdx, bIdx + k/2, k - k/2);
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays s = new MedianOfTwoSortedArrays();
        double result = s.median(new int[]{1}, new int[]{2,3,4});
        System.out.print(result);
    }

}
