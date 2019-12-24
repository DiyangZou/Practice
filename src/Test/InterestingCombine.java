package Test;

import java.sql.Time;
import java.util.*;

import static java.lang.Character.isDigit;

public class InterestingCombine {

    public int solution(String S, String T) {
        // write your code in Java SE 8
        if(S == null || T == null || S.length() == 0 || T.length() == 0){
            return 0;
        }
        char[] charS = S.toCharArray();
        char[] charT = T.toCharArray();

        Set<Integer> digits = new HashSet<>();
        getDigits(charS, digits);
        getDigits(charT, digits);//get all unique digits

        String[] getValueS = S.split(":");
        String[] getValueT = T.split(":");

        TimeStamp timeS = new TimeStamp(Integer.parseInt(getValueS[0]), Integer.parseInt(getValueS[1]),Integer.parseInt(getValueS[2]));
        TimeStamp timeT = new TimeStamp(Integer.parseInt(getValueT[0]), Integer.parseInt(getValueT[1]),Integer.parseInt(getValueT[2]));

        Iterator<Integer> itr = digits.iterator();
        List<Integer> allNum = new ArrayList<>();
        while(itr.hasNext()){
            allNum.add(itr.next().intValue());
        }

        Set<TimeStamp> result = new HashSet<>();
        TimeStamp t = new TimeStamp();
        List<Integer> curCombine = new ArrayList<>();

        helper(result,0, allNum, curCombine, timeS, timeT, t);

        System.out.print("result:" + result.size() + " ");
        System.out.println("\n");
        for(TimeStamp ts: result){
            System.out.print(ts.hour + ":");
            System.out.print(ts.mins + ":");
            System.out.print(ts.secs + "\n");
        }
        return result.size();
    }

    private void helper(Set<TimeStamp> result, int index, List<Integer> allNum, List<Integer> curC, TimeStamp s, TimeStamp t, TimeStamp cur){
        if(index >= allNum.size()) {
            return;
        }
        for(int i = index; i < allNum.size(); i++){
            if(curC.size() == 2){
                List<Integer> l = new ArrayList<>();
                valueHave(l, curC);
                getTimeStamp(result, l, s, t, 0, cur);
            }else{
                curC.add(allNum.get(i));
                helper(result, i+1, allNum, curC, s, t, cur);
                curC.remove(curC.size()-1);
            }
        }
    }

    private void valueHave(List<Integer> l, List<Integer> curList){
        int val1 = curList.get(0) * 10 + curList.get(0);
        int val2 = curList.get(0) * 10 + curList.get(1);
        int val3 = curList.get(1) * 10 + curList.get(0);
        int val4 = curList.get(1) * 10 + curList.get(1);

        l.add(val1);
        l.add(val2);
        l.add(val3);
        l.add(val4);
    }


    private void getTimeStamp(Set<TimeStamp> result, List<Integer> curList, TimeStamp s, TimeStamp t, int level, TimeStamp res){
        if(level > 2){
            result.add(res);
            return;
        }

        for (int c: curList) {
            if (level == 0) {
                if (c >= 0 && c < 24 && c >= s.hour && c <= t.hour) {
                    res.hour = c;
                    getTimeStamp(result, curList, s, t, level + 1, res);
                }
            } else if (level == 1) {
                if (c >= 0 && c < 60) {
                    res.mins = c;
                    getTimeStamp(result, curList, s, t, level + 1, res);
                }
            } else if (level == 2) {
                if (c >= 0 && c < 60 && c >= s.secs && c <= t.secs) {
                    res.secs = c;
                    getTimeStamp(result, curList, s, t, level + 1, res);
                }
            }
        }
    }

    private void swap(List<Integer> list, int a, int b){
        int temp = list.get(a);
        list.set(a,list.get(b));
        list.set(b, temp);
    }


    private void getDigits(char[] ch, Set<Integer> seen){
        for(int i = 0; i < ch.length; i++){
            if(isDigit(ch[i])){
                seen.add(Character.getNumericValue(ch[i]));
            }
        }
    }

    class TimeStamp{
        int hour;
        int mins;
        int secs;

        public TimeStamp(){};

        public TimeStamp(int hour, int mins, int secs){
            this.hour = hour;
            this.mins = mins;
            this.secs = secs;
        }
    }

    public static void main(String[] args) {
        InterestingCombine s = new InterestingCombine();
        int result = s.solution("22:22:21", "22:22:23");

    }
}
