import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        for (String s:cards1){
            q1.offer(s);
        }
        for (String s:cards2){
            q2.offer(s);
        }
        for (String s:goal){
            if (!q1.isEmpty() && q1.peek().equals(s)){
                q1.poll();
            } else if (!q2.isEmpty() && q2.peek().equals(s)){
                q2.poll();
            } else {
                return "No";
            }
        }
        return answer;
    }
}