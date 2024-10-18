import java.util.*;

class Solution {
    long minX = Long.MAX_VALUE, minY = Long.MAX_VALUE;
    long maxX = Long.MIN_VALUE, maxY = Long.MIN_VALUE;
    Set<Point> points = new HashSet<>();

    public String[] solution(int[][] line) {
        // 모든 선의 쌍에 대해 교차점 찾기
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point intersection = findIntersection(line[i], line[j]);
                if (intersection != null) {
                    points.add(intersection);
                    updateBounds(intersection);
                }
            }
        }

        // 결과 문자열 배열 생성
        int height = (int) (maxY - minY+1);
        int width = (int) (maxX - minX + 1);
        char[][] grid = new char[height][width];
        for (char[] row:grid){
            Arrays.fill(row, '.');
        }

        // 별 그리기
        for (Point point:points){
            int x = (int) (point.x - minX);
            int y = (int) (maxY - point.y);
            grid[y][x] = '*';
        }

        // 결과를 문자열 배열로 변환
        String[] result = new String[height];
        for (int i=0;i<height;i++){
            result[i] = new String(grid[i]);
        }
        return result;
    }

    private Point findIntersection(int[] line1, int[] line2){
        long a = line1[0], b=line1[1], e=line1[2];
        long c = line2[0], d = line2[1], f = line2[2];
        long deno = a*d - b*c;
        if (deno==0) return null;
        
        long xNumerator = b*f-e*d;
        long yNumerator = e*c-a*f;
        if (xNumerator % deno !=0 || yNumerator%deno !=0) return null;
        
        return new Point(xNumerator/deno, yNumerator/deno);
    }

    private void updateBounds(Point p) {
        minX = Math.min(minX, p.x);
        maxX = Math.max(maxX, p.x);
        minY = Math.min(minY, p.y);
        maxY = Math.max(maxY, p.y);
    }

    private static class Point {
        long x, y;
        Point(long x, long y) {
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
}