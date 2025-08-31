import java.util.*;

class Solution {
    public boolean solution(String[] phoneBook) {
        Set<String> set = new HashSet<>(Arrays.asList(phoneBook));
        
        for (String phone:phoneBook){
            for (int i=1;i<phone.length();i++){
                if (set.contains(phone.substring(0, i))){
                    return false;
                }
            }
        }

        return true;
    }
    // startsWith -> O(n^2)
    // 문자열 정렬 -> book[i+1].startsWith(book[i]) -> return false; -> O(n)
}