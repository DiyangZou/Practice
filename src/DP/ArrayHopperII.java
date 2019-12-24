package DP;

public class ArrayHopperII {

    public int minJump(int[] array){

        int maxS = 0;
        int curStep = 0;

        for(int i = 0; i < array.length; i++){
            if(i > maxS) return -1;

            if(array[i] + i > maxS){
                maxS = array[i] + i;
                curStep++;
            }

            if(maxS >= array.length - 1){
                return curStep;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayHopperII s = new ArrayHopperII();
        int result = s.minJump(new int[]{5,6,0,0,0,10,0,0,0});
        System.out.print(result);
    }
}
