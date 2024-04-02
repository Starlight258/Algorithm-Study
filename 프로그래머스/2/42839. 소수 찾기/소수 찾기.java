import java.util.*;
import java.util.stream.Collectors;

class Solution {
    HashSet<Integer> hs; // 모든 조합의 숫자
    boolean[] visited;
    String[] numList;
    
    boolean isPrime(int n){
        if (n<=1) return false;
        for (int i=2;i*i<=n;i++){
            if (n % i == 0) return false;
        }
        return true;
    }
    
    void makeNumber(String num){
        if (!num.isEmpty()){
            hs.add(Integer.parseInt(num));
        }
        for (int i=0;i<numList.length;i++){
            if (!visited[i]){
                visited[i] = true;
                makeNumber(num+numList[i]);
                visited[i] = false;
            }
        }
    }
    public int solution(String numbers) {
        hs = new HashSet<>();
        visited = new boolean[numbers.length()];
        numList = numbers.split("");
        
        makeNumber("");
        
        return hs.stream().filter(this::isPrime).collect(Collectors.toList()).size();
    }
}