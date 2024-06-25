import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> mp = new HashMap<>();
        for (String part : participant){
            mp.put(part, mp.getOrDefault(part, 0)+1);
        }
        
        for (String comp: completion){
            mp.put(comp, mp.get(comp)-1);
        }
        for (Map.Entry<String, Integer> entry:mp.entrySet()){
            if (entry.getValue()>0){
                return entry.getKey();
            }
        }
        return "";
    }
}