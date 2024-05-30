class Solution {
    
    boolean[][][] visited;
    int answer;
    
    void check(int y, int x, int ny, int nx, int d){
        if (!visited[y][x][d] || !visited[ny][nx][3-d]){
            visited[y][x][d]=true;
            visited[ny][nx][3-d] = true;
            answer++;
        }
    }
    
    public int solution(String dirs) {
        answer = 0;
        visited = new boolean[11][11][4]; // y, x, 방향(u:0,d:1,l:2,r:3)
        int y =5, x = 5;
        
        for (String d:dirs.split("")){
            int ny = y, nx = x;
            switch(d){
                case "U": 
                    if (y+1<=10){
                        ny++;
                        check(y, x, ny, nx, 0);
                    } 
                    break;
                case "D":
                    if (y-1>=0){
                        ny--;
                        check(y, x, ny, nx, 3);
                    } 
                    break;
                case "R":
                    if (x+1<=10){
                        nx++;
                        check(y, x, ny, nx, 1);
                    } 
                    break;
                case "L":
                    if (x-1>=0){
                        nx--;
                        check(y, x, ny, nx, 2);
                    } 
                    break;
            }
            y = ny;
            x = nx;
        }
        
        return answer;
    }
}