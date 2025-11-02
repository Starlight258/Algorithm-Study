class Solution {
    
    private char[] vowels = new char[]{'A', 'E', 'I', 'O', 'U'};
    private int answer = 0;
    private boolean hasAnswer = false;
    
    public int solution(String word) {
        dfs(new StringBuilder(), word);
        
        return answer;
    }
    
    void dfs(StringBuilder sb, String word){
        if (hasAnswer || sb.length()>5){
            return;
        }
        if (sb.toString().equals(word)){
            hasAnswer = true;
            return;
        }
        
        answer++;
        for (int i=0;i<5;i++){
            sb.append(vowels[i]);
            dfs(sb, word);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

// A -> AA-> AAA -> AAAA -> AAAAA -> AAAAE -> AAAAI -> AAAAO -> AAAAU -> AAAE..
// 완전탐색 : 길이 5 넘어가면 제거, 