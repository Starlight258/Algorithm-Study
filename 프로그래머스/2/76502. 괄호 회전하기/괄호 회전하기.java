import java.util.*;

class Solution {

    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            if (isValid(rotated)) answer++;
        }
        return answer;
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (!matches(top, c)) return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean matches(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
}