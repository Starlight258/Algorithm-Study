import java.util.HashMap;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character, Integer> hm = new HashMap<>();
        char[] sList = s.toCharArray();
        for (int i=0;i<sList.length;i++) {
            answer[i] = i - hm.getOrDefault(sList[i], i+1);
            hm.put(sList[i], i);
        }
        return answer;
    }
}