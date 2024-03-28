import java.util.*;
class Solution {
    boolean solution(String str) {
        int depth = 0;
        for (char s:str.toCharArray()){
            if (s == '('){
                depth++;
            } else {
                if (depth==0){
                    return false;
                }
                depth--;
            }
        }

        return depth == 0;
    }
}