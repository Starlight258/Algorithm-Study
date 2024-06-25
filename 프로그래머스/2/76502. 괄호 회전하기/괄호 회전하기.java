import java.util.*;
class Solution {
    public int solution(String s) {
        // 1. 가능한 모든 문자열 구하기
        int answer = 0;
        for (int i=0;i<s.length();i++){
            if (check(s)) answer++;
            s = s.substring(1) + s.charAt(0);
        }
        return answer;
    }
    public boolean check(String s){
        int count = 0;
        Stack<Character> stk = new Stack<>();
        for (char c:s.toCharArray()){
            if (c=='(' || c=='{'||c=='[') stk.push(c);
            else if (!stk.isEmpty() && (checkOtherSide(c) == stk.peek())){
                stk.pop();
            } else return false;
        }
        if (!stk.isEmpty()) return false;
        return true;
    }
    char checkOtherSide(char c){
        if (c==']') return '[';
        else if (c=='}') return '{';
        else return '(';
    }
}