import java.util.*;

class Solution {
    
    private int[][] visited;
    private int answer = 0;
    
    class Node{
        
        int y;
        int x;
        int robotIndex;
        int routeIndex = 0;
        
        Node (int y, int x, int robotIndex){
            this.y = y;
            this.x = x;
            this.robotIndex = robotIndex;
        }
        
        void moveNext(int destY, int destX){
            if (destY == y){
                // x 이동
                if (destX < x){
                    this.x--;
                } else {
                    this.x++;
                }
                return;
            } 
            // y 이동 
            if (destY < y){
                this.y--;
            } else {
                this.y++;
            }   
        }
    }
    public int solution(int[][] points, int[][] routes) {
        // 초마다 수행
        Deque<Node> deque = new ArrayDeque<>();
        int robotSize = routes.length; // 로봇 개수
        visited = new int[101][101];
        for (int i=0;i<robotSize;i++){
            int[] startPoint = points[routes[i][0]-1];
            deque.offer(new Node(startPoint[0], startPoint[1], i));
            visited[startPoint[0]] [startPoint[1]]++;
        }
        checkConflict();
        
        while (!deque.isEmpty()){
            Iterator<Node> iter = deque.iterator();
            visited = new int[101][101];
            
            while (iter.hasNext()){
                Node cur = iter.next();
                int routeIndex = cur.routeIndex; // 현재 포인트 번호                
                int robotIndex = cur.robotIndex; // 로봇 번호
                int[] dest = routes[robotIndex]; // 포인트
                if (routeIndex == dest.length-1){
                    iter.remove();
                    continue;
                }

                int destY = points[dest[routeIndex+1]-1][0];
                int destX = points[dest[routeIndex+1]-1][1];
                cur.moveNext(destY, destX);
                visited[cur.y][cur.x]++;
                if (cur.y==destY && cur.x == destX){
                    cur.routeIndex++;
                }

            }
            checkConflict();
        }
        
        return answer;
    }
    
    private void checkConflict(){
        for (int i=0;i<=100;i++){
            for (int j=0;j<=100;j++){
                if (visited[i][j] > 1){
                    answer++;
                }
            }
        }
    }
    
    // n개의 포인트
    // 운송 경로 : m개의 포인트 순서대로 방문
    // 로봇 x대, 0초에 동시에 출발, 1초마다 상하좌우 한칸 이동
    // 최단경로로 이동 우선순위 : (r 이동 > c 이동)
    // 충돌 상황 : 같은 좌표에 로봇이 2대 이상 모임
    // routes : [출발 포인트 번호, 도착 포인트 번호]
    // 100 * 100 = 10_000, 최대 100의 로봇 -> 최단거리는 하나 (100번 수행)
    // 최단 거리 : bfs X, r 이동 후 -> c 이동하면 됨
    // 초마다 움직이면서 업데이트
    // 구현문제
}
// 10_000_000