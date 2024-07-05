class Solution {
    int[][] durability;
    public int solution(int[][] board, int[][] skills) {
        int answer = 0;
        durability = new int[board.length+1][board[0].length+1];
        for (int[] skill:skills){
            check(durability, skill);
        }
        int height = board.length-1;
        int width = board[0].length-1;
        calculate(durability, board);
        answer = findSafeBuilding(board);
        return answer;
    }
    public void check(int[][] d, int[] skill){
        int type = skill[0];
        type = type == 1 ? -1 : 1;
        int r1 = skill[1];
        int c1 = skill[2];
        int r2 = skill[3];
        int c2 = skill[4];
        int degree = skill[5];
        d[r1][c1] += degree * type;
        d[r1][c2+1] += degree * -type;
        d[r2+1][c1] += degree * -type;
        d[r2+1][c2+1] += degree * type;
    }
    public void calculate(int[][] d, int[][] board){
        int height = board.length-1;
        int width = board[0].length-1;
        // 아래쪽으로 가기
        for (int c=0;c<=width+1;c++){
            for (int r=0;r<=height;r++){
                d[r+1][c] += d[r][c];
            }
        }
        // 왼쪽으로 가기
        for (int r=0;r<=height+1;r++){
            for (int c=0;c<=width;c++){
                d[r][c+1] += d[r][c];
            }
        }
        // 원본 배열에 더하기
        for (int r=0;r<=height;r++){
            for (int c=0;c<=width;c++){
                board[r][c] += d[r][c];
            }
        }
    }
    public int findSafeBuilding(int[][] board){
        int cnt = 0;
        for (int[] b:board){
            for (int e:b){
                if (e>0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}