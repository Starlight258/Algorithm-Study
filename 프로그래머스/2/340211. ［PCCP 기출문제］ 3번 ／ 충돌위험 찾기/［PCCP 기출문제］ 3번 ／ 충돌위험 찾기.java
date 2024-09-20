import java.util.*;

class Solution {
    class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        Map<Integer, List<Point>> map = new HashMap<>(); // 시간별 로봇 위치 저장

        for (int i = 0; i < routes.length; i++) { // 로봇의 개수
            int level = 1; // 시간
            for (int j = 1; j < routes[i].length; j++) { // 경로 개수
                int currentX = points[routes[i][j - 1] - 1][0];
                int currentY = points[routes[i][j - 1] - 1][1];
                int targetX = points[routes[i][j] - 1][0];
                int targetY = points[routes[i][j] - 1][1];
                
                while (currentX != targetX) {
                    List<Point> pList = map.getOrDefault(level, new ArrayList<>());
                    pList.add(new Point(currentX, currentY));
                    map.put(level++, pList); // 덮어쓰기

                    if (currentX > targetX) 
                        currentX--;
                    else 
                        currentX++;
                }

                while (currentY != targetY) {
                    List<Point> pList = map.getOrDefault(level, new ArrayList<>());
                    pList.add(new Point(currentX, currentY));
                    map.put(level++, pList);

                    if (currentY > targetY) 
                        currentY--;
                    else 
                        currentY++;
                }
                if(j == routes[i].length -1){
                    List<Point> pList = map.getOrDefault(level, new ArrayList<>());
                    pList.add(new Point(currentX, currentY));
                    map.put(level, pList); 
                }
            }
        }
        // 겹치는 곳 찾기
        for (Map.Entry<Integer, List<Point>> entry : map.entrySet()) {
            List<Point> list = entry.getValue();
            Map<Point, Integer> pmap = new HashMap<>(); // 충돌 횟수 구하기
            for (Point p : list) {
                pmap.put(p, pmap.getOrDefault(p, 0) + 1);
            }
            for (Map.Entry<Point, Integer> pentry : pmap.entrySet()) {
                if (pentry.getValue() > 1) {
                    answer++;
                }
            }
        }
        return answer;
    }
}