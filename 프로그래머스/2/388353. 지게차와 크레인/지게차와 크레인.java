import java.util.*;

class Solution {
    class Node {
        int y;
        int x;
        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    
    private static int[] dy = {-1,0,1,0};
    private static int[] dx = {0,1,0,-1};
    
    private char[][] map;
    private int n;
    private int m;
    private int answer;
    
    public int solution(String[] storage, String[] requests) {
        answer = 0;
        // 1. 패딩하기
        n = storage.length;
        m = storage[0].length();
        map = new char[n+2][m+2];
        
        for (int i=0;i<n+2;i++){
            Arrays.fill(map[i], 'o');
        }
        for (int i=0;i<n;i++){
            char[] s = storage[i].toCharArray();
            System.arraycopy(s, 0, map[i+1], 1, m);
        }
        n+=2;
        m+=2;
        
        // 2. 명령어 확인하기
        for (String request:requests){
            int length = request.length();
            char c = request.charAt(0);
            if (length == 1){
                bfs(c);    
            } else if (length == 2){
                if (c != request.charAt(1)) continue;
                bfsAll(c);
            } 
            
        }
        
        return (n-2) * (m-2) - answer;
    }
    
    private void bfs(char c){
        Queue<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        q.offer(new Node(0, 0));
        visited[0][0] = true;
        while (!q.isEmpty()){
            Node node = q.poll();
            int y = node.y;
            int x = node.x;
            for (int i=0;i<4;i++){
                int ny = y+ dy[i];
                int nx = x + dx[i];
                if (ny<0||nx<0||ny>=n||nx>=m || visited[ny][nx]) continue;
                char cur = map[ny][nx];
                if (!(cur == 'o' || cur==c)){
                    continue;
                }
                if (map[ny][nx] == 'o'){
                    q.offer(new Node(ny,nx));
                } 
                if (map[ny][nx] == c){
                    answer++;
                }
                visited[ny][nx] = true;
            }
        }
        
        // 'o'로 표시
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (visited[i][j] && map[i][j] != 'o'){
                    map[i][j] = 'o';
                }
            }
        }
    }
    
    private void bfsAll(char c){
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (map[i][j] == c){
                    map[i][j] = 'o';
                    answer++;
                }
            }
        }
    }
    
    // 1. 외부에서 접근 가능하도록 하기 -> 패딩하기
    // 2. bfs, -> o인 부분만 계속 queue에 집어넣기, 그 외는 answer++;
}