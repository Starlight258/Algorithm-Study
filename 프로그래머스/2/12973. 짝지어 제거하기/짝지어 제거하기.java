import java.util.Stack;

class Solution
{
    public int solution(String str)
    {
        Stack<Character> stk = new Stack<>();
        for (char c: str.toCharArray()){
            if (!stk.isEmpty() && stk.peek() == c){
                stk.pop();
            } 
            else stk.push(c);
        }
        if (stk.isEmpty()) return 1;
        else return 0;
    }
}