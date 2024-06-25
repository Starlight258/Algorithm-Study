import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> mp = new HashMap<>();
        for (String comp:completion){
            mp.put(comp, mp.getOrDefault(comp, 0) + 1);
        }
        for (String part:participant){
            if (mp.getOrDefault(part, 0) == 0){
                return part;
            }
            mp.put(part, mp.get(part)-1);
        }
        return "";
    }
}