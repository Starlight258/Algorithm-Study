import java.util.*;

class Solution {
    private final String FRIENDS = "ACFJMNRT";
    private final List<String> cases = new ArrayList<>();
    private int answer = 0;
    private String[] dt;
    private final boolean[] visited = new boolean[8];
    
    public int solution(int n, String[] datas) {
        dt = datas;
        dfs(0, "");
        return answer;
    }
    
    private boolean check(String text){
        for (String data : dt){
            char person1 = data.charAt(0);
            char person2 = data.charAt(2);
            int diff = Math.abs(text.indexOf(person1) - text.indexOf(person2))-1;
            int distance = data.charAt(4) - '0';
            switch (data.charAt(3)){
                case '=':
                    if (diff!=distance) return false;
                    break;
                case '<':
                    if (diff>=distance) return false;
                    break;
                case '>':
                    if (diff<=distance) return false;
                    break;
            }
        }
        return true;
    }
    
    private void dfs(int depth, String temp){
        if (depth == 8){
            if (check(temp)){
                answer++;
            }
            return;
        }
        for (int i=0;i<8;i++){
            if (!visited[i]){
                visited[i] = true;
                dfs(depth+1, temp+FRIENDS.charAt(i));
                visited[i] = false;
            }
        }
    }
}