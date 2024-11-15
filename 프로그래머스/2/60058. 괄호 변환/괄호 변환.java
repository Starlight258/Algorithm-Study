import java.util.*;

class Solution {
    public String solution(String p) {
        return steps(p);
    }
    
    private String steps(String p){
        if (p.isEmpty() || isCorrect(p)) return p;
        for (int i=1;i<=p.length();i++){
            String u = p.substring(0, i);
            String v = p.substring(i);
            if (isBalanced(u) && isBalanced(v)){
                String result = steps(v);
                if (isCorrect(u)){
                    return u + result;
                } else {
                    return "(" + result + ")" + trans(u);
                }
            }
        }
        return "";
    }
    
    private String trans(String u){
        u = u.substring(1, u.length()-1);
        String result = "";
        for (char c:u.toCharArray()){
            if (c=='(') result += ')';
            else result += '(';
        }
        return result;
    }
    
    // 균형잡힌 괄호 문자열 체크함수
    private boolean isBalanced(String p){
        int leftCount = 0; int rightCount = 0;
        for (char c:p.toCharArray()){
            if (c == '(') leftCount++;
            else rightCount++;
        }
        return leftCount == rightCount;
    }
    
    // 올바른 괄호 문자열 체크함수
    private boolean isCorrect(String p){
        if (!isBalanced(p)) return false;
        Stack<Character> stk = new Stack<>();
        for (char pc:p.toCharArray()){
            if (pc=='('){
                stk.push(pc);
            } else {
                if (!stk.empty()){
                    stk.pop();
                } else return false;
            }
        }
        return stk.isEmpty();
    }
}