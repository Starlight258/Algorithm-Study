import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        //1. 3진법
        StringBuffer num = new StringBuffer();
        while (n!=0){
            num.append(n%3);
            n/=3;
        }
        return Integer.parseInt(num.toString(), 3);
    }
}