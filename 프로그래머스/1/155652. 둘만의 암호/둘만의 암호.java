class Solution {
    public char moveStep(char s, String skip, int index){
        int cnt = 0;
        while (cnt < index){
            s = s == 'z' ? 'a' : (char) (s+1);
            if (!skip.contains(String.valueOf(s))){
                cnt++;
            }
        }
        return s;
    }
    public String solution(String str, String skip, int index) {
        String answer = "";
        for (char s:str.toCharArray()){
            answer += moveStep(s, skip, index);
        }
        return answer;
    }
}