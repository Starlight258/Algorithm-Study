import java.util.*;
import java.util.stream.Collectors;

class Solution {
    HashSet<Integer> hs;
    boolean[] visited;
    String[] part;
    public boolean isPrime(int n){
        if ( n <=1) return false;
        for (int i=2;i*i<=n;i++){
            if (n%i==0) return false;
        }
        return true;
    }
    
    public void makeNumber(int index, String sum){
        if(!sum.isEmpty()){
            hs.add(Integer.parseInt(sum));
        }
        for (int i=0;i<part.length;i++){
            if (!visited[i]){
                visited[i] = true;
                makeNumber(index+1, sum+part[i]);
                visited[i] = false;
            }
        }
    }
    
    public int solution(String numbers) {
        int answer = 0;
        hs = new HashSet<>();
        visited = new boolean[numbers.length()];
        part = numbers.split("");
        makeNumber(0, "");
        answer = hs.stream()
            .filter(this::isPrime)
            .collect(Collectors.toList())
            .size();
        return answer;
    }
}