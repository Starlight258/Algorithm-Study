import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        //1. 3진법
        List<Integer> num = new ArrayList<>();
        while (n!=0){
            num.add(n%3);
            n/=3;
        }
        //2. 10진법으로 바꾸기
        int p = 1;
        for (int i=num.size()-1;i>=0;i--){
            answer += p * num.get(i);
            p *= 3;
        }
        return answer;
    }
}