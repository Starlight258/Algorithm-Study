import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] servers = new int[24];
        int n = players.length;
        for (int i=0;i<n;i++){
            int need = players[i] / m;
            if (need > servers[i]){
                answer += need-servers[i];
                // 저장 
                int quota = need-servers[i];
                for (int j=i;j<i+k && j<n;j++){
                    servers[j] += quota;
                }
            }
        }
        
        return answer;
    }
    // n대의 서버
    // m명 늘어날때마다 -> 서버 1대 추가 필요
    // m명 미만 -> 서버 증설 필요X
    // 이용자: n*m ~ (n+1)*m : 최소 n대의 증설된 서버가 운영중
    // 한번 증설한 서버는 k시간동안 운영 후 반납 
    //  모든 게임 이용자가 게임을 하기 위한 서버 증설 횟수
    // m = 3, k= 5
    // 단순 구현 -> 시간복잡도 O(n) 
    // 1000 * 1000 = 1_000_000
}