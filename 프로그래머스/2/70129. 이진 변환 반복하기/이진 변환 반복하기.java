import java.util.ArrayList;

class Solution {
    public int[] solution(String s) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int cnt = 0;
        int numCnt = 0;
        while (s.length()>1){
            // 0 제거하기
            cnt += s.length(); // 0,1
            s = s.replaceAll("0", "");
            
            if (s.contains("0")){
                while (s.contains("0")){
                    s = s.replaceFirst("0", "");
                    cnt++;
                }
            }
            cnt -= s.length(); // 1
           
            // 2진법으로 표현하기
            int num = s.length();
            StringBuffer numStr = new StringBuffer("");
            s = Integer.toBinaryString(num);
            // while (num != 0){
            //     numStr.append(num % 2);
            //     num /= 2;
            // }
            // s = numStr.reverse().toString();
            numCnt++;
        }
        answer.add(numCnt);
        answer.add(cnt); 
        
         return answer.stream().mapToInt(x->x).toArray();
    }
}