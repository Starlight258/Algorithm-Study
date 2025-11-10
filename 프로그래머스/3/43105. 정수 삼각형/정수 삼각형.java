class Solution {
    
    private int n;
    
    public int solution(int[][] triangle) {
        n = triangle.length;
        
        for (int i=1;i<n;i++){
            for (int j=0;j<=i;j++){
                if (j==0){
                    triangle[i][j] += triangle[i-1][j];
                    continue;
                }
                if (j==i){
                    triangle[i][j] += triangle[i-1][j-1];
                    continue;
                }
                triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);
            }
        }
        
        int answer = 0;
        for (int i=0;i<n;i++){
            answer = Math.max(answer, triangle[n-1][i]);
        }
        return answer;
    }
    
    // 거쳐간 숫자의 최대값
    // 7(0,0)
    // 3(1,0) 8(1,1)
    // 8(2,0) 1(2,1) 0(2,2)
    // 2 7 4 4
    // 4 5 2 6 5
    // 완전탐색 -> dfs 돌면서 끝 도착하면 최대값 return
    // 두번째 부터 시작, 가장 왼쪽이거나 가장 오른쪽은 update가 안됨
    // t[y][x] = Math.max(t[y-1][x-1], t[y-1][x]);
}