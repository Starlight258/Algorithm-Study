import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> tmp = new TreeMap<>();
        for (String op:operations){
            String[] ar = op.split(" ");
            String command = ar[0];
            Integer number = Integer.parseInt(ar[1]);
            switch (command){
                case "I" : 
                    tmp.put(number, tmp.getOrDefault(number, 0)+1);
                    break;
                case "D":
                    if (tmp.isEmpty()){
                        continue;
                    }
                    int key;
                    if (number==1){
                        key = tmp.lastKey();
                    } else {
                        key = tmp.firstKey();
                    }
                    int count = tmp.getOrDefault(key, 0);
                    if (count==1){
                        tmp.remove(key);
                    } else {
                        tmp.put(key, tmp.get(key)-1);
                    } 
                    break;
            }
        }
        if (tmp.isEmpty()){
            return new int[]{0,0};
        }
        return new int[]{tmp.lastKey(), tmp.firstKey()};
    }
}