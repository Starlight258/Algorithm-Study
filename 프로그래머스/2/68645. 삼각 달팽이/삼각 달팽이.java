class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        int[][] array = new int[n][n];
        int num = 1;
        int row = 0, col = 0;
        int direction = 0;
        
        while (num <= n * (n + 1) / 2) {
            array[row][col] = num++;
            
            switch (direction) {
                case 0:  // 아래 방향
                    if (row + 1 < n && array[row + 1][col] == 0) {
                        row++;
                    } else {
                        col++;
                        direction = 1;
                    }
                    break;
                case 1:  // 오른쪽 방향
                    if (col + 1 < n && array[row][col + 1] == 0) {
                        col++;
                    } else {
                        row--;
                        col--;
                        direction = 2;
                    }
                    break;
                case 2:  // 대각선 위 방향
                    if (row - 1 >= 0 && col - 1 >= 0 && array[row - 1][col - 1] == 0) {
                        row--;
                        col--;
                    } else {
                        row++;
                        direction = 0;
                    }
                    break;
            }
        }
        
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = array[i][j];
            }
        }
        
        return answer;
    }
}