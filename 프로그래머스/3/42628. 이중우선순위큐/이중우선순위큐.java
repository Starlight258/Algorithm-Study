import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (String operation:operations){
            String[] splited = operation.split(" ");
            String command = splited[0];
            int number = Integer.parseInt(splited[1]);
            if (command.equals("I")){
                map.put(number, map.getOrDefault(number,0)+1);
            } else if (command.equals("D")){
                if (map.isEmpty()){
                    continue;
                }
                int key = 0;
                if (number == 1){ // 최댓값 삭제
                    key = map.lastKey();
                    
                } else {
                    key = map.firstKey();
                    
                }
                int count = map.get(key);
                if (count==1){
                    map.remove(key);
                } else {
                    map.put(key, count-1);
                }
            }
        }
        if (map.isEmpty()){
            return new int[]{0,0};
        }
        
        return new int[]{map.lastKey(), map.firstKey()};
    }
}