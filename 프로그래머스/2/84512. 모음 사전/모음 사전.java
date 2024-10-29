import java.util.*;

class Solution {
    private final Character[] alphabet = {'A', 'E', 'I', 'O', 'U'};
    private int count = 0;
    private boolean isTerminated = false;
    
    private void dfs(StringBuilder sb, String word){
        if (sb.length()>5) return;
        if (isTerminated) return;
        if (sb.toString().equals(word)){
            isTerminated = true;
            return;
        }
        count++;
        for (int i=0;i<alphabet.length;i++){
            sb.append(alphabet[i]);
            dfs(sb, word);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
    public int solution(String word) {
        dfs(new StringBuilder(), word);
        return count;
    }
}