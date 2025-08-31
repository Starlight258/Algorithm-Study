import java.util.*;

class Solution {
    public boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);
        for (int i=0;i<phoneBook.length-1;i++){
            if (phoneBook[i+1].startsWith(phoneBook[i])){
                return false;
            }
        }
        return true;
    }
    // startsWith -> O(n^2)
    // 문자열 정렬 -> book[i+1].startsWith(book[i]) -> return false; -> O(n)
}