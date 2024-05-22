import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        List<String> list = new ArrayList<>();
        list.add(words[0]);
        char lastWord = words[0].charAt(words[0].length()-1);
        for (int i=1;i<words.length;i++){
            String word = words[i];
            
            if (lastWord != word.charAt(0) || word.length()==1 || list.contains(word)){
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                return answer;
            }
            list.add(word);
            lastWord = word.charAt(word.length()-1);
        }

        return new int[]{0,0};
    }
}