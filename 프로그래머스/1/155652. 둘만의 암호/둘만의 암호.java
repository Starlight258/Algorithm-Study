class Solution {
    public char moveStep(char s, String skip, int index){
        int cnt = 0;
        while (true){
            if (cnt==index) break;
            if (s == 'z'){
                s = 'a';
            } else s++;
            while (skip.contains(s+"")){
                if (s == 'z'){
                    s = 'a';
                } else s++;
            }
            cnt++;
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