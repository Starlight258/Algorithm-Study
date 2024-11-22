import java.util.*;

class Solution {
    
    int[] dy = {-1,0,1,0};
    int[] dx = {0,1,0,-1};
    
    public int solution(int M, int N, String[] BOARD) {
        int answer = 0;
        char[][] board = new char[M][N];
        for (int i=0;i<M;i++){
            for (int j=0;j<N;j++){
                board[i][j]= BOARD[i].charAt(j);
            }
        }
        while (true){
            int count = checkGameCount(board, M, N);
            if (count==0){
                break;
            }
            answer += count;
        }
        return answer;
    }
    
    private int checkGameCount(char[][] board, int m, int n){
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i=0;i<m-1;i++){
            for (int j=0;j<n-1;j++){
                if (board[i][j]=='-') continue;
                if (board[i][j] == board[i][j+1] && board[i][j+1]==board[i+1][j] && board[i+1][j] == board[i+1][j+1]){
                    visited[i][j] = true;
                    visited[i][j+1] = true;
                    visited[i+1][j] = true;
                    visited[i+1][j+1] = true; 
                }
            }
        }
        // 지우기
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (visited[i][j]){
                    count++;
                    board[i][j] = '-';
                }
            }
        }
        if (count==0) return 0;
        // 내리기
        for (int i=0;i<n;i++){
            String line = "";
            for (int j=m-1;j>=0;j--){
                if (board[j][i] == '-') continue;
                line += board[j][i];
            }   
            int pos = m-1;
            for (int j=0;j<line.length();j++){
                board[pos--][i] = line.charAt(j);
            }
            for (int j=pos;j>=0;j--){
                board[pos--][i]='-';
            }
        }
        return count;
    }
}