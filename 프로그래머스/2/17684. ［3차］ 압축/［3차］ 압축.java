import java.util.*;
class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i=0;i<26;i++){
            hm.put((char)('A'+i) + "", i+1);
        }
        int dictionaryPos =27;
        int pos = 0;
        int returnValue = 0;
        while (pos<msg.length()){
            StringBuilder word = new StringBuilder(msg.charAt(pos)+"");
            int localPos = pos;
            int extra = -1;
            while (localPos < msg.length() && hm.containsKey(word.toString())){
                extra++;
                returnValue = hm.get(word.toString());
                if (localPos+1 < msg.length()) word.append(msg.charAt(++localPos)+"");
                else break;
            }
            answer.add(returnValue);
            if (!hm.containsKey(word.toString())){
              hm.put(word.toString(), dictionaryPos++);
            } 
            pos++;
            pos += extra;
        }
        return answer.stream().mapToInt(x->x).toArray();
    }
}