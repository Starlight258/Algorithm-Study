import java.util.*;

class Solution {
    public int solution(String s) {
        int n = s.length();
        int answer = n;
        List<String> str = new ArrayList<>();
        for (int c=1; c<=n/2; c++){
            // 자르기
            str = new ArrayList<>();
            for (int i=0;i<n;i+=c){
                if (i+c>=n){
                    str.add(s.substring(i)); 
                } else {
                    str.add(s.substring(i, i+c)); 
                }
            }
            
            // 같은 경우 count 추가하기
            String prev = "";
            int count = 1;
            StringBuilder sb = new StringBuilder();
            boolean hasAppend = false;
            for (String word:str){
                if (word.equals(prev)){
                    count++;
                    hasAppend = false;
                } else {
                    if (count!=1){
                        sb.append(count);
                    }
                    sb.append(prev);
                    hasAppend = true;
                    count=1;
                }
                prev = word;
            }

            if (count!=1){
                sb.append(count);
            }
            sb.append(prev);

            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
    // 1~n/2 글자까지 쪼개서 count
    // count+글자.. 가장 짧은 것의 길이
}