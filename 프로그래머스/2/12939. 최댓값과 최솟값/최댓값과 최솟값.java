import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int smallNumber = Integer.MAX_VALUE;
        int maxNumber = Integer.MIN_VALUE;
        String[] sp = s.split(" ");
        for (String spn:sp){
            int n = Integer.parseInt(spn);
            if (n<smallNumber){
                smallNumber = n;
            }
            if (n>maxNumber){
                maxNumber = n;
            }
        }
        
        return smallNumber + " " + maxNumber;
    }
}