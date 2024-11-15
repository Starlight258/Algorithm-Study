import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> mp = new HashMap<>();
        for (String phone:phone_book){
            mp.put(phone, 1);
        }
        for (String phone:phone_book){
            for (int i=0;i<phone.length();i++){
                if (mp.containsKey(phone.substring(0, i))){
                    return false;
                }
            }
        }
        return true;
    }
}