class Solution {
    public int solution(String str) {
        int answer = 0;
        int fCnt = 0;
        int rCnt = 0;
        char first = str.charAt(0);
        for (int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if (c==first) fCnt++;
            else rCnt++;
            if (c != first && fCnt == rCnt){
                answer++;
                first = i >= str.length()-1 ? first : str.charAt(i+1);
            }
            else if (i == str.length()-1) answer++;
        }
        return answer;
    }
}