import java.util.*;

class Solution {
    
    private char[] vowels = new char[]{'A', 'E', 'I', 'O', 'U'};
    private int answer = 0;
    private boolean isFound = false;
    
    public int solution(String word) {        
        findWord(new StringBuilder(), word);
        return answer-1;
    }
    
    private void findWord(StringBuilder cur, String word){
        if (isFound || cur.length()>5){
            return;
        }
        answer++;
        if (word.equals(cur.toString())){
            isFound = true;
        }

        for (int i=0;i<vowels.length;i++){
            cur.append(vowels[i]);
            findWord(cur, word);
            cur.deleteCharAt(cur.length()-1);
        }
        
    }
    
    
    // 6*6*6*6*6 = 36 * 36 * 6 = 7200 쯤 ? 완전탐색
}