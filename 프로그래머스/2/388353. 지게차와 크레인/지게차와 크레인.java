import java.util.*;

class Solution {
    
    class Node{
        int y;
        int x;
        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    
    private static int[] dy = {-1,0,1,0};
    private static int[] dx = {0,1,0,-1};
    private int n;
    private int m;
    private int answer = 0;
    private char[][] arr;
    
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        // 0. 패딩하기
        arr = new char[n+2][m+2];
        
        for (int i=0;i<n+2;i++){
            Arrays.fill(arr[i], 'o'); // air
        }
        for (int i=0;i<n;i++){
            char[] s = storage[i].toCharArray();
            System.arraycopy(s, 0, arr[i+1], 1, m);
        }
        n+=2;
        m+=2;
        
        // 요청 확인하기
        for (String request:requests){
            int size = request.length();
            char c = request.charAt(0);
            if (size==1){
                contactAir(arr, c);
            } else if(size==2){
                if (request.charAt(0) != request.charAt(1)){
                    continue;
                }
                visitAll(arr, c);
            } else {
                continue;
            }
        }
        return (n-2)*(m-2) - answer;
    }
    
    private void contactAir(char[][] arr, char target){
        Queue<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        q.offer(new Node(0, 0));
        visited[0][0] = true;
        
        while (!q.isEmpty()){
            Node node = q.poll();
            int y = node.y;
            int x = node.x;
            for (int i=0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny<0||nx<0||ny>=n||nx>=m || visited[ny][nx]) continue;
                char c = arr[ny][nx];
                if (c!= target && c!='o') continue;
                if (c == 'o'){
                    q.offer(new Node(ny,nx));
                }
                visited[ny][nx] = true;
            }
        }
        
        // 방문한 곳 o로 표시
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (visited[i][j] && arr[i][j] != 'o'){
                    arr[i][j] = 'o';
                    answer++;
                }
            }
        }
    }
    
    private void visitAll(char[][] arr, char c){
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (arr[i][j] == c){
                    answer++;
                    arr[i][j] = 'o';
                }
            }
        }
    }
    
    // 1. 패딩하기 -> 표시하기
    // 2. bfs로 표시하기 
    // 3. 
    
}