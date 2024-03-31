import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int h=0;
        while (h>=0 && h<=citations[citations.length-1]){
            int cnt = 0;
            for (int i=0;i<citations.length;i++){
                if(h<=citations[i]){
                    cnt++;
                }
            }
            if (cnt>=h && cnt > answer){
                answer = h;
            }
            h++;
        }
        
        return answer;
    }
}