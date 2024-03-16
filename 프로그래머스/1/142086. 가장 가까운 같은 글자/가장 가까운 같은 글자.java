import java.util.HashMap;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            answer[i] = i - hm.getOrDefault(ch, i+1);
            hm.put(ch, i);
        }
        return answer;
    }
}