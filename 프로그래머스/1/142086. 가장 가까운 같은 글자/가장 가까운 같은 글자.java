import java.util.HashMap;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character, Integer> hm = new HashMap<>();
        char[] sList = s.toCharArray();
        for (int i=0;i<sList.length;i++) {
            if (hm.containsKey(sList[i])){
                answer[i] = i - hm.get(sList[i]);
            } else {
                answer[i] = -1;
            }
            hm.put(sList[i], i);
        }
        return answer;
    }
}