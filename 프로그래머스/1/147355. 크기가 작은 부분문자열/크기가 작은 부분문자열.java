
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int n = p.length();
        int left = 0;
        while (left+n<=t.length()){
            boolean isAnswer = true;
            for (int i=0;i<n;i++){
                if (t.charAt(left+i) > p.charAt(i)){
                    isAnswer = false;
                    break;
                }
                if (t.charAt(i+left) < p.charAt(i)){
                    break;
                }
                if (t.charAt(i+left) == p.charAt(i)){
                    continue;
                } 
            }
            if (isAnswer){
              answer++;
            } 
            left++;
        }
        return answer;
    }
    // t, p
    // t에서 p와 길이가 같은 부분문자열중에서 <= p : 횟수 
    // 최대 10_000번 반복 -> 구현
}