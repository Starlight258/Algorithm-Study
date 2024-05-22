import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        
        set.add(words[0]);
        char lastChar = words[0].charAt(words[0].length()-1);
        
        for (int i=1;i<words.length;i++){
            String word = words[i];
            set.add(word);
            
            if (lastChar != word.charAt(0) || word.length()==1 || 
                set.size() != i+1){
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                return answer;
            }
            
            lastChar = word.charAt(word.length()-1);
        }

        return new int[]{0,0};
    }
}