import java.util.*;
class Solution {
    public int[] solution(int n, int m, int[][] queries) {
        List<Integer> answers = new ArrayList<>();
        // 0. 사각형을 만든다.
        int[][] squares = new int[n][m];
        int num = 1;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                squares[i][j] = num++;
            }
        }
        // 1. 사각형 끝 부분의 가장 작은 숫자를 저장한다.
        // 2. 시계방향으로 한 칸씩 이동한다.
        for (int[] query:queries){
            int answer = n*m;
            int i1 = query[0]-1;
            int j1 = query[1]-1;
            int i2 = query[2]-1;
            int j2 = query[3]-1;
            int start = squares[i1][j1];
            for (int i=i1;i<i2;i++){
                squares[i][j1] = squares[i+1][j1];
                answer = Math.min(answer, squares[i][j1]);
            }
            for (int j=j1;j<j2;j++){
                squares[i2][j] = squares[i2][j+1];
                answer = Math.min(answer, squares[i2][j]);
            }
            for (int i=i2;i>i1;i--){
                squares[i][j2] = squares[i-1][j2];
                answer = Math.min(answer, squares[i][j2]);
            }
            for (int j=j2;j>j1;j--){
                squares[i1][j] = squares[i1][j-1];
                answer = Math.min(answer, squares[i1][j]);
            }
            squares[i1][j1+1] = start;
            answer = Math.min(answer, squares[i1][j1+1]);
            answers.add(answer);
            
        }
        return answers.stream().mapToInt(x->x).toArray();
    }
}

// 1. 사각형 끝 부분의 가장 작은 숫자를 저장한다.
// 2. 시계방향으로 한 칸씩 이동한다.
// 1 2 3
// 4 5 6
// 7 8 9

// (i1, j1)~(i2,j2) : (i1,j1, i1,j1+1, ..., i1, j2)
// -> (i1,j2 , i1+1, j2, ..., i2,j2)
// -> (i2, j2, i2,j2-1, ..., i2,j1)
// -> (i2,j1, i2-1,j1, ..., i1, j1)