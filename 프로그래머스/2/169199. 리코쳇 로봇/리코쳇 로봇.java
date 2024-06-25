import java.util.*;

class Solution {
    static char[][] graph;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    class Node{
        int y;
        int x;
        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    public int bfs(Node start, Node goal){
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        int[][] visited = new int[graph.length][graph[0].length];
        visited[start.y][start.x] = 1;
        // bfs 수행
        while (!q.isEmpty()){
            Node cur = q.poll();
            for (int i=0;i<4;i++){
                int y = cur.y;
                int x = cur.x;
                if (graph[y][x] == 'G') break;
                while (true){
                    y += dy[i];
                    x += dx[i];
                    if (y<0||x<0||y>=graph.length||x>=graph[0].length) break;
                    if (graph[y][x] == 'D') break;
                }
                y -= dy[i];
                x -= dx[i];
                if (visited[y][x]==0){
                    visited[y][x] = visited[cur.y][cur.x]+1;
                    q.add(new Node(y, x));
                }
            }
        }
        return visited[goal.y][goal.x] - 1;
    }
    public int solution(String[] board) {
        int answer = 0;
        graph = new char[board.length][];
        for (int i=0;i<board.length;i++){
            graph[i] = board[i].toCharArray();
        }
        Node start = new Node(0, 0);
        Node goal = new Node(0, 0);
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length();j++){
                if (graph[i][j] == 'R'){
                    start = new Node(i, j);
                }
                if (graph[i][j] == 'G'){
                    goal = new Node(i, j);
                }
            }
        }
        //1. bfs 수행
        answer = bfs(start, goal);
        return answer;
    }
}