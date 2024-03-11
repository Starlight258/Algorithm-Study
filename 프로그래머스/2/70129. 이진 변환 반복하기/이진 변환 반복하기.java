import java.util.ArrayList;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt = 0;
        int numCnt = 0;
        while (s.length()>1){
            // 0 제거하기
            cnt += s.length(); 
            s = s.replaceAll("0", "");
            cnt -= s.length();
           
            // 2진법으로 표현하기
            int num = s.length();
            StringBuffer numStr = new StringBuffer("");
            s = Integer.toBinaryString(num);
            numCnt++;
        }
        
        answer[0] = numCnt;
        answer[1] = cnt;
        
         return answer;
    }
}
