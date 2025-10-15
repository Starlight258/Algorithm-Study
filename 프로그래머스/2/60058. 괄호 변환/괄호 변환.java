import java.util.*;

class Solution {
    
    private static int n = 0;
    private static int endIndex = 0;
    
    public String solution(String p) {
        String answer = "";
        if (p.isEmpty() || isCorrect(p)){
            return p;
        }
        
        // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다. 
        // (())()
        // (()) / ()
        // (())() / 
        n = p.length();
        int lastIndex = seperate(n, p);
        String u = p.substring(0, lastIndex+1);
        String v = p.substring(lastIndex+1);
        // 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
        // 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다. 
        if (isCorrect(u)){
            return u + solution(v);
        } else {
            return processFour(u, v);
        }
    }
    
    private int seperate(int n, String p){
        int count = 0;
        int lc = 0, rc = 0;
        boolean hasExit = false;
        for (int i=0;i<p.length();i++){
            char c = p.charAt(i);
            if (c == '('){
                lc++;
            } else if (c == ')'){
                rc++;
            }
            if (lc == rc){
                return i;
            }
        }
        return n-1;
    }
    
    
    // 균형 잡힌 괄호 문자열 : '(' 개수와 ')' 개수가 같음 
    // 올바른 괄호 문자열 : '(' 개수와 ')' 괄호의 짝이 모두 맞음
    // "(()))(" : 각 3개, 올바른 괄호 문자열은 아님
    // 올바른 괄호 문자열
    private boolean isCorrect(String u){
        Deque<Character> deque = new ArrayDeque<>();
        for (char c:u.toCharArray()){
            if (c == '('){
                deque.add(c);                
            } else {
                if (deque.isEmpty()){
                    return false;
                }
                deque.pop();
            }
            
        }
        if (!deque.isEmpty()){
            return false;
        }
        return true;
    }
    
    private String processFour(String u, String v){
        StringBuilder sb = new StringBuilder("(");
        sb.append(solution(v)).append(")");
        int length = u.length();
        String nu = u.substring(1, length-1);
        nu = nu.replace("(", "0");
        nu = nu.replace(")", "1");
        nu = nu.replace("0", ")");
        nu = nu.replace("1", "(");
        sb.append(nu);
        return sb.toString();
    }
}